package com.spectramd.portal.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Skill {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String skillCode;
	private String skillName;
	private String skillDescription;
}
