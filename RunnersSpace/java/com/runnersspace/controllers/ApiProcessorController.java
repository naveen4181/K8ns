package com.runnersspace.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.runnersspace.dto.DbConfig;

@RestController
@RequestMapping(value = { "/api" })
public class ApiProcessorController {

    private final DbConfig dbConfig;

	private static final Logger logger = LoggerFactory.getLogger(ApiProcessorController.class);

    ApiProcessorController(DbConfig dbConfig) {
        this.dbConfig = dbConfig;
    }

	@GetMapping(value = "/reverse/{input}")
	public String getReverseNumber(@PathVariable String input) {
		String output = "";

		logger.info("Input Values Recieved :" + input);
		if (input.matches("\\d+")) {
			int number = Integer.valueOf(input);
			int digit = 0;
			int reversed = 0;
			while (number > 0) {
				digit = number % 10;
				number = number / 10;

				reversed = reversed * 10 + digit;
			}

			output = String.valueOf(reversed);
		} else {
			try {

				for (int i = input.length() - 1; i >= 0; i--) {
					output += input.charAt(i);

				}

			} catch (Exception e) {
				logger.error("Exception Occured while Porcessing:" + e.getMessage());
			}

		}
		return output;
	}

	
	
	
	
	
	
	
	
	@GetMapping(value = "/bracketCheck/{input}")
	public String bracketValidator(@PathVariable String input) {
		
		
		
		return"";
	}
	
	
	
	
	
}
