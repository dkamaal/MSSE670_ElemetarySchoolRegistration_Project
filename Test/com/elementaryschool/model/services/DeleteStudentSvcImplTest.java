package com.elementaryschool.model.services;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

import com.elementaryschool.model.domain.Grade;
import com.elementaryschool.model.domain.Student;
import com.elementaryschool.model.services.studentservice.DeleteStudentSvcImpl;
/**
 * 
 * @author Danish Kamaal
 */
//This test is to delete student from table

class DeleteStudentSvcImplTest {

	@Test
	void testDeleteStudent() {
System.out.println("Starting testDeleteStudentValidate()");
		

		Student sTU1 = new Student();

		// Setting Input parameters
		
		sTU1.setsFirstName("Bob");
		sTU1.setsLastName("Williams");
		sTU1.setAge("5");
		sTU1.setEmail("Bob@test.com");
		sTU1.setMobile("1234567890");
		sTU1.setSgrade("SECOND-A");
		sTU1.setId(3); //**Update ID based on student Table Data**

		// Do the call

		DeleteStudentSvcImpl deleteStudentSvcImpl = new DeleteStudentSvcImpl();
		deleteStudentSvcImpl.deleteStudent(sTU1);

		Connection con3;
		PreparedStatement st;

		try {

			// register Oracle thin driver with DriverManager service

			//Class.forName("com.mysql.cj.jdbc.Driver");

			// variables

			final String url = "jdbc:mysql:///school";
			final String user = "root";
			final String password = "Root4you$";

			// establish the connection

			con3 = DriverManager.getConnection(url, user, password);

			st = con3.prepareStatement("SELECT * FROM student where sfirstname = 'Bob'"); //update id here for completing test
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				
				
				assertFalse(rs.next(), "Record Still Exist");
				
	
			}
			
				
			rs.close();
			st.close();
			con3.close();
		}
		
		

		catch (SQLException ex) {
			Logger.getLogger(Grade.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
