package com.spectramd.portal.dto.adapter;

import java.util.ArrayList;
import java.util.List;

import com.spectramd.portal.Entity.Employee;
import com.spectramd.portal.dto.EmployeeDTO;
import com.spectramd.portal.exception.EmployeeNotFoundException;

public class EmployeeDTOAdapter {

	
	public static EmployeeDTO convertEmployeeToEmployeeDTO(Employee employee) {
		if(null != employee)
		return EmployeeDTO.builder()
					.employeeId(employee.getEmployeeId())
					.employeeFirstName(employee.getEmployeeFirstName())
					.employeeMiddleName(employee.getEmployeeMiddleName())
					.employeeLastName(employee.getEmployeeLastName())
					.department(employee.getDepartment())
					.designation(employee.getDesignation())
					.build();
		else {
			throw  new EmployeeNotFoundException();
		}
	}
	
	public static List<EmployeeDTO> convertEmployeeToEmployeeDTO(List<Employee> employeeList) {
		
		List<EmployeeDTO> employeeDTOList = new ArrayList<EmployeeDTO>();
		employeeList.forEach(employee -> {
			employeeDTOList.add(EmployeeDTO.builder()
					.employeeId(employee.getEmployeeId())
					.employeeFirstName(employee.getEmployeeFirstName())
					.employeeMiddleName(employee.getEmployeeMiddleName())
					.employeeLastName(employee.getEmployeeLastName())
					.department(employee.getDepartment())
					.designation(employee.getDesignation())
					.build());
		});
		return employeeDTOList;
	}
	
	
	
}
