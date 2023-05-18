package com.spectramd.portal.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
}
