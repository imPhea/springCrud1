package com.app.demo;

import com.app.demo.model.Employee;
import com.app.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCrudApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringCrudApiApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {
//		Employee employee = new Employee();
//		employee.setFirstName("Bok");
//		employee.setLastName("Sina");
//		employee.setGmailId("sina@gmail.com");
//		employeeRepository.save(employee);
	}
}
