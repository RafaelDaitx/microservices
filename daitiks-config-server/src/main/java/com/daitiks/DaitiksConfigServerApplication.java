package com.daitiks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class DaitiksConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DaitiksConfigServerApplication.class, args);
	}

}
