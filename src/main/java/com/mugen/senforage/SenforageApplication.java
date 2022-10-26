package com.mugen.senforage;

import com.mugen.senforage.service.VillageService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import com.mugen.senforage.dto.*;

@SpringBootApplication
@ComponentScan({"com.mugen.senforage.mapping"})
public class SenforageApplication {

	public static void main(String[] args) {
		SpringApplication.run(SenforageApplication.class, args);

		System.out.println("Bienvenue sur Senforage");
	}

}
