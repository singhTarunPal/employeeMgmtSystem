package com.spectramd.portal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.spectramd.portal.dto.SalaryDTO;
import com.spectramd.portal.model.MessageJSONResponse;
import com.spectramd.portal.service.ISalaryService;

@RestController
@RequestMapping("/api/v1/salary")
public class SalaryController {
	private static final Logger log = LoggerFactory.getLogger(SalaryController.class);

	@Autowired
	private ISalaryService salaryService;

	/**
	 * This method used to return salary of an employee based on the Employee Id
	 *
	 * @param employeeId
	 * @return String
	 */
	
	@GetMapping(value = "/{id}", produces = "application/JSON")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public @ResponseBody ResponseEntity<Object>  one(@PathVariable Long id) {
		SalaryDTO salary = salaryService.getSalary(id);
		log.info("salary for Employee ID : " + id + " is: " + salary);
		return null != salary ? new ResponseEntity<Object>(new Gson().toJson(salary), HttpStatus.OK)
							  : ResponseEntity.ok().body(new MessageJSONResponse("No SalaryFound"));							 
	}	
	
	
}
