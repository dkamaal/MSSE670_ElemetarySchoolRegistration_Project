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
/**
 * 
 * @author Danish Kamaal
 */
class DisplayStudentSvcImplTest {

	@Test
	void testDisplayStudent() throws ClassNotFoundException {

		System.out.println("Starting testDisplayStudent()");
				
		// student table is returned

		String sfirstname = "Bob";
		String slastname = "Williams";
		String age = "5";
		String email = "Bob@test.com";
		String mobile = "1234567890";
		String sgrade = "SECOND-A";
		
		Connection con3;
		PreparedStatement st;

		try {

			// register Oracle thin driver with DriverManager service

			Class.forName("com.mysql.cj.jdbc.Driver");

			// variables

			final String url = "jdbc:mysql:///school";
			final String user = "root";
			final String password = "Root4you$";

			// establish the connection

			con3 = DriverManager.getConnection(url, user, password);

			st = con3.prepareStatement("SELECT * FROM student");
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
	
				assertEquals(sfirstname, rs.getString("sfirstname"));
				assertEquals(slastname, rs.getString("slastname"));
				assertEquals(age, rs.getString("age"));
				assertEquals(email, rs.getString("email"));
				assertEquals(mobile, rs.getString("mobile"));
				assertEquals(sgrade, rs.getString("sgrade"));
				System.out.println("DisplayStudentTest PASSED");
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


