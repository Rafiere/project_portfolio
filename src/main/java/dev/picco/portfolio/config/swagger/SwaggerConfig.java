package dev.picco.portfolio.config.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI portfolioSwaggerApiDetails() {
		return new OpenAPI()
				.info(new Info().title("Portfolio API")
				                .description("An API for my personal portfolio.")
				                .version("v1.0.0"));
	}
}
