package fr.dawan.springcore.beans;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor  // => Création d'un constructeur sans paramètre
@AllArgsConstructor // => Création d'un constructeur avec un paramètre pour chaque variable d'instance
@Getter             // => Si on place @Getter sur la classe, un getter est créé pour chaque variable d'instance
@Setter             // => Si on place @Setter sur la classe, un setter est créé pour chaque variable d'instance
@ToString(callSuper = true) // => Par défaut, toutes les variables d'instance sont utilisées pour toString

@Component("mapper1")
public class ArticleMapper {

	
	private String source;
	
	private String target;
	
}
