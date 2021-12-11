package com.elementaryschool.model.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
import com.elementaryschool.model.business.managers.RegisterStudentManager;
import com.elementaryschool.model.domain.Student;


//(Please make sure to delete all records from table first)
//In below test Student detail is added to MySQL database table "student" and then Result test next() method is used
//Calling the next() method for the first time the result set pointer/cursor will be moved to the 1st row


public class RegisterStudentManagerTest {
	
	// Below variable is set for being used in assertEqual method when data from
	// student table is returned
	
	int id;
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
	* Testing RegisterStudentManager ability to add a new Student Registration by calling the 
	* service factory to serve up the RegisterStudentService 
	*Then RegisterStudentManager can execute the RegisterStudentSvcImpl.
	*
	*/

	@Test 
	
	public void testRegisterStudentManager() {
		System.out.println("Starting testRegisterStudentManagerValidate()");
		
		Student student = new Student(0, "Bob", "Williams", "5", "Bob@test.com", "1234567890", "SECOND-A");
		
		RegisterStudentManager registerStudentManager = new RegisterStudentManager();
		try {
			registerStudentManager.registerNewStudent(student);
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
			System.out.println("RegisterStudentManagerTest PASSED");
		}
		rs.close();
		st.close();
		con3.close();

	} catch (SQLException exm1) {
		Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, exm1);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}

	
}
