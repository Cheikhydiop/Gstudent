package com.wane.Gstudent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.wane.data.entities"})
public class GstudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(GstudentApplication.class, args);
	}

}
