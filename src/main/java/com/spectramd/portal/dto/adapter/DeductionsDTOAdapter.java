package com.spectramd.portal.dto.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spectramd.portal.Entity.Deductions;
import com.spectramd.portal.dto.DeductionsDTO;

public class DeductionsDTOAdapter {
	
	private static final Logger log = LoggerFactory.getLogger(DeductionsDTOAdapter.class);

	
	public static DeductionsDTO convertDeductionsToDeductionsDTO(Deductions deductions) {
		if(null != deductions)
			return DeductionsDTO.builder()
					.employeeId(deductions.getEmployeeId())
					.foodDeduction(deductions.getFoodDeduction())
					.fuelDeduction(deductions.getFuelDeduction())
					.labourWelfareFund(deductions.getLabourWelfareFund())
					.providentFund(deductions.getProvidentFund())
					.build();
		else {
			log.info("No deduction found");
			return null;
		}	
	}	
}
