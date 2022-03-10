package com.codingdojo.DojosAndNinjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.DojosAndNinjas.models.Dojo;
import com.codingdojo.DojosAndNinjas.services.DojoService;

@Controller
public class DojoController {
	private final DojoService dojoService;
	
	public DojoController(DojoService dojoService) {
		this.dojoService = dojoService;
	}
	
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("newDojo") Dojo dojo, Model model) {
		model.addAttribute("dojos", dojoService.allDojos());
		return "newDojo.jsp";
	}
	
	@PostMapping("/dojos/new")
	public String addDojo(@Valid @ModelAttribute("newDojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors())
			return "/newDojo.jsp";
		else {
			dojoService.createDojo(dojo);
			return "redirect:/dojos/new";
		}
	}
	
	@GetMapping("/dojos/{id}")
	public String displayDojo(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dojo", dojoService.findDojo(id));
		return "showDojo.jsp";
	}
}
