package com.budworx.huntmanager.controllers;



import javax.servlet.http.HttpSession;

import com.budworx.huntmanager.models.User;
import com.budworx.huntmanager.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController
{

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
	
	@GetMapping("/home")
	public String show_book(Model model, HttpSession session, User user)

	{
		if(!userService.IsLoggedIn(session)) return "redirect:/login";
		model.addAttribute("user_name",session.getAttribute("user_name"));
		return "index";
		
	}
}