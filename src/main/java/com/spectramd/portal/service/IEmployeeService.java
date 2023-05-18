package com.spectramd.portal.service;

import java.util.List;

import com.spectramd.portal.dto.EmployeeDTO;

public interface IEmployeeService {
	List<EmployeeDTO> getAllEmployees();
	EmployeeDTO getEmployee(Long employeeId);
	EmployeeDTO save(EmployeeDTO newEmployee);
}
