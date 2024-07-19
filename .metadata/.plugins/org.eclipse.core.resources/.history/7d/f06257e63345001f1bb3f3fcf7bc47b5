package com.daitiks.configuration;

import java.util.function.Function;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguraton {

	
	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p.path("/get")
					.filters( f-> 
					f.addRequestHeader("Hello", "World")
					.addRequestParameter("Hello", "World"))
				.uri("http://httpbin.org:80"))
				.route(p -> p.path("/cambio-service/**")
						.uri("lb://cambio-service"))//Acessa os loadbalancers do Eureka
							//quando requisitado a url de cambio-service (os registros do Eureka)
				.route(p -> p.path("/book-service/**")
						.uri("lb://book-service"))
				//A URL fica assim http://localhost:8765/cambio-service/8/USD/BRL e não
				//http://localhost:8765/cambio-service/cambio-service/USD/BRL. Ou seja, quando
				//chega no eureka que estou acessando  o /book-service/, ele já sabe
				// e redireciona a URL para o microserviço em questão
				.build();
	}
}
