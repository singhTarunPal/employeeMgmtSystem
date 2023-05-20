package com.spectramd.portal.service;

import java.util.List;

import com.spectramd.portal.dto.SkillDTO;
import com.spectramd.portal.model.SkillRequest;

public interface ISkillsService {
	SkillDTO getSkill(Long skillId);
	List<SkillDTO> getAllSkills();
	SkillDTO getSkillBySkillCode(String skillCode);
	SkillDTO saveOrUpdate(SkillRequest skillRequest);
}
