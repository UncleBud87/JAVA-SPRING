package com.dojo.BeltExam.controllers;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dojo.BeltExam.models.User;
import com.dojo.BeltExam.services.UserService;

@Controller
public class RootController {
	
	@Autowired
	private UserService userService;

	
	public RootController
	(
			UserService userService

	)
	{
			this.userService=userService;

	}
	
	
	
	@GetMapping("/")
	public String root_get(Model model)
	{
		return "redirect:/login";
	}
	
	@GetMapping("/index")
	public String show_book(Model model, HttpSession session, User user)

	{
		if(!userService.IsLoggedIn(session)) return "redirect:/login";

		model.addAttribute("user_name",session.getAttribute("user_name"));
		return "index";
		
	}

}
