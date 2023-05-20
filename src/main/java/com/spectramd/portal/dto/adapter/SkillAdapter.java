package com.spectramd.portal.dto.adapter;

import com.spectramd.portal.Entity.Skill;
import com.spectramd.portal.model.SkillRequest;

public class SkillAdapter {
	public static Skill convertSkillRequestToSkill(SkillRequest skillRequest) {
		if(skillRequest !=null) {
			return Skill.builder()
					.skillCode(skillRequest.getSkillCode())
					.skillName(skillRequest.getSkillName())
					.skillDescription(skillRequest.getSkillDescription())
					.build();
		}
		else {
			return null;
		}
	}
}
