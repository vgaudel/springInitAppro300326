package fr.dawan.formationspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

	@GetMapping("/hello")
	public String hello(){
		return "helloworld";
	}
	@GetMapping("/bye")
	public String bye() {
		return "bye-cdas";
	}
	 
}
