package com.accenture.assignment;

import com.accenture.assignment.action.CloseOperation;
import com.accenture.assignment.action.OpenOperation;
import com.accenture.assignment.exception.AlreadyClosed;
import com.accenture.assignment.exception.AlreadyOpen;

/**
 * 
 * @author Siva
 *
 */
public class Door implements OpenOperation,CloseOperation{
	
	/*
	 *  Holds the door open or close status. If door open status value is true otherwise false.
	 */
	private Boolean status;
	
	private int number;
	
	public Door(int number){
		status=new Boolean(false);
		this.number=number;
	}
	
	/**
	 *  Opens the door
	 *  implemented  OpenOperation interface
	 * @return boolean
	 * @throws AlreadyOpen 
	 */
	@Override
	public Boolean open() throws AlreadyOpen{
		if(isOpen()){
			throw new AlreadyOpen();
		}
		return status=true;
	}
	
	/**
	 * Closes the door
	 * implemented  closeOperation interface
	 * @return boolean
	 * 
	 */
	@Override
	public Boolean close() throws AlreadyClosed{
		if(!isOpen()){
			throw new AlreadyClosed();
		}
		
		return status=false;
	}
	
	/**
	 * Returns the true if the door is open
	 * @return boolean
	 */
	public Boolean isOpen(){
		return status;
	}
	
	public String getState(){
		return isOpen()?"Open":"Close";
	}
	
	public int getNumber(){
		return number;
	}
}
