package fr.dawan.formationspring.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.dawan.formationspring.entities.Utilisateur;

@Controller
public class ExempleController {

	@RequestMapping("/exemple")
	public String exemple() {
		return "exemple";
	}
	
	@RequestMapping("/exemple/testmodel")
	public String testModel(Model model) {
		model.addAttribute("msg", "Test du model");
		return "exemple";
	}
	
	@RequestMapping("/exemple/testmodelandview")
	public ModelAndView testModelAndView() {
		ModelAndView mav= new ModelAndView("exemple");
		mav.addObject("msg", "Test de ModelAndView");
		return mav;
	}
	
	@RequestMapping("/exemple/thymeleaf")
	public String testThymeleaf(Model model) {
		
		int val = -40;
		model.addAttribute("val", val);
		
		Utilisateur u1 = new Utilisateur("John", "Baguette");
		model.addAttribute("u1", u1);
		
		double t[]= {1.4,6.7,8.9,3.5,9.1};
		model.addAttribute("tab", t);
		
		Map<String,Integer> ages = new HashMap<String,Integer>();
		ages.put("John", 45);
		ages.put("Jane", 35);
		ages.put("Yves", 63);
		ages.put("Jo", 38);
		model.addAttribute("ages", ages);
		
		int v1=40;
		model.addAttribute("v1", v1);
		
		return "exemplethymeleaf";
	}
}
