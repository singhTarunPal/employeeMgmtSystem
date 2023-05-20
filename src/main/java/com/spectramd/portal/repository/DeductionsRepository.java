package com.spectramd.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spectramd.portal.Entity.Deductions;

@Repository
public interface DeductionsRepository extends JpaRepository<Deductions, Long> {

}
