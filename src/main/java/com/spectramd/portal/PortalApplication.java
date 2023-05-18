package com.spectramd.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.spectramd.*")
@ComponentScan("com.spectramd.*" )
@EntityScan("com.*")   
public class PortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortalApplication.class, args);
	}
}
