package com.cognizant.orm_learn;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.model.Stock;
import com.cognizant.orm_learn.model.Student;
import com.cognizant.orm_learn.model.Course;
import com.cognizant.orm_learn.model.Department;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import com.cognizant.orm_learn.repository.StudentRepository;
import com.cognizant.orm_learn.repository.CourseRepository;
import com.cognizant.orm_learn.repository.DepartmentRepository;

import com.cognizant.orm_learn.service.CountryService;
import com.cognizant.orm_learn.service.StockService;
import com.cognizant.orm_learn.service.exception.CountryNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;
import java.util.Arrays;
import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
@EntityScan(basePackages = "com.cognizant.orm_learn.model")
@ComponentScan(basePackages = "com.cognizant.orm_learn")
@EnableJpaRepositories(basePackages = "com.cognizant.orm_learn.repository")
public class OrmLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	private static CountryService countryService;
	private static StockService stockService;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		countryService = context.getBean(CountryService.class);
		// testGetAllCountries();
		// testFindCountryByCode();
		// testUpdateCountryName();
		// testQueryCountryMethods();

		stockService = context.getBean(StockService.class);
		//testStockQueryMethods();
	}

	private static void testGetAllCountries() {
		LOGGER.info("Start");
		List<Country> countries = countryService.getAllCountries();
		countries.forEach(System.out::println);
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

	private static void testUpdateCountryName() {
		LOGGER.info("Start");
		try {
			countryService.updateCountryName("IN", "Bharat");
			Country updatedCountry = countryService.findCountryByCode("IN");
			System.out.println("Updated Country: " + updatedCountry);
			LOGGER.debug("Updated Country: {}", updatedCountry);
		} catch (CountryNotFoundException e) {
			LOGGER.error("Exception: {}", e.getMessage());
		}
		LOGGER.info("End");
	}

	private static void testQueryCountryMethods() {
		LOGGER.info("Start");

		List<Country> containing = countryService.getCountriesByNameContaining("ou");
		System.out.println("Countries containing 'ou':");
		containing.forEach(System.out::println);

		List<Country> sorted = countryService.getCountriesByNameContainingSorted("ou");
		System.out.println("Sorted countries containing 'ou':");
		sorted.forEach(System.out::println);

		List<Country> startsWith = countryService.getCountriesStartingWith("Z");
		System.out.println("Countries starting with Z:");
		startsWith.forEach(System.out::println);

		LOGGER.info("End");
	}

	private static void testStockQueryMethods() {
		LOGGER.info("Start");

		List<Stock> fbStocks = stockService.getStocksBetweenDates(
				"FB", LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30));
		System.out.println("Facebook Stocks in Sep 2019:");
		fbStocks.forEach(System.out::println);

		List<Stock> googlStocks = stockService.getStocksAbovePrice("GOOGL", new BigDecimal("1250"));
		System.out.println("GOOGL Stocks with close > 1250:");
		googlStocks.forEach(System.out::println);

		List<Stock> topVolume = stockService.getTopVolumeStocks();
		System.out.println("Top 3 Stocks by Volume:");
		topVolume.forEach(System.out::println);

		List<Stock> lowestNflx = stockService.getLowestCloseStocks("NFLX");
		System.out.println("Lowest Netflix closing prices:");
		lowestNflx.forEach(System.out::println);

		LOGGER.info("End");
	}

	@Bean
	public CommandLineRunner orMappingDemo(StudentRepository studentRepo,
										   CourseRepository courseRepo,
										   DepartmentRepository deptRepo) {
		return args -> {
			LOGGER.info("Start Hands-on 4: O/R Mapping Demo");

			// Create department
			Department dept = new Department();
			dept.setName("Computer Science");
			deptRepo.save(dept);

			// Create courses
			Course c1 = new Course();
			c1.setTitle("Spring Boot");

			Course c2 = new Course();
			c2.setTitle("Java");

			courseRepo.saveAll(Arrays.asList(c1, c2));

			// Create student
			Student student = new Student();
			student.setName("John Doe");
			student.setDepartment(dept);
			student.setCourses(Arrays.asList(c1, c2));
			studentRepo.save(student);

			LOGGER.info("Saved student: {}", student);
			LOGGER.info("End Hands-on 4");
		};
	}
}
