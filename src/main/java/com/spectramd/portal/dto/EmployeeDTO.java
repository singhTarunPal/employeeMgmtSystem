package com.spectramd.portal.dto;


import com.spectramd.portal.Entity.Department;
import com.spectramd.portal.Entity.Designation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class EmployeeDTO {
	
	private Long employeeId;
	private String employeeFirstName;
	private String employeeMiddleName;
	private String employeeLastName;
	private Department department;
	private Designation designation;
}

