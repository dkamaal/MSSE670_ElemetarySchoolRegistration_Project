package com.elementaryschool.model.services.studentservice;

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

import javax.swing.JOptionPane;

import com.elementaryschool.model.domain.Student;

/**
 * Student Service Implementation Register Student Application
 * 
 * 
 * 
 * @author Danish Kamaal
 *
 */
//Thomas, I. (2013). E-Pedigree Project Code. Anderson College of Business & Computing, Regis University
public class RegisterStudentSvcImpl implements RegisterStudentService {

	public boolean registerStudent(Student student) {

		boolean isRegisterStudent = false;

		Connection con1;
		PreparedStatement insert;

		try {

			// Load the Properties File

			Properties dbprops = new Properties();
			dbprops.load(new FileInputStream("C:/Users/danishkamaal2011/eclipse-workspace/MSSE670_ElemetarySchoolRegistration_Project/config/database.properties"));

			// Read the dbprops

			String user = dbprops.getProperty("username");
			String password = dbprops.getProperty("password");
			String url = dbprops.getProperty("databaseurl");

			// establish the connection to MySQL Database

			con1 = DriverManager.getConnection(url, user, password);

			// Check if Record Already Exist in Database

			insert = con1.prepareStatement("SELECT * FROM student WHERE sfirstname = ? AND slastname = ? AND age= ?");
			insert.setString(1, student.getsFirstName());
			insert.setString(2, student.getsLastName());
			insert.setString(3, student.getAge());

			ResultSet rs = insert.executeQuery();

			if (!rs.isBeforeFirst()) { // isBeforeFirst() will return true if the cursor is before the first row
				insert = con1.prepareStatement(
						"insert into student (sfirstname,slastname,age,email,mobile,sgrade)values(?,?,?,?,?,?)");
				insert.setString(1, student.getsFirstName());
				insert.setString(2, student.getsLastName());
				insert.setString(3, student.getAge());
				insert.setString(4, student.getEmail());
				insert.setString(5, student.getMobile());
				insert.setString(6, student.getSgrade());
				insert.executeUpdate(); // To execure the query
				JOptionPane.showMessageDialog(null, "Student Record Saved");
			}

			else {
				JOptionPane.showMessageDialog(null,
						"Student Registration Record Exist with Same First Name, Last Name and Age");
			}
			rs.close();
			insert.close();
			con1.close();

		} catch (SQLException ex) {
			Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return isRegisterStudent;
	}

}
