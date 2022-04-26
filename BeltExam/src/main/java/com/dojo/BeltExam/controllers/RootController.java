package com.dojo.BeltExam.controllers;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dojo.BeltExam.models.User;
import com.dojo.BeltExam.services.SongService;
import com.dojo.BeltExam.services.UserService;

@Controller
public class RootController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private SongService songService;

	
	public RootController
	(
			UserService userService,
			SongService songService

	)
	{
			this.userService=userService;
			this.songService=songService;

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
		model.addAttribute("song",songService.ReadAll());
		model.addAttribute("songs",songService.ReadAll());
		model.addAttribute("user_name",session.getAttribute("user_name"));
		return "index";
		
	}

}
