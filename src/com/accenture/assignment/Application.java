package com.accenture.assignment;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.accenture.assignment.exception.AlreadyClosed;
import com.accenture.assignment.exception.AlreadyOpen;
import com.accenture.assignment.exception.InvalidDoorNumber;
import com.accenture.assignment.exception.InvalidDoorsCount;

/**
 * 
 * @author Siva 
 *
 */
public class Application {

	public static void main(String[] args)
			throws InvalidDoorsCount, AlreadyClosed, AlreadyOpen, InvalidDoorNumber, Exception {

		Integer num, openCount = 0, closeCount = 0;

		 System.out.println("Welcome to Application..!!! \n--------------------------------");

		System.out.print("Please enter the number of Doors you would like to enter: ");

		Scanner scanner = new Scanner(System.in);
		try {
			num = scanner.nextInt();

			// creating object for DoorRunenr

			DoorRunner runner = new DoorRunner(num);

			runner.run();
			/**
			 * for each loop to retrieve the Door status
			 */
			for (Door door : runner.getDoors()) {

				if (door.getState().equals("Open")) {
					openCount++;
				} else {
					closeCount++;
				}
				System.out.println(door.getNumber() + " " + door.getState());
			}

			System.out.println("\nNumber of Open Doors : " + openCount + "\nNumber of Closed Doors : " + closeCount
					+ "\nTotal Number of Doors : " + (openCount + closeCount));

		} catch (InvalidDoorsCount e) {

			System.err.println( e.getMessage() + " Please try again... \n\n");

			main(args);
		} catch (InputMismatchException e) {

			System.err.println("Input missmatch.. Please try again..\n\n");

			main(args);
		}

		scanner.close();
	}

}
