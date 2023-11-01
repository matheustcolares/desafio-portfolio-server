package com.desafioportfolio.desafioportfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.desafioportfolio.desafioportfolio.*")
@EntityScan("com.desafioportfolio.desafioportfolio.*")
@SpringBootApplication()
public class DesafioPortfolioApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioPortfolioApplication.class, args);
	}

}
