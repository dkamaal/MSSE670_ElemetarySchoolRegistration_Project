package com.elementaryschool.model.domain;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

public class TeacherTest {

	/**
	 * Tests with an valid Teacher Information passed in
	 */
	@Test
	public void testValidate() {
		System.out.println("Starting testValidate()");
		Teacher t1 = new Teacher("John", "Peterson", 5, 2);
		// t1.validate should assert to True since all variables
		// being passed to create a new Teacher are all valid.
		assertTrue("t1 validates", t1.validate());
		System.out.println("testValidate PASSED");
	}

	/**
	 * Tests with an Invalid Student Information passed in
	 */
	@Test
	public void testNotValidate() {
		System.out.println("Starting testNotValidate()");
		Teacher t2 = new Teacher("John", "Peterson", -1, 0);
		// t2.validate should assert to False since Teaching Experience = -1, variable
		// being passed to create a new Teacher is invalid.
		assertFalse("t2 does not validate", t2.validate());
		System.out.println("testNotValidate PASSED");
	}

}
