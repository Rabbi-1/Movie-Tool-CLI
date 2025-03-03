package com.example.movietool;

import com.example.movietool.service.commandLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class MovieToolApplication implements CommandLineRunner {
	private final commandLineService commandLine;
	@Autowired
	public MovieToolApplication(commandLineService commandLine) {
		this.commandLine = commandLine;
	}

	public static void main(String[] args) {
		SpringApplication.run(MovieToolApplication.class, args);
	}
	public void run(String... args) throws Exception {

		while (true) {
			System.out.print("tmdb-app --type ");
			Scanner scanner = new Scanner(System.in);
			String userInput = scanner.nextLine();
			commandLine.processCommand(userInput);
		}


	}

}


