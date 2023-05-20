package com.spectramd.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spectramd.portal.Entity.Earnings;

@Repository
public interface EarningsRepository extends JpaRepository<Earnings, Long> {

}
