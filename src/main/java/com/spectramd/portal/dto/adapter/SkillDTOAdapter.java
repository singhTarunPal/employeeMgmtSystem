package com.spectramd.portal.dto.adapter;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spectramd.portal.Entity.Skill;
import com.spectramd.portal.dto.SkillDTO;

public class SkillDTOAdapter {
	
	private static final Logger log = LoggerFactory.getLogger(SkillDTOAdapter.class);

	
	public static SkillDTO convertSkillToSkillDTO(Skill skill) {
		if(null != skill)
			return SkillDTO.builder()
					.id(skill.getId())
					.skillCode(skill.getSkillCode())
					.skillName(skill.getSkillName())
					.skillDescription(skill.getSkillDescription())
					.build();
		else {
			log.info("No skill found");
			return null;
		}	
	}	
	
	public static List<SkillDTO>  convertSkillToSkillDTO(List<Skill> skillList) {
		List<SkillDTO> skillDTOList = new ArrayList<SkillDTO>();
		skillList.forEach(skill -> {
			skillDTOList.add(SkillDTO.builder()
					.id(skill.getId())
					.skillCode(skill.getSkillCode())
					.skillName(skill.getSkillName())
					.skillDescription(skill.getSkillDescription())
					.build());
		});
		return skillDTOList;	
	}	
}
