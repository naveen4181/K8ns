package com.runnersspace.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.runnerspace.main.RunnersSpaceApplication;
import com.runnersspace.dto.DbConfig;

@RestController
public class ApiController {
	private static final Logger logger = LoggerFactory.getLogger(ApiController.class);

	private final RunnersSpaceApplication runnersSpaceApplication;

	private final ApiProcessorController apiProcessorController;

	@Value("${app.name}")
	private String welcome;

	@Value("${APP_MESSAGE:Not Loaded from Env}")
	private String appNameFromenv;
	@Autowired
	private DbConfig dbConfig;

	@Value("${secret.username:Secrets Not Loaded from Env}")
	private String secretsFromenvUname;

	@Value("${secret.password:Secrets Not Loaded from Env}")
	private String secretsFromenvpassword;

	ApiController(ApiProcessorController apiProcessorController, RunnersSpaceApplication runnersSpaceApplication) {
		this.apiProcessorController = apiProcessorController;
		this.runnersSpaceApplication = runnersSpaceApplication;
	}

	@GetMapping(value = "/")
	public String getStarter() {
		return "Welcome to Spring Boot Home." + welcome + "||" + appNameFromenv;

	}

	@GetMapping(value = "/props")
	public String bracketValidator() {

		return dbConfig.getDname() + "||" + dbConfig.getDpassword();
	}

	@GetMapping(value = "/secrets")
	public String getSecrets() {
		// byte[] decodeUname=Base64.decodeBase64(secretsFromenvUname);
		String decoded = new String(secretsFromenvUname);
		logger.info("Secrets Input Values Recieved :" + System.getenv());
		System.out.println(secretsFromenvUname);
		return decoded.toString();
	}

}
