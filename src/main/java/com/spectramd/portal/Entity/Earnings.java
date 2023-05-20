package com.spectramd.portal.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Earnings {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Long employeeId;
	private Integer basic;
	private Integer hra;
	private Integer da;
	private Integer conveyance;
	private Integer foodAllowance;
	private Integer lta;
	private Integer medicalAllowance;
	private Integer incentiveEarnings;
	private Integer telephoneReimbursement;
	private Integer vehicleReimburesement;	
	private Integer managementAllowance;
	private Integer bonus;	
	
	public Integer sum() {
		return returnIfNotNull(basic) 
				+ returnIfNotNull(hra) 
				+ returnIfNotNull(da) 
				+ returnIfNotNull(conveyance)
				+ returnIfNotNull(foodAllowance) 
				+ returnIfNotNull(lta)
				+ returnIfNotNull(medicalAllowance)
				+ returnIfNotNull(incentiveEarnings)
				+ returnIfNotNull(telephoneReimbursement)
				+ returnIfNotNull(vehicleReimburesement) 
				+ returnIfNotNull(managementAllowance)
				+ returnIfNotNull(bonus);
	}
	
	private Integer returnIfNotNull(Integer value) {
		return value != null?value:0;
	}
}
