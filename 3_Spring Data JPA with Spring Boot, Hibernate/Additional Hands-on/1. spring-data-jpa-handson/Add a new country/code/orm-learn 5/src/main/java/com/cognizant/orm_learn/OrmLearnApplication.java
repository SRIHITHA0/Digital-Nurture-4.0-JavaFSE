package com.cognizant.orm_learn;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryService;
import com.cognizant.orm_learn.service.exception.CountryNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
@EntityScan(basePackages = "com.cognizant.orm_learn.model")
@ComponentScan(basePackages = "com.cognizant.orm_learn")
@EnableJpaRepositories(basePackages = "com.cognizant.orm_learn.repository")
public class OrmLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	private static CountryService countryService;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		countryService = context.getBean(CountryService.class);
		testGetAllCountries();
		testFindCountryByCode();
		testAddCountry(); // 👈 changed this line
	}

	private static void testGetAllCountries() {
		LOGGER.info("Start");

		List<Country> countries = countryService.getAllCountries();

		for (Country country : countries) {
			System.out.println(country);
		}

		LOGGER.info("End");
	}

	private static void testFindCountryByCode() {
		LOGGER.info("Start");

		try {
			Country country = countryService.findCountryByCode("AQ");
			System.out.println(country);
		} catch (CountryNotFoundException e) {
			LOGGER.error("Exception: {}", e.getMessage());
		}

		LOGGER.info("End");
	}

	private static void testAddCountry() {
		LOGGER.info("Start");

		Country newCountry = new Country();
		newCountry.setCode("QP");
		newCountry.setName("Newland");

		countryService.addCountry(newCountry);

		System.out.println("Added Country: " + newCountry);
		LOGGER.debug("Added Country: {}", newCountry);

		LOGGER.info("End");
	}
}
