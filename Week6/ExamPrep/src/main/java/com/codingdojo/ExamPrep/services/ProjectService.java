package com.codingdojo.ExamPrep.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.ExamPrep.models.Project;
import com.codingdojo.ExamPrep.models.User;
import com.codingdojo.ExamPrep.repositories.ProjectRepo;
import com.codingdojo.ExamPrep.repositories.UserRepo;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepo projectRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	public Project createProject(Project p, BindingResult result) {
		Date current = new Date();
		
		if(result.hasErrors())
			return null;
		else if (p.getDueDate().before(current)) {
			result.rejectValue("dueDate", "Matches", "The due date must be in the future.");
			return null;
		}
		else {
			System.out.println(p);
			return projectRepo.save(p);
		}
	}
	
	public List<Project> allProjects(){
		return projectRepo.findAll();
	}
	
	public List<Project> allProjectsWithUser(Long id){
		List<Project> allProjects = projectRepo.findAll();
		List<Project> returnedProjects = new ArrayList<>();
		
		for (Project project : allProjects) {
			if(project.getProjectLead().getId() == id || 
					project.getProjectMembers().contains(userRepo.findById(id).get()))
					returnedProjects.add(project);
		}
		return returnedProjects;
	}
	
	public List<Project> allProjectsWithoutUser(Long id){
		List<Project> projects = projectRepo.findAll();
		List<Project> returnedProjects = new ArrayList<>();
		
		for(Project project : projects) {
			if(project.getProjectLead().getId() != id && 
					!project.getProjectMembers().contains(userRepo.findById(id).get()))
					returnedProjects.add(project);
		}
		
		return returnedProjects;
	}
	
	public Project findProject(Long id) {
		Optional<Project> optionalProject = projectRepo.findById(id);
		if(optionalProject.isPresent())
			return optionalProject.get();
		else
			return null;
	}
	
	public void addMember(Long projectId, Long userId) {
		Project thisProduct = findProject(projectId);
		User thisUser = userRepo.findById(userId).get();
		thisProduct.getProjectMembers().add(thisUser);
		projectRepo.save(thisProduct);
	}
	
	public void removeMember(Long projectId, Long userId) {
		Project thisProduct = findProject(projectId);
		User thisUser = userRepo.findById(userId).get();
		thisProduct.getProjectMembers().remove(thisUser);
		projectRepo.save(thisProduct);
	}
	
	public void deleteProject(Long id) {
		projectRepo.deleteById(id);
	}
}
