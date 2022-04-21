package com.dojo.ProjectManager.controllers;



import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dojo.ProjectManager.models.User;
import com.dojo.ProjectManager.models.UserProject;
import com.dojo.ProjectManager.services.UserProjectService;
import com.dojo.ProjectManager.services.UserService;



@Controller
public class RootController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private UserProjectService userProjectService;
	
	public RootController
	(
			UserService userService,
			UserProjectService userProjectService

	)
	{
			this.userService=userService;
			this.userProjectService=userProjectService;

	}
	
	
	
	@GetMapping("/")
	public String root_get(Model model)
	{
		return "redirect:/login";
	}
	
	@GetMapping("/projects")
	public String show_book(Model model, HttpSession session)

	{
		if(!userService.IsLoggedIn(session)) return "redirect:/login";
		User user=UserService.GetSession(session);

		ArrayList<UserProject> all_projects=userProjectService.FindByUserId(user.getId());
		ArrayList<UserProject> your_projects=userProjectService.FindByUserIdNot(user.getId());
		model.addAttribute("all_projects",all_projects);
		model.addAttribute("your_projects",your_projects);
		return "all_projects";
		
	}

}
