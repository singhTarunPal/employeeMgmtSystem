package com.spectramd.portal.serviceImpl;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spectramd.portal.Entity.Deductions;
import com.spectramd.portal.Entity.Earnings;
import com.spectramd.portal.Entity.Employee;
import com.spectramd.portal.dto.SalaryDTO;
import com.spectramd.portal.dto.adapter.SalaryDTOAdapter;
import com.spectramd.portal.factory.TaxRegimeFactory;
import com.spectramd.portal.model.Salary;
import com.spectramd.portal.repository.DeductionsRepository;
import com.spectramd.portal.repository.EarningsRepository;
import com.spectramd.portal.repository.EmployeeRepository;
import com.spectramd.portal.service.ISalaryService;
import com.spectramd.portal.tax.strategy.*;

@Service
public class SalaryService implements ISalaryService {
	
	private static final Logger log = LoggerFactory.getLogger(SalaryService.class);

	@Autowired
	private DeductionsRepository deductionsRepository;
	
	@Autowired
	private EarningsRepository earningsRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public SalaryDTO getSalary(Long employeeId) {
		
		Optional<Earnings> earnings=null;
		Optional<Deductions> deductions=null;	
		TaxRegimeStrategy employeeTaxRegimeStrategy=null;;
		
		Salary salary = new Salary();
		salary.setEmployeeId(employeeId);
		
		Optional<Employee> employee = employeeRepository.findById(employeeId);
		if (employee.isPresent()) {
			 employeeTaxRegimeStrategy = 
				TaxRegimeFactory.createTaxRegime(employee.get().getTaxRegime().getTaxRegimeCode());
		} 
		
		try {
			 earnings=earningsRepository.findById(employeeId);
			 log.info("Salary Earnings: " + earnings);
		}catch(EntityNotFoundException exc) {
			log.info("EarningsNotFound for employee " + employeeId);
		};
		
		try {
			deductions=deductionsRepository.findById(employeeId);	
			log.info("Salary Deductions: " + deductions);
		}catch(EntityNotFoundException exc) {
			log.info("DeductionsNotFound for employee " + employeeId);
		};
		
		if (deductions.isPresent()) {
			salary = (earnings.isPresent()) 
									? Salary.builder().employeeId(employeeId).earnings(earnings.get()).deductions(deductions.get()).build()
									: null;
		} else {
			salary = (earnings.isPresent()) 
									? Salary.builder().employeeId(employeeId).earnings(earnings.get()).build()
									: null;
		}
		SalaryDTO salaryDTO =  SalaryDTOAdapter.convertSalaryToSalaryDTO(salary);	
		
		if (null!=employeeTaxRegimeStrategy) {
			salaryDTO.setIncomeTax(employeeTaxRegimeStrategy
						.calculateTax(salary.getEarnings(), salary.getDeductions(), salary.getSavings()));
		}
		return salaryDTO;
	}

}
