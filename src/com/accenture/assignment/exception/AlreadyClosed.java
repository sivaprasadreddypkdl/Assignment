package com.accenture.assignment.exception;

public class AlreadyClosed extends Exception {

	private static final long serialVersionUID = -3884899859497085291L;

	public AlreadyClosed() {
	}

	public AlreadyClosed(String message) {
		super(message);
	}
}
