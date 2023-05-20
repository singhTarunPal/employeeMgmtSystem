package com.spectramd.portal.service;

import com.spectramd.portal.dto.SalaryDTO;

public interface ISalaryService {
	SalaryDTO getSalary(Long employeeId);
}
