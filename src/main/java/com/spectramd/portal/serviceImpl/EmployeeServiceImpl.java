package com.spectramd.portal.serviceImpl;

import static com.spectramd.portal.dto.adapter.EmployeeDTOAdapter.convertEmployeeToEmployeeDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spectramd.portal.Entity.Employee;
import com.spectramd.portal.dto.EmployeeDTO;
import com.spectramd.portal.exception.EmployeeNotFoundException;
import com.spectramd.portal.repository.EmployeeRepository;
import com.spectramd.portal.service.IEmployeeService;

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
	public List<EmployeeDTO> getEmployeesByDesignationCode(String designationCode) {
		log.info("Get all Employees by Designation: " + designationCode);
		List<Employee> employeesByDesignation= employeeRepository.findAll()
													.stream()
													.filter(
															empl -> empl.getDesignation().getDesignationCode().equalsIgnoreCase(designationCode))
													.collect(Collectors.toList());
		return convertEmployeeToEmployeeDTO(employeesByDesignation);
	}
	
	@Override
	public List<EmployeeDTO> getEmployeesByDepartmentCode(String departmentCode) {
		log.info("Get all Employees by Department: " + departmentCode);
		List<Employee> employeesByDepartment= employeeRepository.findAll()
													.stream()
													.filter(
															empl -> empl.getDepartment().getDepartmentCode().equalsIgnoreCase(departmentCode))
													.collect(Collectors.toList());
		return convertEmployeeToEmployeeDTO(employeesByDepartment);
	}

	@Override
	public EmployeeDTO getEmployee(Long employeeId) {
		log.info("EmployeeId: " + employeeId);
		Optional<Employee> empl;
		try {
			 empl = employeeRepository.findById(employeeId) ;
			 log.info("Employee: " + empl);
		}catch(EntityNotFoundException exc) {
			throw new EmployeeNotFoundException(employeeId);
		};
				
		return empl.isPresent() ? convertEmployeeToEmployeeDTO(empl.get()) : null;
	}

	@Override
	public EmployeeDTO save(EmployeeDTO newEmployee) {
		return new EmployeeDTO();
	}

}
