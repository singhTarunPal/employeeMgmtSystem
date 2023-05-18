package com.spectramd.portal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.spectramd.portal.dto.EmployeeDTO;
import com.spectramd.portal.service.IEmployeeService;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
	
	private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private IEmployeeService employeeService;

	/**
	 * This method used to return an Employee based on the Id
	 *
	 * @param employeeId
	 * @return String
	 */
	
	@GetMapping(value = "/{id}", produces = "application/JSON")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public @ResponseBody ResponseEntity<Object>  one(@PathVariable Long id) {
		EmployeeDTO empl = employeeService.getEmployee(id);
		log.info("EMployee: " + empl);
		return new ResponseEntity<Object>(new Gson().toJson(empl), HttpStatus.OK);
	}	

	/**
	 * This method used to return all Employees
	 *
	 * @param employeeId
	 * @return String
	 */
	@GetMapping(value = "/", produces = "application/JSON")
	@PreAuthorize("hasRole('ADMIN')")
	public @ResponseBody ResponseEntity<Object> getAllEmployees() {
		return new ResponseEntity<Object>(new Gson().toJson(employeeService.getAllEmployees()), HttpStatus.OK);
	}

	@PostMapping("/")
	EmployeeDTO newEmployee(@RequestBody EmployeeDTO newEmployee) {
		return employeeService.save(newEmployee);
	}

}
