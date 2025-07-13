package com.cognizant.spring_learn;

import com.cognizant.spring_learn.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) {
		LOGGER.info("START MAIN");
		displayCountry();
		LOGGER.info("END MAIN");
	}

	public static void displayCountry() {
		LOGGER.info("START displayCountry");

		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = context.getBean("country", Country.class);

		LOGGER.info("Country : {}", country.toString());

		LOGGER.info("END displayCountry");
	}
}
