package com.nkhurshid.services;

public class LimitExceededException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LimitExceededException(String msg) {
		super(msg);
	}

}
