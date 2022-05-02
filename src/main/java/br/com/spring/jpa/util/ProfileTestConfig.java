package br.com.spring.jpa.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class ProfileTestConfig {

	/**
	 * Profile h2 TEST database drive
	 * 
	 **/

	@Autowired
	private DataService dataBaseService;

	@Bean
	public void startDatabaseTest() {
		dataBaseService.startDB();
	}
}