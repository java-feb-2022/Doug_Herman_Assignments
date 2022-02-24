package com.codingdojo.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterController {
	
	@RequestMapping("/")
	public String index(HttpSession session) {
		
		if(session.getAttribute("count") == null)
			session.setAttribute("count", 1);
		else {
			session.setAttribute("count", ((Integer) session.getAttribute("count")) + 1);
		}
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String counter(HttpSession session, Model model) {
		
		if(session.getAttribute("count") == null)
			session.setAttribute("count", 0);
		
		model.addAttribute("count", (Integer) session.getAttribute("count"));
		return "counter.jsp";
	}
	
	@RequestMapping("/plustwo")
	public String plusTwo(HttpSession session) {
		
		if(session.getAttribute("count") == null)
			session.setAttribute("count", 2);
		else {
			session.setAttribute("count", ((Integer) session.getAttribute("count")) + 2);
		}
		return "index.jsp";
	}
	
	@RequestMapping("/reset")
	public String reset(HttpSession session, Model model) {
		
		session.setAttribute("count", 0);
		
		model.addAttribute("count", (Integer) session.getAttribute("count"));
		return "counter.jsp";
	}
}
