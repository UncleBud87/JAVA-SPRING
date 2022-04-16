package com.dojo.DojosAndNinjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dojo.DojosAndNinjas.models.Ninja;
import com.dojo.DojosAndNinjas.services.DojoService;
import com.dojo.DojosAndNinjas.services.NinjaService;

@Controller
public class NinjaController
{
	@Autowired
	private NinjaService ninjaService;
	@Autowired
	private DojoService dojoService;
	
	public NinjaController
	(
			NinjaService ninjaService,
			DojoService dojoService
	)
	{
		this.ninjaService=ninjaService;
		this.dojoService=dojoService;
	}
	
	@GetMapping("/ninja")
	public String new_ninja(Model model)
	{
		model.addAttribute("ninja",new Ninja());
		model.addAttribute("ninjas",ninjaService.ReadAll());
		model.addAttribute("dojos",dojoService.ReadAll());
		return "new_ninja";
	}
	
	@PostMapping("/ninja")
	public String ninja_create
	(
			@Valid @ModelAttribute("ninja") Ninja ninja,
			BindingResult res,
			Model model
	)
	{
		if(res.hasErrors())
		{
			System.out.println("i messed up");
			model.addAttribute("ninjas",ninjaService.ReadAll());
			return "new_ninja";
		}
		ninjaService.Create(ninja);
		return "redirect:/ninja";
	}
	
}