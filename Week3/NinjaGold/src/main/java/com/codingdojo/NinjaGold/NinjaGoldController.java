package com.codingdojo.NinjaGold;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NinjaGoldController {

	@RequestMapping("/gold")
	public String index(HttpSession session, Model model) {
		if(session.getAttribute("gold") == null)
			session.setAttribute("gold", 0);
		if(session.getAttribute("activities") == null)
			session.setAttribute("activities", "");
		
		if ((Integer)session.getAttribute("gold") <= -100)
			return "redirect:/prison";
		
		model.addAttribute("gold", (Integer) session.getAttribute("gold"));
		model.addAttribute("activities", (String) session.getAttribute("activities"));
		return "index.jsp";
	}
	
	@RequestMapping("/prison")
	public String prison(HttpSession session, Model model) {
		
		model.addAttribute("gold", (Integer)session.getAttribute("gold"));
		return "prison.jsp";
	}
	
	@PostMapping("/action")
	public String action(HttpSession session, 
			@RequestParam(value = "activity") String activity) {
		System.out.println(activity);
		Random rand = new Random();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMMM dd yyyy hh:mm a");
		String date = simpleDateFormat.format(new Date());
		
		int randNum = 0;
		String activityString;
		
		if(activity.equals("farm"))
			randNum = rand.nextInt(21-10)+10;
		else if (activity.equals("cave"))
			randNum = rand.nextInt(11-5)+5;
		else if (activity.equals("house"))
			randNum = rand.nextInt(6-2)+2;
		else if (activity.equals("casino"))
			randNum = rand.nextInt(51+50)-50;
		else if (activity.equals("spa"))
			randNum = rand.nextInt(-4+20)-20;
		else if (activity.equals("reset")) {
			session.setAttribute("gold", 0);
			session.setAttribute("activities", "");
			return "redirect:/gold";
		}
			
		if(randNum >= 0)
			activityString = String.format("<span class = 'win'>You entered a %s and earned %d gold. (%s)</span><br>", activity, randNum, date);
		else
			activityString = String.format("<span class = 'loose'>You entered a %s and lost %d gold. (%s)</span><br>", activity, randNum, date);
		
		session.setAttribute("gold", (Integer)session.getAttribute("gold") + randNum);
		session.setAttribute("activities", activityString + session.getAttribute("activities"));
		
		return "redirect:/gold";
	}
}
