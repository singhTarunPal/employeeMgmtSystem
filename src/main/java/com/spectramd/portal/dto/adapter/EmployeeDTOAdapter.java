package com.spectramd.portal.dto.adapter;

import java.util.ArrayList;
import java.util.List;

import com.spectramd.portal.Entity.Employee;
import com.spectramd.portal.dto.EmployeeDTO;
import com.spectramd.portal.exception.EmployeeNotFoundException;

public class EmployeeDTOAdapter {

	
	public static EmployeeDTO convertEmployeeToEmployeeDTO(Employee employee) {
		if(null != employee)
		return new EmployeeDTO(employee.getEmployeeId(), employee.getEmployeeName());
		else {
			throw  new EmployeeNotFoundException();
		}
	}
	
	public static List<EmployeeDTO> convertEmployeeToEmployeeDTO(List<Employee> employeeList) {
		
		List<EmployeeDTO> employeeDTOList = new ArrayList<EmployeeDTO>();
		employeeList.forEach(empl -> {
			employeeDTOList.add(new EmployeeDTO(empl.getEmployeeId(), empl.getEmployeeName()));
		});
		return employeeDTOList;
	}
	
	
	
}
