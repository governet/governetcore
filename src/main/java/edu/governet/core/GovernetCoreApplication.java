package edu.governet.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GovernetCoreApplication {
	public static void main(String[] args) {
		for(String arg:args) {
			System.out.println(arg);
		}
		SpringApplication.run(GovernetCoreApplication.class, args);
	}
}
