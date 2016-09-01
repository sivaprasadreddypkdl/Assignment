package com.accenture.assignment.action;

import com.accenture.assignment.exception.AlreadyOpen;

public interface OpenOperation {
	Boolean open() throws AlreadyOpen;
}
