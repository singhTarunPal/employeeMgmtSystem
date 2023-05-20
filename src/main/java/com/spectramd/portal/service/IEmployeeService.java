package com.spectramd.portal.service;

import java.util.List;

import com.spectramd.portal.dto.EmployeeDTO;

public interface IEmployeeService {
	List<EmployeeDTO> getAllEmployees();
	List<EmployeeDTO> getEmployeesByDesignationCode(String designationCode);
	 List<EmployeeDTO> getEmployeesByDepartmentCode(String departmentCode);
	EmployeeDTO getEmployee(Long employeeId);
	EmployeeDTO save(EmployeeDTO newEmployee);
	
}
