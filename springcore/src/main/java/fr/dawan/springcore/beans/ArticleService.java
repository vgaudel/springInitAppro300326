package fr.dawan.springcore.beans;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@Service("service1")
@Lazy
@Scope("prototype")
public class ArticleService {
	
	
	private ArticleRepository repository;
	
	public ArticleService() {
		System.out.println("Constructeur par défaut de ArticleService");
	}
	
	@Autowired
	public ArticleService(ArticleRepository repository) {
		this.repository = repository;
		System.out.println("Constructeur avec un attribut de ArticleService");
	}
	

}
