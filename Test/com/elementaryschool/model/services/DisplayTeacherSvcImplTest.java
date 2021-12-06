package com.elementaryschool.model.services;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
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

			// Load the Properties File
			
			Properties dbprops = new Properties();
			dbprops.load(new FileInputStream("C:/Users/danishkamaal2011/eclipse-workspace/MSSE670_ElemetarySchoolRegistration_Project/config/database.properties"));
            
            // Read the dbprops
            
            String user = dbprops.getProperty("username");
            String password = dbprops.getProperty("password");
            String url = dbprops.getProperty("databaseurl");
			
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

		} catch (SQLException ex) {
			Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, ex);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
