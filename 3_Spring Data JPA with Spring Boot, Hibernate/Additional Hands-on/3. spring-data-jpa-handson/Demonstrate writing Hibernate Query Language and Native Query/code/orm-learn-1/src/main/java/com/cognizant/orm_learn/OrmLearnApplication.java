package com.cognizant.orm_learn;

import com.cognizant.orm_learn.entity.Employee;
import com.cognizant.orm_learn.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {
	@Autowired
	private EmployeeService employeeService;

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(OrmLearnApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		testGetAllPermanentEmployees();
		testGetAllPermanentEmployeesWithFetch();
		testAverageSalary();
		testNativeQuery();
	}

	private void testGetAllPermanentEmployees() {
		LOGGER.info("Start - Basic HQL");
		List<Employee> employees = employeeService.getAllPermanentEmployees();
		employees.forEach(e -> LOGGER.info("{}", e.getName()));
		LOGGER.info("End");
	}

	private void testGetAllPermanentEmployeesWithFetch() {
		LOGGER.info("Start - Optimized Fetch HQL");
		List<Employee> employees = employeeService.getAllPermanentEmployeesWithFetch();
		employees.forEach(e -> {
			LOGGER.info("Employee: {}, Dept: {}, Skills: {}", e.getName(), e.getDepartment().getName(), e.getSkillList());
		});
		LOGGER.info("End");
	}

	private void testAverageSalary() {
		LOGGER.info("Start - Average Salary");
		Double avg = employeeService.getAverageSalary(2);
		LOGGER.info("Average Salary for dept 2: {}", avg != null ? avg : "No data");
	}

	private void testNativeQuery() {
		LOGGER.info("Start - Native Query");
		List<Employee> employees = employeeService.getAllEmployeesNative();
		employees.forEach(e -> LOGGER.info("Native: {}", e.getName()));
	}
}