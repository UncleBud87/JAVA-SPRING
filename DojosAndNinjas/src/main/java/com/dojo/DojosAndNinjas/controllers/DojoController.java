package com.dojo.DojosAndNinjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.dojo.DojosAndNinjas.models.Dojo;
import com.dojo.DojosAndNinjas.services.DojoService;
import com.dojo.DojosAndNinjas.services.NinjaService;

@Controller
public class DojoController
{
	
	@Autowired
	private DojoService dojoService;
	@Autowired
	private NinjaService ninjaService;
	
	public DojoController(DojoService dojoService)
	{
		this.dojoService=dojoService;
	}
	
	@GetMapping("/dojo")
	public String dojo_new(Model model)
	{
		model.addAttribute("dojo",new Dojo());
		model.addAttribute("dojos",dojoService.ReadAll());
		return "new_dojo";
	}
	
	@PostMapping("/dojo")
	public String dojo_create
	(
			@Valid @ModelAttribute("dojo") Dojo dojo,
			BindingResult res
	)
	{
		if(res.hasErrors())
		{
			return"new_dojo";
		}
		dojoService.Create(dojo);
		return "redirect:/ninja";
	}
	
	@GetMapping("/dojo/{id}")
	public String show_dojo
	(
			@PathVariable("id") Long id,
			Model model
	)
	{
		model.addAttribute("dojo",dojoService.ReadOne(id));
		model.addAttribute("ninja",ninjaService.ReadAll());
		model.addAttribute("ninjas",ninjaService.ReadAll());
		return "dojo_location";
	}
}
