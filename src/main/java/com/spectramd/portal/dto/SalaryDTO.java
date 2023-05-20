package com.spectramd.portal.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class SalaryDTO {
	private Long employeeId;

	private EarningsDTO earnings;
	private DeductionsDTO deductions;
	private Integer earningsSum;
	private Integer deductionsSum;
	private Integer incomeTax;
	
}
