package com.xpto.ProjetoERP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration.class})

public class ProjetoErpApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoErpApplication.class, args);
	}

}
