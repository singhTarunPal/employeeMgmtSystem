package com.spectramd.portal.dto.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spectramd.portal.Entity.Earnings;
import com.spectramd.portal.dto.EarningsDTO;

public class EarningsDTOAdapter {
	private static final Logger log = LoggerFactory.getLogger(EarningsDTOAdapter.class);

	
	public static EarningsDTO convertEarningsToEarningsDTO(Earnings earning) {
		if(null != earning)
			return EarningsDTO.builder()
				.basic(earning.getBasic())
				.bonus(earning.getBonus())
				.conveyance(earning.getConveyance())
				.da(earning.getDa())
				.employeeId(earning.getEmployeeId())
				.foodAllowance(earning.getFoodAllowance())
				.hra(earning.getHra())
				.incentiveEarnings(earning.getIncentiveEarnings())
				.lta(earning.getLta())
				.managementAllowance(earning.getManagementAllowance())
				.medicalAllowance(earning.getMedicalAllowance())
				.telephoneReimbursement(earning.getTelephoneReimbursement())
				.vehicleReimburesement(earning.getTelephoneReimbursement())
				.build();
		else {
			log.info("No earning found");
			return null;
		}	
	}			
}
