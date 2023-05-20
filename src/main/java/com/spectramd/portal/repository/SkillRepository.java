package com.spectramd.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spectramd.portal.Entity.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
	Skill findBySkillCode(String skillCode);
}
