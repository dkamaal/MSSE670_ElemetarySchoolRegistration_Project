package com.elementaryschool.model.services.studentservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import com.elementaryschool.model.domain.Student;

public class DeleteStudentSvcImpl implements DeleteStudentService {

	public boolean deleteStudent(Student student) {

		boolean isGood = false; //Thomas, I. (2013). E-Pedigree Project Code. Anderson College of Business & Computing, Regis University

		Student sTU3 = new Student();

		Connection con3;
		PreparedStatement insert;

		try {
			// register Oracle thin driver with DriverManager service
			

			int dialogResult = JOptionPane.showConfirmDialog(null,
					"If you click YES record will be permanently deleted", "Warning", JOptionPane.YES_NO_OPTION);
			if (dialogResult == JOptionPane.YES_OPTION) {

				Class.forName("com.mysql.cj.jdbc.Driver");

				// variables
				final String url = "jdbc:mysql:///school";
				final String user = "root";
				final String password = "Root4you$";
				

				// establish the connection
				con3 = DriverManager.getConnection(url, user, password);
				insert = con3.prepareStatement("DELETE FROM student where id = ?");
				insert.setInt(1, student.getId());
				insert.executeUpdate();
				JOptionPane.showMessageDialog(null, "Student Record Deleted");

			}
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
		}

		return isGood;
	}

}
