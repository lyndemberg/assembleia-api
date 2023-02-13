package br.com.softdesign.assembleia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AssembleiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssembleiaApplication.class, args);
	}

}
