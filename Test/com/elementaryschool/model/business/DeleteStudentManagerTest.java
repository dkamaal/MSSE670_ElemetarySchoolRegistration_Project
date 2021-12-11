package com.elementaryschool.model.business;

import static org.junit.jupiter.api.Assertions.*;

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

import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.elementaryschool.model.business.exceptions.ServiceLoadException;
import com.elementaryschool.model.business.factory.SchoolServiceFactory;
import com.elementaryschool.model.business.managers.DeleteStudentManager;
import com.elementaryschool.model.domain.Student;

public class DeleteStudentManagerTest {

	// Below variable is set for being used in assertEqual method when data from
	// student table is returned

	int id = 1;
	String sfirstname = "Bob";
	String slastname = "Williams";
	String age = "5";
	String email = "Bob@test.com";
	String mobile = "1234567890";
	String sgrade = "SECOND-A";
	SchoolServiceFactory serviceFactory;

	@Before
	public void testSetUp() throws Exception {

		serviceFactory = new SchoolServiceFactory();

	}

	/**
	 * 
	 * @author Danish Kamaal
	 *
	 *         Testing DeleteStudentManager ability to Delete Existing Student
	 *         Registration by calling the service factory to serve up the
	 *         DeleteStudentService Then DeleteStudentManager can execute the
	 *         DeleteStudentSvcImpl.
	 *
	 */

	@Test
	public void testDeleteStudentManager() {
		System.out.println("Starting testDeleteStudentManagerValidate()");

		Student student = new Student(1, "Bob", "Williams", "5", "Bob@test.com", "1234567890", "SECOND-A");

		DeleteStudentManager deleteStudentManager = new DeleteStudentManager();
		try {
			deleteStudentManager.deleteNewStudent(student);
		} catch (ServiceLoadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
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
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
