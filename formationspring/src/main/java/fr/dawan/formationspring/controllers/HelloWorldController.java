package fr.dawan.formationspring.controllers;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

	@GetMapping("/hello")
	public String hello(Model model){
		return "helloworld";
	}
	@GetMapping("/bye")
	public String bye(Model model) {
		return "bye-cdas";
	}
	 
	@ModelAttribute("today")
	public LocalDate returnDate() {
		return LocalDate.now();
	}
}
