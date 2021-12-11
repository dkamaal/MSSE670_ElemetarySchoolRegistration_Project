package com.elementaryschool.model.services.studentservice;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import com.elementaryschool.model.domain.Student;

public class DeleteStudentSvcImpl implements DeleteStudentService {

	public boolean deleteStudent(Student student) {

		boolean isDeleteStudent = false; // Thomas, I. (2013). E-Pedigree Project Code. Anderson College of Business &
								// Computing, Regis University

		Connection con3;
		PreparedStatement insert;

		try {
			// register Oracle thin driver with DriverManager service

			int dialogResult = JOptionPane.showConfirmDialog(null,
					"If you click YES Student Application will be permanently deleted", "Warning",
					JOptionPane.YES_NO_OPTION);
			if (dialogResult == JOptionPane.YES_OPTION) {

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
				insert = con3.prepareStatement("DELETE FROM student where id = ?");
				insert.setInt(1, student.getId());
				insert.executeUpdate();
				JOptionPane.showMessageDialog(null, "Student Record Deleted");
				insert.close();
				con3.close();
			}


		} catch (SQLException ex) {
			Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isDeleteStudent;
	}

}
