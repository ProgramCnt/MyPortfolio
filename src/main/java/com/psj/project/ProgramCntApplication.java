package com.psj.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@org.springframework.context.annotation.ImportResource("classpath:applicationContext.xml")
public class ProgramCntApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgramCntApplication.class, args);
	}

}
