package com.spectramd.portal.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.spectramd.portal.dto.SkillDTO;
import com.spectramd.portal.model.MessageResponse;
import com.spectramd.portal.model.SkillRequest;
import com.spectramd.portal.service.ISkillsService;

@RestController
@RequestMapping("/api/v1/skills")
public class SkillsController {

	private static final Logger log = LoggerFactory.getLogger(SalaryController.class);

	@Autowired
	private ISkillsService skillsService;

	@GetMapping(value = "/{id}", produces = "application/JSON")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public @ResponseBody ResponseEntity<Object> one(@PathVariable Long id) {
		SkillDTO skill = skillsService.getSkill(id);

		log.info("skill: " + skill);
		return new ResponseEntity<Object>(new Gson().toJson(skill), HttpStatus.OK);
	}

	/*
	 * @GetMapping(value = "/", produces = "application/JSON")
	 * 
	 * @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	 * public @ResponseBody ResponseEntity<Object> getAllSkills(@RequestParam String
	 * skillCode) { if(null!=skillCode && !skillCode.equalsIgnoreCase("all")) {
	 * SkillDTO skill = skillsService.getSkillBySkillCode(skillCode);
	 * log.info("skill: " + skill); return new ResponseEntity<Object>(new
	 * Gson().toJson(skill), HttpStatus.OK); }else { List<SkillDTO> skill =
	 * skillsService.getAllSkills(); log.info("skill: " + skill); return new
	 * ResponseEntity<Object>(new Gson().toJson(skill), HttpStatus.OK); }
	 * 
	 * }
	 */

	@GetMapping(value = "/", produces = "application/JSON")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public @ResponseBody ResponseEntity<Object> getAllSkills() {

		List<SkillDTO> skill = skillsService.getAllSkills();
		log.info("skill: " + skill);
		return new ResponseEntity<Object>(new Gson().toJson(skill), HttpStatus.OK);

	}

	@PostMapping(value = "/", produces = "application/JSON")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public @ResponseBody ResponseEntity<Object> saveOrUpdate(@Valid @RequestBody SkillRequest skillRequest) {
		if (skillRequest != null && skillRequest.getSkillCode() != null) {
			SkillDTO skill = skillsService.getSkillBySkillCode(skillRequest.getSkillCode());
			log.info("skill: " + skill);
			skill = skillsService.saveOrUpdate(skillRequest);				
			return new ResponseEntity<Object>(new Gson().toJson(skill), HttpStatus.OK);
		} else {
			return ResponseEntity.badRequest().body(new MessageResponse("Error Entring New Skill"));
		}
	}
}
