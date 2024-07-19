package com.daitiks.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.slf4j.*;

import reactor.core.publisher.Mono;

@Component
public class LoggingFilter implements GlobalFilter{

	private Logger logger = LoggerFactory.getLogger(LoggingFilter.class);
	
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		logger.info("Original request path -> {}", exchange.getRequest().getPath());
		return chain.filter(exchange);
		//Vendo qual path foi feita a requisição no console do Api Gateway
	}

}
