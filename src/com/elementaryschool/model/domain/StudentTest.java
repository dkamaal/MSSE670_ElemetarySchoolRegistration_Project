package com.elementaryschool.model.domain;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

/**
 * @author Danish Kamaal
 *
 */

public class StudentTest {

	/**
	 * Tests with an valid Student Information passed in
	 */
	@Test
	public void testValidate() {
		System.out.println("Starting testValidate()");
		Student s1 = new Student(1, "Bob", "Williams", "5", "bob.williams@test.com", "9898989898", "KINDERGARTEN");
		// s1.validate should assert to True since all variables
		// being passed to create a new Student are all valid.
		assertTrue("s1 validates", s1.validate());
		System.out.println("testValidate PASSED");
	}

	/**
	 * Tests with an Invalid Student Information passed in
	 */
	@Test
	public void testNotValidate() {
		System.out.println("Starting testNotValidate()");
		Student s2 = new Student(1, "Bob", "Williams", null, "bob.williams@test.com", "9898989898", null);
		// s2.validate should assert to False since age = 0 variables
		// being passed to create a new Student are all invalid.
		assertFalse("s2 does not validate", s2.validate());
		System.out.println("testNotValidate PASSED");
	}

}
