package com.dojo.HelloWorld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HomceController {
	@RequestMapping("")
	public String index() {
		return "Hello World";
	}
	
	@RequestMapping("/world")
	public String world() {
		return "class level annotations are cool too!";
	}
}
