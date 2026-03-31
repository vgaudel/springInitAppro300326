package fr.dawan.formationspring.controllers;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.dawan.formationspring.entities.Article;
import fr.dawan.formationspring.entities.Emballage;

@Controller
public class ArticleController {

	@GetMapping("/articles")
	public String display(Model model) {
		
		Map<String,Article> articles = new HashMap<String,Article>();
		articles.put("Bd", new Article("One Piece", 7.45, "Manga très populaire", LocalDate.now(), Emballage.SANS));
		articles.put("Roman", new Article("Les furtifs", 25.50, "Un chef d'oeuvre d'Alain Damasio", LocalDate.now(), Emballage.SANS));
		articles.put("Chaussures", new Article("Adidas d'occasion", 17.45, "Usées", LocalDate.now(), Emballage.CARTON));
		articles.put("Papier", new Article("Ramette", 10.99, "Papier de bonne qualité", LocalDate.now(), Emballage.PAPIER));
		model.addAttribute("articles", articles);
		
		return "articles";
	}
	
}
