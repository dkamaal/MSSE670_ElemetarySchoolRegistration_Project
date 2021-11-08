package com.elementaryschool.model.services.studentservice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.elementaryschool.model.domain.Student;


public class RegisterStudentSvcImplTest {
	
	

	@Test
	public void testRegisterStudent() {
		System.out.println("Starting testRegisterStudentValidate()");
		
		Student sTU1 = new Student();
		
		sTU1.setsFirstName("Bob");
		sTU1.setsLastName("Williams");
		sTU1.setAge("5");
		sTU1.setEmail("test@testemail.com");
		sTU1.setMobile("8888888888");
		
		registerStudent(sTU1);
		
		
		// s1.validate should assert to True since all variables
		// being passed to create a new Student are all valid.
		
	}

}
