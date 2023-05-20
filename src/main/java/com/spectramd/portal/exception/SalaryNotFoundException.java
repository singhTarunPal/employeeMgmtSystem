package com.spectramd.portal.exception;

public class SalaryNotFoundException extends RuntimeException {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3187678859970762760L;

	public SalaryNotFoundException(Long id) {
		super("Could not find salary for employee " + id);
	}
	
	public SalaryNotFoundException() {
		super("Could not find salary for employee ");
	}
}
