package com.spectramd.portal.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

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
public class Employee {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long employeeId;
	
	@Column(name="firstname")
	private String employeeFirstName;
	
	@Column(name="middlename")
	private String employeeMiddleName;
	
	@Column(name="lastname")
	private String employeeLastName;

	@ManyToOne
	private Department department;	
	
	@ManyToOne
	private Designation designation;
	
	@ManyToOne
	private TaxRegime taxRegime;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "employees_skills", 
				joinColumns = @JoinColumn(name = "employee_id"), 
				inverseJoinColumns = @JoinColumn(name = "skill_id"))
	private Set<Skill> skills = new HashSet<>();
}
