package com.elementaryschool.model.domain;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;
/**
 * 
 * @author Danish Kamaal
 */
public class GradeTest {

	/**
	 * Tests with an valid Grade Information passed in
	 */
	@Test
	public void testValidate() {
		System.out.println("Starting testValidate()");
		Grade g1 = new Grade(1, "KINDERGARTEN-A");
		// g1.validate should assert to True since all variables
		// being passed to create a new Grade are all valid.
		assertTrue("g1 validates", g1.validate());
		System.out.println("testValidate PASSED");
	}

	/**
	 * Tests with an Invalid Grade Information passed in
	 */
	@Test
	public void testNotValidate() {
		System.out.println("Starting testNotValidate()");
		Grade g2 = new Grade(2, null);
		// g2.validate should assert to False since gradeSection = blank
		// being passed to create a new Grade is invalid.
		assertFalse("g2 does not validate", g2.validate());
		System.out.println("testNotValidate PASSED");
	}

}
