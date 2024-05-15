package com.digitali.digitalitechnicalchallenge;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class DigitaliTechnicalChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigitaliTechnicalChallengeApplication.class, args);
		log.info("Application runing OK...");
	}
}
