package com.project.Splitwise;

import com.project.Splitwise.Service.initService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SplitwiseApplication implements CommandLineRunner {

	@Autowired
	private initService initService;

	public static void main(String[] args) {
		SpringApplication.run(SplitwiseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Runner from CommandLine");

		initService.init();
	}
}
