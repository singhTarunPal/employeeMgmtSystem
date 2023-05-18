package com.spectramd.portal.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AboutController {
	@GetMapping(value = "/about")
	public String about() {
		 return "This is an Internal Portal created for Spectramedix";
	}
	
	@GetMapping(value = "/aboutAdmin")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_USER')")
	public String aboutAdmin() {
		 return "This is an Internal Portal created for Spectramedix for Admin";
	}
	
	@GetMapping(value = "/aboutNonAdmin")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	public String aboutNonAdmin() {
		 return "This is an Internal Portal created for Spectramedix for NonAdmin";
	}
}
