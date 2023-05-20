package com.spectramd.portal.exception;

public class EarningsNotFoundException extends RuntimeException {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3187678859978762760L;

	public EarningsNotFoundException(Long id) {
		super("Could not find earnings for employee " + id);
	}
	
	public EarningsNotFoundException() {
		super("Could not find earnings ");
	}
}
