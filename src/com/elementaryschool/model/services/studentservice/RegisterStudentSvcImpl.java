package com.elementaryschool.model.services.studentservice;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import com.elementaryschool.model.domain.Student;

/**
 * Student Service Implementation
 * Register Student Application
 *  
 * 
 * 
 * @author Danish Kamaal
 *
 */
//Thomas, I. (2013). E-Pedigree Project Code. Anderson College of Business & Computing, Regis University
public class RegisterStudentSvcImpl implements RegisterStudentService {

	public boolean registerStudent(Student student) {
		
		boolean isGood = false;
		
		Student sTU1 = new Student();
		
		Connection con1;
		PreparedStatement insert;

	try {

	// register Oracle thin driver with DriverManager service

		
	Class.forName("com.mysql.cj.jdbc.Driver");

	// variables
	
	final String url = "jdbc:mysql:///school";
	final String user = "root";
	final String password = "Root4you$";

	// establish the connection
	
	con1 = DriverManager.getConnection(url, user, password);


	insert = con1.prepareStatement(
			"insert into student (sfirstname,slastname,age,email,mobile,sgrade)values(?,?,?,?,?,?)");
	insert.setString(1, student.getsFirstName());
	insert.setString(2, student.getsLastName());
	insert.setString(3, student.getAge());
	insert.setString(4, student.getEmail());
	insert.setString(5, student.getMobile());
	insert.setString(6, student.getSgrade());
	insert.executeUpdate(); // To execure the query
	JOptionPane.showMessageDialog(null, "Record Saved");



	} catch (ClassNotFoundException ex) {
	Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
	} catch (SQLException ex) {
	Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
	}
		
		return isGood;
	}

}
