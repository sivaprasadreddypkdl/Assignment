package com.accenture.assignment.action;

import com.accenture.assignment.exception.AlreadyClosed;

public interface CloseOperation {
	Boolean close() throws AlreadyClosed; 
	
	 
}
