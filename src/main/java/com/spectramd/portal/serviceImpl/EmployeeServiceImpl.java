package com.spectramd.portal.serviceImpl;

import static com.spectramd.portal.dto.adapter.EmployeeDTOAdapter.convertEmployeeToEmployeeDTO;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spectramd.portal.Entity.Employee;
import com.spectramd.portal.dto.EmployeeDTO;
import com.spectramd.portal.exception.EmployeeNotFoundException;
import com.spectramd.portal.repository.EmployeeRepository;
import com.spectramd.portal.service.IEmployeeService;

import javax.persistence.EntityNotFoundException;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	private static final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<EmployeeDTO> getAllEmployees() {
		log.info("Get all Employees");
		return convertEmployeeToEmployeeDTO(employeeRepository.findAll());
	}

	@Override
	public EmployeeDTO getEmployee(Long employeeId) {
		log.info("EmployeeId: " + employeeId);
		Employee empl;
		try {
			 empl = employeeRepository.getOne(employeeId) ;
			 log.info("Employee: " + empl);
		}catch(EntityNotFoundException exc) {
			throw new EmployeeNotFoundException(employeeId);
		};
				
		return convertEmployeeToEmployeeDTO(empl);
	}

	@Override
	public EmployeeDTO save(EmployeeDTO newEmployee) {
		return new EmployeeDTO();
	}

}
