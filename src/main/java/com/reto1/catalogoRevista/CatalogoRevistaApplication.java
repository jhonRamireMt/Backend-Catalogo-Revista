package com.reto1.catalogoRevista;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@EntityScan(basePackages = {"com.reto1.catalogoRevista"})
@SpringBootApplication
public class CatalogoRevistaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogoRevistaApplication.class, args);
	}

}
