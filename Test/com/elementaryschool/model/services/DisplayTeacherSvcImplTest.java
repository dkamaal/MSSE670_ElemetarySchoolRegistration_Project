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

import com.elementaryschool.model.domain.Teacher;

/**
 * 
 * @author Danish Kamaal
 */
class DisplayTeacherSvcImplTest {

	@Test
	void testDisplayTeacher() {
		System.out.println("Starting testDisplayTeacher()");

		// student table is returned

		String tfirstname = "TestFirstName12";
		String tlastname = "TestLastName12";
		int teachergrade = 12;
		int teacherexp = 12;

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

			st = con3.prepareStatement("SELECT * FROM teacher where teachergrade = 12");
			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				assertEquals(tfirstname, rs.getString("tfirstname"));
				assertEquals(tlastname, rs.getString("tlastname"));
				assertEquals(teachergrade, rs.getInt("teachergrade"));
				assertEquals(teacherexp, rs.getInt("teacherexp"));

				System.out.println("DisplayTeacherTest PASSED");
			}
			rs.close();
			st.close();
			con3.close();
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
}
