package com.elementaryschool.model.services.studentservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.table.DefaultTableModel;

import com.elementaryschool.model.domain.Grade;
import com.elementaryschool.model.domain.Student;

public class DisplayStudentSvcImpl implements DisplayStudentService {


	public DefaultTableModel displayStudent(Student student) {
	
		DefaultTableModel studentmodel = null;

		Student sTU4 = new Student();

		Connection con5;
		PreparedStatement st;

		try {

			// register Oracle thin driver with DriverManager service

			Class.forName("com.mysql.cj.jdbc.Driver");

			// variables
			final String url = "jdbc:mysql:///school";
			final String user = "root";
			final String password = "Root4you$";

			// establish the connection
			con5 = DriverManager.getConnection(url, user, password);

			DefaultTableModel model = new DefaultTableModel(
					new String[] { "REGISTRATION ID", "STUDENT FIRST NAME", "STUDENT LAST NAME", "AGE", "EMAIL", "MOBILE", "STUDENT GRADE" }, 0);

			st = con5.prepareStatement("SELECT * FROM student");

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				String j = rs.getString("id");
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

		} catch (ClassNotFoundException ex) {
			Logger.getLogger(Grade.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(Grade.class.getName()).log(Level.SEVERE, null, ex);
		}
		return studentmodel; // All Rows of Data is returned to JTable
	}

}
