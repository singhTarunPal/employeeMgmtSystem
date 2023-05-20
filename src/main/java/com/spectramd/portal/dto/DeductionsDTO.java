package com.spectramd.portal.dto;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
public class DeductionsDTO {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long employeeId;
	
	private Integer providentFund;
	private Integer foodDeduction;
	private Integer fuelDeduction;
	private Integer labourWelfareFund;
}
