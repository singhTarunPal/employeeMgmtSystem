package com.spectramd.portal.model;

import com.spectramd.portal.Entity.Deductions;
import com.spectramd.portal.Entity.Earnings;
import com.spectramd.portal.tax.strategy.TaxRegimeStrategy;

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
public class Salary {
	
	private Long employeeId;

	private Earnings earnings=new Earnings();
	private Deductions deductions = new Deductions();
	private Savings savings = new Savings();
	
}
