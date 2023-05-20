package com.spectramd.portal.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtResponse {
	String 	jwt;
	Long id;
	String username;
	String email;
	List<String> roles;
	 
}
