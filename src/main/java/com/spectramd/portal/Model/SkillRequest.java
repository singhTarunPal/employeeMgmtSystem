package com.spectramd.portal.model;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class SkillRequest {
	
	@NotNull
	private String skillCode;
	
	@NotNull
	private String skillName;
	private String skillDescription;
}
