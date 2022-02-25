package com.codingdojo.OmikujiForm;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OmikujiController {

	@RequestMapping("/omikuji")
	public String index() {
		return "index.jsp";
	}
	
	@PostMapping("/create")
	public String create(
			@RequestParam(value = "num") Integer num,
			@RequestParam(value = "city") String city,
			@RequestParam(value = "person") String person,
			@RequestParam(value = "profession") String profession,
			@RequestParam(value = "animal") String animal,
			@RequestParam(value = "message") String message, 
			HttpSession session) {
		session.setAttribute("num", num);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("profession", profession);
		session.setAttribute("animal", animal);
		session.setAttribute("message", message);
		
		return "redirect:/omikuji/show";
	}
	
	@RequestMapping("/omikuji/show")
	public String show(HttpSession session, Model model) {
		model.addAttribute("num", session.getAttribute("num"));
		model.addAttribute("city", session.getAttribute("city"));
		model.addAttribute("person", session.getAttribute("person"));
		model.addAttribute("profession", session.getAttribute("profession"));
		model.addAttribute("animal", session.getAttribute("animal"));
		model.addAttribute("message", session.getAttribute("message"));
		
		return "show.jsp";
	}
}
