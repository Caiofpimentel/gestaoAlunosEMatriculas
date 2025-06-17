package com.caiofpimentel.gestaoAlunosEMatriculas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GestaoDeAlunosEMatriculasApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestaoDeAlunosEMatriculasApplication.class, args);
	}

}
