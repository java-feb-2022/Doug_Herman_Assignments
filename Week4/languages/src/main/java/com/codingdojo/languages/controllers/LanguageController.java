package com.codingdojo.languages.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.languages.models.Language;
import com.codingdojo.languages.services.LanguageService;

@Controller
public class LanguageController {
	private final LanguageService languageService;
	
	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@GetMapping("/languages")
	public String index(@ModelAttribute("newLanguage") Language language,
			Model model) {
		model.addAttribute("languages", languageService.allLanguages());
		
		return "index.jsp";
	}
	
	@PostMapping("/languages")
	public String addLanguage(@Valid @ModelAttribute("newLanguage") Language language, 
			BindingResult result,
			Model model) {
		model.addAttribute("languages", languageService.allLanguages());
		
		if(result.hasErrors())
			return "/index.jsp";
		else {
			languageService.createLanguage(language);
			return "redirect:/languages";
		}
	}
	
	@GetMapping("/languages/{id}/edit")
	public String edit(@PathVariable("id") Long id,
			@ModelAttribute("newLanguage") Language language,
			Model model) {
			model.addAttribute("newLanguage", languageService.findLanguage(id));
			return "edit.jsp";
	}
	
	@PutMapping("/languages/edit")
	public String editLanguage(@Valid @ModelAttribute("newLanguage") Language language,
			BindingResult result) {
		if(result.hasErrors())
			return "edit.jsp";
		else {
			languageService.createLanguage(language);
			return "redirect:/languages";
		}
	}
	
	@GetMapping("languages/{id}")
	public String showLanguage(@PathVariable("id") Long id,
			Model model) {
		model.addAttribute("language", languageService.findLanguage(id));
		return "show.jsp";
	}
	
	@DeleteMapping("/languages/delete/{id}")
	public String destroy(@PathVariable("id") Long id) {
		languageService.deleteLanguage(id);
		return "redirect:/languages";
	}
}
