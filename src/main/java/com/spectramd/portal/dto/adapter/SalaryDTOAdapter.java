package com.spectramd.portal.dto.adapter;

import com.spectramd.portal.dto.SalaryDTO;
import com.spectramd.portal.model.Salary;

public class SalaryDTOAdapter {
	public static SalaryDTO convertSalaryToSalaryDTO(Salary salary) {
		
		return SalaryDTO.builder()
					.employeeId(salary.getEmployeeId())
					.earnings(EarningsDTOAdapter.convertEarningsToEarningsDTO(salary.getEarnings()))
					.deductions(DeductionsDTOAdapter.convertDeductionsToDeductionsDTO(salary.getDeductions()))
					.earningsSum(salary.getEarnings()!=null?salary.getEarnings().sum():0)
					.deductionsSum(salary.getDeductions()!=null?salary.getDeductions().sum():0)
					.build();		
	}
}
