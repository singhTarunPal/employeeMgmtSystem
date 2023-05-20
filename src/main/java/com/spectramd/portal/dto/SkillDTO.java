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
public class SkillDTO {
	private Long id;
	private String skillCode;
	private String skillName;
	private String skillDescription;
}
