package com.elementaryschool.model.services.teacherservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.table.DefaultTableModel;

import com.elementaryschool.model.domain.Teacher;

public class DisplayTeacherSvcImpl implements DisplayTeacherService {
	
	private DefaultTableModel teachermodel;

	public DefaultTableModel displayTeacher() {
		
		

		//Teacher tCH1 = new Teacher();

		Connection con4;
		PreparedStatement st;

		try {

			// register Oracle thin driver with DriverManager service

			Class.forName("com.mysql.cj.jdbc.Driver");

			// variables
			final String url = "jdbc:mysql:///school";
			final String user = "root";
			final String password = "Root4you$";

			// establish the connection
			con4 = DriverManager.getConnection(url, user, password);

			DefaultTableModel model = new DefaultTableModel(
					new String[] { "TEACHER FIRST NAME", "TEACHER LAST NAME", "GRADE ID", "TEACHING EXP" },
					0);

			st = con4.prepareStatement("SELECT * FROM teacher");

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				String a = rs.getString("tfirstname");
				String b = rs.getString("tlastname");
				String c = rs.getString("teachergrade");
				String d = rs.getString("teacherexp");

				model.addRow(new Object[] { a, b, c, d });
				// Below Link was helpful in getting information to have data in to JTable
				// https://stackoverflow.com/questions/27815400/retrieving-data-from-jdbc-database-into-jtable/43772751

			}

			return model;

		} catch (ClassNotFoundException ex) {
			Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, ex);
		}
		return teachermodel; // All Rows of Data is returned to JTable

	}
}
