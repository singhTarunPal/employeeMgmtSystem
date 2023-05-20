package com.spectramd.portal.exception;

public class DeductionsNotFoundException extends RuntimeException {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3181678859978762760L;

	public DeductionsNotFoundException(Long id) {
		super("Could not find deductions for employee " + id);
	}
	
	public DeductionsNotFoundException() {
		super("Could not find deductions ");
	}
}
