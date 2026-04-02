package fr.dawan.formationspring.controllers;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import fr.dawan.formationspring.entities.Article;
import fr.dawan.formationspring.entities.Emballage;
import fr.dawan.formationspring.repositories.FakeArticleRepository;

@Controller
public class ArticleController {

	@Autowired
	private FakeArticleRepository repository;
	
	@GetMapping("/articles")
	public String display(Model model) {

		model.addAttribute("articles", repository.findAll());

		return "articles";
	}

	@GetMapping("/articles/{key}")
	public String display(Model model, @PathVariable("key") Long key) {

		return "articles";
	}
	
	@GetMapping("/remove/{id}")
	public String remove(@PathVariable long id) {
		try {
			repository.remove(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/articles";
	}

}
