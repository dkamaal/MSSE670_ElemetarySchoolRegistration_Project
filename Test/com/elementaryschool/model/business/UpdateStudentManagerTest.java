package com.elementaryschool.model.business;

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

import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.elementaryschool.model.business.exceptions.ServiceLoadException;
import com.elementaryschool.model.business.factory.SchoolServiceFactory;
import com.elementaryschool.model.business.managers.UpdateStudentManager;
import com.elementaryschool.model.domain.Student;
//(Please make sure to delete all rows in table and run RegisterStudentSvcImplTest first and capture the ID from MySQL Table)
//In below test Student detail is updated in MySQL database table "student" and then Restult test next() method is used
//Calling the next() method for the first time the result set pointer/cursor will be moved to the row with that ID

//**Important** ID has to be updated everytime this result is done OR use below SQL Command to clear auto increment values
//ALTER TABLE student AUTO_INCREMENT = 0;

public class UpdateStudentManagerTest {
	
	int id = 1; // Update ID based on student Table Data
	String sfirstname = "Tom";
	String slastname = "Peterson";
	String age = "6";
	String email = "Tom@test.com";
	String mobile = "9234567899";
	String sgrade = "THIRD-A";

SchoolServiceFactory serviceFactory;
	
	@Before
	public void testSetUp() throws Exception {
	
	serviceFactory = new SchoolServiceFactory();
	
	}
	
	/**
	* 
	* @author Danish Kamaal
	*
	* Testing UpdateStudentManager ability to update Student Registration by calling the 
	* service factory to serve up the UpdateStudentService 
	*Then (UpdateStudentManager) can execute the UpdateStudentSvcImpl.
	*
	*/
	@Test
	void testUpdateStudentManager() 
	{
		System.out.println("Starting testUpdateStudentManagerValidate()");
		
		Student student = new Student(1, "Tom", "Peterson", "6", "Tom@test.com", "9234567899", "THIRD-A");
		
		UpdateStudentManager updateStudentManager = new UpdateStudentManager();
		try {
			updateStudentManager.updateNewStudent(student);
		} catch (ServiceLoadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
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

		st = con3.prepareStatement("SELECT * FROM student where id = 1"); // update id here for completing test
		ResultSet rs = st.executeQuery();

		while (rs.next()) {

			assertEquals(id, rs.getInt(1));
			assertEquals(sfirstname, rs.getString("sfirstname"));
			assertEquals(slastname, rs.getString("slastname"));
			assertEquals(age, rs.getString("age"));
			assertEquals(email, rs.getString("email"));
			assertEquals(mobile, rs.getString("mobile"));
			assertEquals(sgrade, rs.getString("sgrade"));
			System.out.println("UpdateStudentManagerTest PASSED");
		}
		rs.close();
		st.close();
		con3.close();


	} catch (SQLException ex2) {
		Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex2);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
