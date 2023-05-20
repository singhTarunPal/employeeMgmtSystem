package com.spectramd.portal.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.gson.annotations.Expose;

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
public class EarningsDTO {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long employeeId;
	
	@Expose
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
}
