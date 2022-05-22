package br.com.spring.jpa.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class ProfileDevConfig {

	/**
	 * Profile mysql DEV database drive
	 * 
	 **/

	@Autowired
	private DataService dataBaseService;

	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;

	@Bean
	public boolean startDatabaseDev() {

		if (strategy.equals("create")) {
			dataBaseService.startDB();
		}

		return false;
	}
}