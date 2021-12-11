package com.elementaryschool.model.services;

import static org.junit.jupiter.api.Assertions.*;

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
import com.elementaryschool.model.services.studentservice.DeleteStudentSvcImpl;

/**
 * 
 * @author Danish Kamaal
 */
//This test is to delete student from table

public class DeleteStudentSvcImplTest {
	
	int id = 1;
	String sfirstname = "Bob";
	String slastname = "Williams";
	String age = "5";
	String email = "Bob@test.com";
	String mobile = "1234567890";
	String sgrade = "SECOND-A";

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
		sTU1.setId(1); // **Update ID based on student Table Data**

		// Do the call

		DeleteStudentSvcImpl deleteStudentSvcImpl = new DeleteStudentSvcImpl();
		deleteStudentSvcImpl.deleteStudent(sTU1);

		Connection con3;
		PreparedStatement st;

		try {

			// Load the Properties File
			
			Properties dbprops = new Properties();
			//dbprops.load(new FileInputStream("C:/Users/danishkamaal2011/eclipse-workspace/MSSE670_ElemetarySchoolRegistration_Project/config/database.properties"));
			dbprops.load(getClass().getResourceAsStream("/com/elementaryschool/config/database.properties"));
            // Read the dbprops
            
            String user = dbprops.getProperty("username");
            String password = dbprops.getProperty("password");
            String url = dbprops.getProperty("databaseurl");
			
			// establish the connection

			con3 = DriverManager.getConnection(url, user, password);

			st = con3.prepareStatement("SELECT * FROM student where sfirstname = 'Bob'"); // update id here for
																							// completing test
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				assertNotEquals(sfirstname, rs.getString("sfirstname"));

				//assertFalse(rs.next(), "Record Still Exist");

			}

			rs.close();
			st.close();
			con3.close();

		} catch (SQLException ex) {
			Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
		}
		 catch (Exception e) {
			 System.out.println("Something Went Wrong");
		 }
		System.out.println("DeleteStudentSvcImplTest Passed");
	}

}
