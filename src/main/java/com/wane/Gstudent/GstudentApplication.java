package com.wane.Gstudent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.wane") // Ajoutez cette ligne pour scanner tous les composants sous le package com.wane
@EntityScan(basePackages = "com.wane.data.entities")
@EnableJpaRepositories(basePackages = "com.wane.data.repository")
public class GstudentApplication {
	public static void main(String[] args) {
		SpringApplication.run(GstudentApplication.class, args);
	}
}