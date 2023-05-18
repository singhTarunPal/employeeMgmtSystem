package com.spectramd.portal.exception;

public class EmployeeNotFoundException extends RuntimeException {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3187678859978762760L;

	public EmployeeNotFoundException(Long id) {
		super("Could not find employee " + id);
	}
	
	public EmployeeNotFoundException() {
		super("Could not find employee ");
	}
}
