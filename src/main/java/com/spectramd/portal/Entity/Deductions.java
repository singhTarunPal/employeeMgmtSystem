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
public class Deductions {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Long employeeId;	
	private Integer providentFund;
	private Integer foodDeduction;
	private Integer fuelDeduction;
	private Integer labourWelfareFund;
	
	public Integer sum() {
		return returnIfNotNull(providentFund) 
				+ returnIfNotNull(foodDeduction) 
				+ returnIfNotNull(fuelDeduction) 
				+ returnIfNotNull(labourWelfareFund);
	}
	
	private Integer returnIfNotNull(Integer value) {
		return value != null?value:0;
	}
}
