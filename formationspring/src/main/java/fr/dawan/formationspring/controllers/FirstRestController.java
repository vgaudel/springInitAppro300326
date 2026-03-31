package fr.dawan.formationspring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FirstRestController {

	@GetMapping("/test")
	public String test(){
		return "Mon API fonctionne correctement !"; 
	}
}
