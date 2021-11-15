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

import com.elementaryschool.model.domain.Student;
import com.elementaryschool.model.services.studentservice.UpdateStudentSvcImpl;

//(Please make sure to delete all rows in table and run RegisterStudentSvcImplTest first and capture the ID from MySQL Table)
//In below test Student detail is updated in MySQL database table "student" and then Restult test next() method is used
//Calling the next() method for the first time the result set pointer/cursor will be moved to the row with that ID

//**Important** ID has to be updated everytime this result is done OR use below SQL Command to clear auto increment values
// ALTER TABLE student AUTO_INCREMENT = 0;
/**
 * 
 * @author Danish Kamaal
 */
public class UpdateStudentSvcImplTest {

	@Test
	void testUpdateStudent() {
		System.out.println("Starting testUpdateStudentValidate()");

		int id = 1; // Update ID based on student Table Data
		String sfirstname = "Tom";
		String slastname = "Peterson";
		String age = "6";
		String email = "Tom@test.com";
		String mobile = "9234567899";
		String sgrade = "THIRD-A";

		Student sTU1 = new Student();

		// Setting Input parameters

		sTU1.setsFirstName("Tom");
		sTU1.setsLastName("Peterson");
		sTU1.setAge("6");
		sTU1.setEmail("Tom@test.com");
		sTU1.setMobile("9234567899");
		sTU1.setSgrade("THIRD-A");
		sTU1.setId(1); // Update ID based on student Table Data

		// Do the call

		UpdateStudentSvcImpl updateStudentSvcImpl = new UpdateStudentSvcImpl();
		updateStudentSvcImpl.updateStudent(sTU1);

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
				System.out.println("UpdateStudentTest PASSED");
			}
			rs.close();
			st.close();
			con3.close();

		} catch (ClassNotFoundException ex) {
			Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
