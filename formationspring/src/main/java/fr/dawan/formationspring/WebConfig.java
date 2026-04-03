package fr.dawan.formationspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import fr.dawan.formationspring.interceptors.ArticleInterceptor;
import fr.dawan.formationspring.interceptors.PerformanceInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Autowired
	private ArticleInterceptor articleInterceptor;
	@Autowired
	private PerformanceInterceptor performanceInterceptor;
	
    @Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(articleInterceptor).addPathPatterns("/articles/**");
		registry.addInterceptor(performanceInterceptor).excludePathPatterns("/webjars/**");
	}

	@Bean
    MessageSource messageSource() {
		
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("ValidationMessages");
        return messageSource;
		
	}
    
	
}
