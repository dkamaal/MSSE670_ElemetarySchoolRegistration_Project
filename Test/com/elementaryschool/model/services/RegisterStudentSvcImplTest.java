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

import com.elementaryschool.model.domain.Student;
import com.elementaryschool.model.services.studentservice.RegisterStudentSvcImpl;

//(Please make sure to delete all records from table first)
//In below test Student detail is added to MySQL database table "student" and then Result test next() method is used
//Calling the next() method for the first time the result set pointer/cursor will be moved to the 1st row
/**
 * 
 * @author Danish Kamaal
 */
public class RegisterStudentSvcImplTest {

	// Below variable is set for being used in assertEqual method when data from
	// student table is returned

	int id;
	String sfirstname = "Bob";
	String slastname = "Williams";
	String age = "5";
	String email = "Bob@test.com";
	String mobile = "1234567890";
	String sgrade = "SECOND-A";

	@Test
	public void testRegisterStudent() {
		System.out.println("Starting testRegisterStudentValidate()");

		Student sTU1 = new Student();

		// Setting Input parameters
		sTU1.setId(0);
		sTU1.setsFirstName("Bob");
		sTU1.setsLastName("Williams");
		sTU1.setAge("5");
		sTU1.setEmail("Bob@test.com");
		sTU1.setMobile("1234567890");
		sTU1.setSgrade("SECOND-A");

		// Do the call

		RegisterStudentSvcImpl registerStudentSvcImpl = new RegisterStudentSvcImpl();
		registerStudentSvcImpl.registerStudent(sTU1);

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

			// Comparing if student added is in database

			st = con3.prepareStatement("SELECT * FROM student");
			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				id = rs.getInt("id");
				assertEquals(sfirstname, rs.getString("sfirstname"));
				assertEquals(slastname, rs.getString("slastname"));
				assertEquals(age, rs.getString("age"));
				assertEquals(email, rs.getString("email"));
				assertEquals(mobile, rs.getString("mobile"));
				assertEquals(sgrade, rs.getString("sgrade"));
				System.out.println("RegisterStudentTest PASSED");
			}
			rs.close();
			st.close();
			con3.close();
//		} catch (ClassNotFoundException ex) {
//			Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
