package com.spectramd.portal.serviceImpl;

import static com.spectramd.portal.dto.adapter.SkillAdapter.convertSkillRequestToSkill;
import static com.spectramd.portal.dto.adapter.SkillDTOAdapter.convertSkillToSkillDTO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spectramd.portal.Entity.Skill;
import com.spectramd.portal.dto.SkillDTO;
import com.spectramd.portal.model.SkillRequest;
import com.spectramd.portal.repository.SkillRepository;
import com.spectramd.portal.service.ISkillsService;

@Service
public class SkillsService implements ISkillsService {
	
	@Autowired
	private SkillRepository skillRepository;
	
	@Override
	public SkillDTO getSkill(Long skillId) {
		Optional<Skill> skill =  skillRepository.findById(skillId);
		if (skill.isPresent())
			return convertSkillToSkillDTO(skill.get());
		else
			return null;
	}
	
	@Override
	public SkillDTO getSkillBySkillCode(String skillCode) {
		Skill skill =  skillRepository.findBySkillCode(skillCode);
		if (null !=skill)
			return convertSkillToSkillDTO(skill);
		else
			return null;
	}
	
	@Override
	public List<SkillDTO> getAllSkills(){
		return convertSkillToSkillDTO(skillRepository.findAll());
	}
	
	@Override
	public SkillDTO saveOrUpdate(SkillRequest skillRequest) {
		Skill skill = convertSkillRequestToSkill(skillRequest);
		return convertSkillToSkillDTO(skillRepository.save(skill));
	}	
}
