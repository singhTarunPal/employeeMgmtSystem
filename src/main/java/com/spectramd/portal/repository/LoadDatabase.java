package com.spectramd.portal.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.spectramd.portal.Entity.Employee;
import com.spectramd.portal.Entity.User;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
  @Autowired
  private PasswordEncoder passwordEncoder;

	/*
	 * @Bean CommandLineRunner initDatabase(EmployeeRepository repository) {
	 * 
	 * return args -> { log.info("Preloading " + repository.save(new Employee(1l,
	 * "Tarunpal"))); log.info("Preloading " + repository.save(new Employee(2l,
	 * "Sumit Taneja"))); }; }
	 * 
	 * @Bean CommandLineRunner initDatabaseAccount(UserRepository repository) {
	 * 
	 * return args -> { log.info("Preloading " + repository.save(new
	 * User("tarun","tarun@spectramedix.com",passwordEncoder.encode("password"))));
	 * log.info("Preloading " + repository.save(new
	 * User("sumit","sumit@spectramedix.com",passwordEncoder.encode("password"))));
	 * }; }
	 */
}