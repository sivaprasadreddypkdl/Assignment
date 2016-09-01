package com.accenture.assignment;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.accenture.assignment.exception.AlreadyClosed;
import com.accenture.assignment.exception.AlreadyOpen;

public class DoorTest {

	Door door;
	@Before
	public void setUp(){
		door=new Door(1);
	}
	
	@Test
	public void test_door_is_close_by_default() throws AlreadyOpen {
		Assert.assertFalse(door.isOpen());
	}
	
	@Test
	public void test_open_door() throws AlreadyOpen {
		Assert.assertTrue(door.open());
	}
	
	@Test
	public void test_isOpen_door_with_door_open() throws AlreadyOpen {
		door.open();
		Assert.assertTrue(door.isOpen());
	}
	
	@Test
	public void test_isOpen_door_with_door_close() throws AlreadyOpen {
		Assert.assertFalse(door.isOpen());
	}
	
	@Test(expected=AlreadyOpen.class)
	public void test_Open_if_door_already_open() throws AlreadyOpen {
		door.open();
		door.open();
	}
	
	@Test
	public void test_close() throws AlreadyClosed, AlreadyOpen {
		door.open();
		Assert.assertFalse(door.close());
	}
	
	@Test(expected=AlreadyClosed.class)
	public void test_close_if_already_close() throws AlreadyClosed, AlreadyOpen {
		door.close();
		
	}
	
	@Test()
	public void test_getState_with_door_close() {
		Assert.assertEquals(State.CLOSE, door.getState());
		
	}
	
	@Test()
	public void test_getState_with_door_open() throws AlreadyOpen {
		door.open();
		Assert.assertEquals(State.OPEN, door.getState());
	}
	
	@Test
	public void test_door_number(){
		Assert.assertEquals(1, door.getNumber());
	}

}
