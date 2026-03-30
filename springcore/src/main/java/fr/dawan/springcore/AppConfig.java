package fr.dawan.springcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import fr.dawan.springcore.beans.ArticleMapper;
import fr.dawan.springcore.beans.ArticleRepository;
import fr.dawan.springcore.beans.ArticleService;
import fr.dawan.springcore.beans.EmployeMapper;

@Configuration
@ComponentScan
public class AppConfig {

	@Bean
	public EmployeMapper empMapper1() {
		return new EmployeMapper();
	}
	@Bean
	public EmployeMapper empMapper2() {
		return new EmployeMapper();
	}
}
