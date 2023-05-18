package com.spectramd.portal.dto;


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
	private String employeeName;
}

