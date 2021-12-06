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

import javax.swing.table.DefaultTableModel;

import com.elementaryschool.model.domain.Student;

public class DisplayStudentSvcImpl implements DisplayStudentService {
	
	private DefaultTableModel studentmodel;

	public DefaultTableModel displayStudent() {

		

	//	Student sTU4 = new Student();

		Connection con5;
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
			con5 = DriverManager.getConnection(url, user, password);

			DefaultTableModel model = new DefaultTableModel(new String[] { "REGISTRATION ID", "STUDENT FIRST NAME",
					"STUDENT LAST NAME", "AGE", "EMAIL", "MOBILE", "STUDENT GRADE" }, 0);

			st = con5.prepareStatement("SELECT * FROM student");

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				int j = rs.getInt("id");
				String d = rs.getString("sfirstname");
				String e = rs.getString("slastname");
				String f = rs.getString("age");
				String g = rs.getString("email");
				String h = rs.getString("mobile");
				String i = rs.getString("sgrade");
				model.addRow(new Object[] { j, d, e, f, g, h, i });

				// Below Link was helpful in getting information to have data in to JTable
				// https://stackoverflow.com/questions/27815400/retrieving-data-from-jdbc-database-into-jtable/43772751

			}

			return model;

		} catch (SQLException ex) {
			Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return studentmodel; // All Rows of Data is returned to JTable
	}

}
