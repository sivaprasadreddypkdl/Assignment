package com.accenture.assignment;

import com.accenture.assignment.exception.AlreadyClosed;
import com.accenture.assignment.exception.AlreadyOpen;
import com.accenture.assignment.exception.InvalidDoorNumber;
import com.accenture.assignment.exception.InvalidDoorsCount;

/**
 * DoorRunner class is used to toggle the door with n iterations
 * 
 * @author Siva
 *
 */
public class DoorRunner {
	
	// Holds the doors
	private final Door[] doors;

	/**
	 * It's is mandatory to mention the door count before going through the iterations.
	 * 
	 * @param count
	 *            doors count
	 * @throws InvalidDoorsCount
	 */
	public DoorRunner(int count) throws InvalidDoorsCount {
		if (count <= 0) {
			throw new InvalidDoorsCount("Doors count should be a positive value(1 or more )");
		}
		doors = new Door[count];
		arrangeDoors();
	}

	/**
	 * Returns all doors
	 * 
	 * @return Door[]
	 */
	public Door[] getDoors() {
		return doors;
	}

	/**
	 * Returns the door for given door number
	 * 
	 * @param doorNumber
	 * @return Door
	 * @throws InvalidDoorNumber
	 */
	public Door getDoor(int doorNumber) throws InvalidDoorNumber {
		try {
			return getDoors()[doorNumber-1];
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new InvalidDoorNumber();
		}
	}
	
	public void run() throws AlreadyClosed, AlreadyOpen, InvalidDoorNumber{
		for(int i=1;i<=doors.length;i++){
			int doorNumber=i;
			do{
				toogleDoor(getDoor(doorNumber));
				doorNumber=getNextDoorNumber(i, doorNumber);
			}while(doorNumber<=doors.length);
			
		}
	}
	
	private void toogleDoor(Door door) throws AlreadyClosed, AlreadyOpen {
		if(door.isOpen()){
			door.close();
		}else{
			door.open();
		}
		
	}

	private int getNextDoorNumber(int i, int j) {
		return i+j;
	}

	private void arrangeDoors() {
		for (int number = 0; number < doors.length; number++) {
			doors[number]=new Door(number+1);
		}
	}

}
