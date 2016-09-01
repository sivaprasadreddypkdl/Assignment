package com.accenture.assignment.exception;

public class AlreadyOpen extends Exception {

	private static final long serialVersionUID = -3240177386395748014L;

	public AlreadyOpen() {
	}

	public AlreadyOpen(String message) {
		super(message);
	}
}
