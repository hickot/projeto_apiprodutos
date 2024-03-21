package br.com.cotiinformatica.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		//registry.addMapping("/**").allowedOrigins("http://localhost:4200")    Acesso apenas pelo Angular
		registry.addMapping("/**").allowedOrigins("/**")  // Liberado para todos
				.allowedMethods("POST", "PUT", "DELETE", "GET").allowedHeaders("*");
	}
}
