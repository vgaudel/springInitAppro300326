package fr.dawan.springcore;

import java.time.LocalDate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.dawan.springcore.beans.ArticleMapper;
import fr.dawan.springcore.beans.ArticleRepository;
import fr.dawan.springcore.beans.ArticleService;
import fr.dawan.springcore.beans.EmployeMapper;
import fr.dawan.springcore.beans.EmployeService;
import fr.dawan.springcore.lombok.Article;
import fr.dawan.springcore.lombok.ArticleDto;
import fr.dawan.springcore.lombok.Employe;
import lombok.NonNull;

public class App {

	public static void main(String[] args) {

		// Exemple Lombok
		Article a1 = new Article("Stylo", 1.5);
		System.out.println(a1.getDescription());

		System.out.println(a1.toString());

		Article a2 = new Article("Stylo", 2.5);

		System.out.println(a1.equals(a2));

		ArticleDto dto1 = new ArticleDto(2, "crayon", 0.6);
		System.out.println(dto1);

		//@NonNull
		//ArticleDto dto2= new ArticleDto(2,null, 0.6);

		// Atelier
		Employe e1 = new Employe("John", "Doe", LocalDate.of(1993, 3, 7), 1800.0, "jdoe@dawan.com");
		System.out.println(e1);
		Employe e2 = new Employe("Jane", "Doe", LocalDate.of(2000, 3, 7), 1900.0, "jdoe@dawan.com");
		System.out.println(e1.equals(e2));

		
		System.out.println("---------------------------------------------------------------");
		//Exemple d'utilisation de Springcore
		// Création du conteneur d'IOC
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		
		EmployeMapper em1 = context.getBean("empMapper1", EmployeMapper.class);
		System.out.println(em1);
		EmployeMapper em2 = context.getBean("empMapper2", EmployeMapper.class);
		System.out.println(em2);
		
		EmployeService es1 = context.getBean("empService1", EmployeService.class);
		System.out.println(es1);
		
		/*//getBeapermet de récupérer les instances des Beans depuis le conteneur
		ArticleMapper m1 = context.getBean("mapper1", ArticleMapper.class); 
		System.out.println(m1);
		
		ArticleRepository r1 = context.getBean("repository1", ArticleRepository.class);
		System.out.println(r1);
		
		ArticleService s1 = context.getBean("service1",ArticleService.class);
		System.out.println(s1);
		
		ArticleMapper m2 = context.getBean("mapper1", ArticleMapper.class); 
		System.out.println(m2);
		ArticleService s2 = context.getBean("service1",ArticleService.class);
		
		ArticleService s3 = context.getBean("service1",ArticleService.class);*/
		
		
	}
}
