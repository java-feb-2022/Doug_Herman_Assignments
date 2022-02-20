package com.codingdojo.HelloHuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloHumanController {
	@RequestMapping("/")
	public String index(@RequestParam(value = "name", required = false) String name, 
			@RequestParam(value = "last_name", required = false) String lastName, 
			@RequestParam(value = "times", required = false, defaultValue = "1") String times) {
		
		String outputString = "Hello ";
		String returnString = "";
		int timesInt = Integer.parseInt(times);
		
		if (name != null)
			outputString += name;
		else 
			outputString += "Human";
		
		if(lastName != null)
			outputString += " " + lastName;
		
		for (int x = 0; x < timesInt; x++)
			returnString += " " + outputString;
		
		return returnString;
	}
}
