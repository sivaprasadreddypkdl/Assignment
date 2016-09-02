package com.accenture.assignment;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.accenture.assignment.exception.AlreadyClosed;
import com.accenture.assignment.exception.AlreadyOpen;
import com.accenture.assignment.exception.InvalidDoorNumber;
import com.accenture.assignment.exception.InvalidDoorsCount;

public class DoorRunnerTest {
	
	private DoorRunner doorRunner;

	@Before
	public void setUp(){
		
	}
	
	@Test(expected=InvalidDoorsCount.class)
	public void create_doorrunner_with_negative_value() throws InvalidDoorsCount {
		new DoorRunner(-10);
	}
	
	@Test(expected=InvalidDoorsCount.class)
	public void create_doorrunner_with_zero_value() throws InvalidDoorsCount {
		new DoorRunner(0);
	}
	
	@Test
	public void test_getDoor_when_door_exitst() throws InvalidDoorsCount, InvalidDoorNumber{
		doorRunner=new DoorRunner(1);
		Assert.assertEquals(1, doorRunner.getDoor(1).getNumber());
	}
	
	@Test(expected=InvalidDoorNumber.class)
	public void test_getDoor_when_door_not_exitst() throws InvalidDoorsCount, InvalidDoorNumber{
		doorRunner=new DoorRunner(1);
		Assert.assertEquals(1, doorRunner.getDoor(0).getNumber());
	}
	
	@Test
	public void test_door_status_with_one_door() throws InvalidDoorsCount, AlreadyClosed, AlreadyOpen, InvalidDoorNumber{
		doorRunner=new DoorRunner(1);
		doorRunner.run();
		Assert.assertEquals("Open", doorRunner.getDoor(1).getState());
	}
	
	@Test
	public void test_doors_status_with_two_door() throws InvalidDoorsCount, AlreadyClosed, AlreadyOpen, InvalidDoorNumber{
		doorRunner=new DoorRunner(2);
		doorRunner.run();
		Assert.assertEquals("Open", doorRunner.getDoor(1).getState());
		Assert.assertEquals("Close", doorRunner.getDoor(2).getState());
	}
	
	@Test
	public void test_doors_status_with_three_door() throws InvalidDoorsCount, AlreadyClosed, AlreadyOpen, InvalidDoorNumber{
		doorRunner=new DoorRunner(3);
		doorRunner.run();
		Assert.assertEquals("Open", doorRunner.getDoor(1).getState());
		Assert.assertEquals("Close", doorRunner.getDoor(2).getState());
		Assert.assertEquals("Close", doorRunner.getDoor(3).getState());
	}
	
	@Test
	public void test_doors_status_with_four_door() throws InvalidDoorsCount, AlreadyClosed, AlreadyOpen, InvalidDoorNumber{
		doorRunner=new DoorRunner(4);
		doorRunner.run();
		Assert.assertEquals("Open", doorRunner.getDoor(1).getState());
		Assert.assertEquals("Close", doorRunner.getDoor(2).getState());
		Assert.assertEquals("Close", doorRunner.getDoor(3).getState());
		Assert.assertEquals("Open", doorRunner.getDoor(4).getState());
	}
	
	@Test
	public void test_doors_status_with_five_door() throws InvalidDoorsCount, AlreadyClosed, AlreadyOpen, InvalidDoorNumber{
		doorRunner=new DoorRunner(5);
		doorRunner.run();
		Assert.assertEquals("Open", doorRunner.getDoor(1).getState());
		Assert.assertEquals("Close", doorRunner.getDoor(2).getState());
		Assert.assertEquals("Close", doorRunner.getDoor(3).getState());
		Assert.assertEquals("Open", doorRunner.getDoor(4).getState());
		Assert.assertEquals("Close", doorRunner.getDoor(5).getState());
	}
	
	@Test
	public void test_doors_status_with_six_door() throws InvalidDoorsCount, AlreadyClosed, AlreadyOpen, InvalidDoorNumber{
		doorRunner=new DoorRunner(6);
		doorRunner.run();
		Assert.assertEquals("Open", doorRunner.getDoor(1).getState());
		Assert.assertEquals("Close", doorRunner.getDoor(2).getState());
		Assert.assertEquals("Close", doorRunner.getDoor(3).getState());
		Assert.assertEquals("Open", doorRunner.getDoor(4).getState());
		Assert.assertEquals("Close", doorRunner.getDoor(5).getState());
		Assert.assertEquals("Close", doorRunner.getDoor(6).getState());
	}

}
