package fr.dawan.formationspring.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.dawan.formationspring.entities.Article;
import fr.dawan.formationspring.entities.Emballage;
import fr.dawan.formationspring.forms.ArticleForm;
import fr.dawan.formationspring.repositories.FakeArticleRepository;
import jakarta.validation.Valid;

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
	public String display(Model model, @PathVariable("key") Long key) throws Exception {

		List<Article> articles = new ArrayList<Article>();

		Article a = repository.findById(key);
		articles.add(a);
		model.addAttribute("articles", articles);

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

	@GetMapping("/articles/add")
	public String addArticle(@ModelAttribute ArticleForm articleForm) {
		return "addArticle";
	}

	@PostMapping("/articles/add")
	public ModelAndView addArticlePost(@Valid @ModelAttribute ArticleForm articleForm, BindingResult result) {
		ModelAndView mdv= new ModelAndView();
		if (result.hasErrors()) {
			
			mdv.addObject("articleForm", articleForm);
			mdv.addObject("errors", result);
			mdv.setViewName("addArticle");
			
		} else {
			Article article = new Article();
			article.setNom(articleForm.getNom());
			article.setDescription(articleForm.getDescription());
			article.setEmballage(articleForm.getEmballage());
			article.setDateProduction(articleForm.getDateProduction());
			article.setPrix(articleForm.getPrix());
			repository.save(article);
			mdv.setViewName("redirect:/articles");
		}
		return mdv;
	}
}
