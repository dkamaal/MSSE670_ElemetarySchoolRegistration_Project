package elemetaryschoolregistration.domain;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

public class RegistrarTest {

	/**
	 * Tests with an valid School Name Information passed in
	 */
	@Test
	public void testValidate() {
		System.out.println("Starting testValidate()");
		Registrar r1 = new Registrar("ABC Elementary School");
		// r1.validate should assert to True since variable
		// being passed to create a new Registrar is valid.
		assertTrue("r1 validates", r1.validate());
		System.out.println("testValidate PASSED");
	}

	/**
	 * Tests with an Invalid Registrar Information passed in
	 */
	@Test
	public void testNotValidate() {
		System.out.println("Starting testNotValidate()");
		Registrar r2 = new Registrar(null);
		// r2.validate should assert to False since School Name is null, variable
		// being passed to create a new Registrar is invalid.
		assertFalse("r2 does not validate", r2.validate());
		System.out.println("testNotValidate PASSED");
	}

}
