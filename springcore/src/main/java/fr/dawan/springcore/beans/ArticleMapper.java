package fr.dawan.springcore.beans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

 // => Création d'un constructeur sans paramètre
@AllArgsConstructor // => Création d'un constructeur avec un paramètre pour chaque variable d'instance
@Getter             // => Si on place @Getter sur la classe, un getter est créé pour chaque variable d'instance
@Setter             // => Si on place @Setter sur la classe, un setter est créé pour chaque variable d'instance
@ToString(callSuper = true) // => Par défaut, toutes les variables d'instance sont utilisées pour toString

@Component("mapper1")
@Lazy
public class ArticleMapper {

	public ArticleMapper() {
		System.out.println("Création de l'instance ArticleMapper");
	}
	
	private String source;
	
	private String target;
	
}
