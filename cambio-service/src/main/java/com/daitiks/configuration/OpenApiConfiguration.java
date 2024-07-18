package com.daitiks.configuration;

import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;

@OpenAPIDefinition(info = 
@Info(title = "Cambio Service API",
	  version = "V1",
	  description = "Documentation of Cabio Service API"))
public class OpenApiConfiguration {
	
	@Bean
	public OpenAPI customOpenApi() {
		return new OpenAPI()
				.components(new Components())
				.info(new io.swagger.v3.oas.models.info.Info()
						.title("Cambio Service API")
						.version("V1")
						.license(
								new io.swagger.v3.oas.models.info.License()
								.name("Rafael Daitx")
								.url("https://github.com/RafaelDaitx/")
								));
	}

}
