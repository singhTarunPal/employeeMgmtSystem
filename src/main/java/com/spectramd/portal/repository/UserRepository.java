package com.spectramd.portal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spectramd.portal.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUsername(String username);
	Boolean existsByUsername(String username);
	boolean existsByEmail(String email);
}