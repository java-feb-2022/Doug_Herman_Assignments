package com.codingdojo.DisplayDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class DisplayDateController {

	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String date(Model model) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEEEEEEE', the' dd 'of' MMMMMMMMM, yyyy");
		String date = simpleDateFormat.format(new Date());
		model.addAttribute("date", date);
		
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String time(Model model) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("h:mm a");
		String time = simpleDateFormat.format(new Date());
		model.addAttribute("time", time);
		
		return "time.jsp";
	}
}
