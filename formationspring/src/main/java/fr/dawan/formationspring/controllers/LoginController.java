package fr.dawan.formationspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;


import fr.dawan.formationspring.forms.LoginForm;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String login(@RequestParam(value="error", required=false) String error, @ModelAttribute("loginForm") LoginForm loginForm ,Model model) {
		if (error != null) {
			model.addAttribute("errorMessage", "Identifiants Invalides");
		}
		return "login";
	}
	
}
