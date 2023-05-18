package com.spectramd.portal.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "designation")
@Data
public class Designation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name="designation_code", length = 20)
	private String designationCode;
	
	@Column(name="designation_name",length = 100)
	private String designationName;
}
