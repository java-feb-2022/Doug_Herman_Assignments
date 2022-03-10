package com.codingdojo.DojosAndNinjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.DojosAndNinjas.models.Ninja;
import com.codingdojo.DojosAndNinjas.services.DojoService;
import com.codingdojo.DojosAndNinjas.services.NinjaService;

@Controller
public class NinjaController {
	private final NinjaService ninjaService;
	private final DojoService dojoService;
	
	public NinjaController(NinjaService ninjaService, DojoService dojoService) {
		this.ninjaService = ninjaService;
		this.dojoService = dojoService;
	}
	
	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("newNinja") Ninja ninja, Model model) {
		model.addAttribute("dojos", dojoService.allDojos());
		return "newNinja.jsp";
	}
	
	@PostMapping("/ninjas/new")
	public String addNinja(@Valid @ModelAttribute("newNinja") Ninja ninja, BindingResult result, Model model) {
		model.addAttribute("dojos", dojoService.allDojos());
		
		if(result.hasErrors())
			return "/newNinja.jsp";
		else {
			ninjaService.createNinja(ninja);
			return "redirect:/dojos/" + ninja.getDojo().getId();
		}
	}
}
