package com.accenture.assignment;

import java.util.Scanner;

import com.accenture.assignment.exception.AlreadyClosed;
import com.accenture.assignment.exception.AlreadyOpen;
import com.accenture.assignment.exception.InvalidDoorNumber;
import com.accenture.assignment.exception.InvalidDoorsCount;

public class Application {
	
	
	
	public static void main(String[] args) throws InvalidDoorsCount, AlreadyClosed, AlreadyOpen, InvalidDoorNumber {
		
		System.out.println("Please enter how many doors you want  : ");
		Scanner sc=new Scanner(System.in);
		
		int num=sc.nextInt();
		
		DoorRunner doorRunner=new DoorRunner(num);
		
		doorRunner.run();
		
		for(Door door:doorRunner.getDoors()){
			
			System.out.println(door.getNumber()+" " +door.getState());
		}
		
		
	}

}
