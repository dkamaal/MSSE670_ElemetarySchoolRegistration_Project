package com.elementaryschool.model.services.studentservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import com.elementaryschool.model.domain.Student;

public class UpdateStudentSvcImpl implements UpdateStudentService {
	// Thomas, I. (2013). E-Pedigree Project Code. Anderson College of Business &
	// Computing, Regis University
	public boolean updateStudent(Student student) {

		boolean isUpdateStudent = false;

		Student sTU2 = new Student();

		Connection con2;
		PreparedStatement insert;

		try {

			// register Oracle thin driver with DriverManager service

			Class.forName("com.mysql.cj.jdbc.Driver");

			// variables
			final String url = "jdbc:mysql:///school";
			final String user = "root";
			final String password = "Root4you$";

			// establish the connection
			con2 = DriverManager.getConnection(url, user, password);

			insert = con2.prepareStatement(
					"update student set sfirstname=?, slastname=?, age=?, email=?, mobile=?, sgrade=? WHERE id=?");
			insert.setString(1, student.getsFirstName());
			insert.setString(2, student.getsLastName());
			insert.setString(3, student.getAge());
			insert.setString(4, student.getEmail());
			insert.setString(5, student.getMobile());
			insert.setString(6, student.getSgrade());
			insert.setInt(7, student.getId());
			insert.executeUpdate(); // To execute the query
			JOptionPane.showMessageDialog(null, "Student Record Updated");

		} catch (ClassNotFoundException ex) {
			Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
		}

		return isUpdateStudent;
	}

}
