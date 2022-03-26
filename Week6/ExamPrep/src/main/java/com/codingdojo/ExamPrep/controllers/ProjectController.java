package com.codingdojo.ExamPrep.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.ExamPrep.models.Project;
import com.codingdojo.ExamPrep.models.Task;
import com.codingdojo.ExamPrep.models.User;
import com.codingdojo.ExamPrep.services.ProjectService;
import com.codingdojo.ExamPrep.services.TaskService;

@Controller
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	@Autowired
	private TaskService taskService;
	
	@GetMapping("/dashboard")
	public String home(HttpSession session, Model model) {
		User user = (User)session.getAttribute("user");
		
		if(user == null)
			return "redirect:/";
		else {
			model.addAttribute("user", user);
			model.addAttribute("projectsWithoutUser", projectService.allProjectsWithoutUser(user.getId()));
			model.addAttribute("projectsWithUser", projectService.allProjectsWithUser(user.getId()));
			return "dashboard.jsp";
		}
	}
	
	@GetMapping("/projects/new")
	public String newProject(@ModelAttribute("newProject") Project newProject, HttpSession session, Model model) {
		User user = (User)session.getAttribute("user");
		
		if(user == null)
			return "redirect:/";
		else {
			model.addAttribute("user", user);
			return "addProject.jsp";
		}
	}
	
	@PostMapping("/projects/new")
	public String createProject(
			@Valid @ModelAttribute("newProject") Project newProject, 
			BindingResult result, HttpSession session, Model model) {
		
		projectService.createProject(newProject, result);
		
		if(result.hasErrors()) {
			model.addAttribute("user", session.getAttribute("user"));
			return "addProject.jsp";
		}
		else
			return "redirect:/dashboard";
	}
	
	@GetMapping("/projects/join/{id}")
	public String joinProject(@PathVariable("id") Long id, HttpSession session) {
		User user = (User)session.getAttribute("user");
		if(user == null)
			return "redirect:/";
		else {
			projectService.addMember(id, user.getId());
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/projects/leave/{id}")
	public String leaveProject(@PathVariable("id") Long id, HttpSession session) {
		User user = (User)session.getAttribute("user");
		if(user == null)
			return "redirect:/";
		else {
			projectService.removeMember(id, user.getId());
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/projects/edit/{id}")
	public String editProject(@PathVariable("id") Long id, Model model, HttpSession session) {
		Project project = projectService.findProject(id);
		User user = (User)session.getAttribute("user");
		if(user == null)
			return "redirect:/";
		else if( user.getId() != project.getProjectLead().getId())
			return "redirect:/dashboard";
		else {
			model.addAttribute("project", project);
			return "editProject.jsp";
		}
	}
	
	@PostMapping("/projects/edit/{id}")
	public String changeProject(
			@Valid @ModelAttribute("project") Project project, 
			BindingResult result, HttpSession session, Model model) {
		
		projectService.createProject(project, result);
		
		if(result.hasErrors()) {
			model.addAttribute("user", session.getAttribute("user"));
			return "editProject.jsp";
		}
		else
			return "redirect:/dashboard";
	}
	
	@GetMapping("/projects/{id}")
	public String showProject(@PathVariable("id") Long id, Model model, HttpSession session) {
		User user = (User)session.getAttribute("user");
		
		if(user == null)
			return "redirect:/";
		else {
			model.addAttribute("project", projectService.findProject(id));
			return "showProject.jsp";
		}
	}
	
	@DeleteMapping("/projects/{id}/delete")
	public String removeProject(@PathVariable("id") Long id, HttpSession session) {
		User user = (User)session.getAttribute("user");
		Project project = projectService.findProject(id);
		
		if(user == null)
			return "redirect:/";
		else if(user.getId() != project.getProjectLead().getId())
			return "redirect:/dashboard";
		else {
			projectService.deleteProject(id);
			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/projects/{id}/tasks")
	public String showTasks(@ModelAttribute("newTask") Task newTask,
			@PathVariable("id") Long id, Model model, HttpSession session) {
		User user = (User)session.getAttribute("user");
		Project project = projectService.findProject(id);
		
		if(user == null)
			return "redirect:/";
		else {
			model.addAttribute("project", project);
			model.addAttribute("tasks", taskService.allTasksByProject(project));
			model.addAttribute("user", user);
			return "showTasks.jsp";
		}
	}
	
	@PostMapping("/projects/{id}/tasks")
	public String saveTask(@Valid @ModelAttribute("newTask") Task newTask, BindingResult result, 
			@PathVariable("id") Long id, Model model, HttpSession session) {
		
		if(result.hasErrors())
			return "redirect:/projects/{id}/tasks";
		else {
			taskService.createTask(newTask);
			return "redirect:/projects/{id}/tasks";
		}
	}
}
