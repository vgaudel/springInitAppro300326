package fr.dawan.springweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldController {

	@GetMapping("/hello")
	public String hello() {
		return "hello"; //Spring ira chercher la vue /WEB-INF/hello.html
 	}
	
}
