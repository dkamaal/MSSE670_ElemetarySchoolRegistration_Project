package com.elementaryschool.model.services.teacherservice;

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

import com.elementaryschool.model.domain.Teacher;

public class DisplayTeacherSvcImpl implements DisplayTeacherService {

	private DefaultTableModel teachermodel;

	public DefaultTableModel displayTeacher() {

		// Teacher tCH1 = new Teacher();

		Connection con4;
		PreparedStatement st;

		try {

			// Load the Properties File

			Properties dbprops = new Properties();
			// dbprops.load(new
			// FileInputStream("C:/Users/danishkamaal2011/eclipse-workspace/MSSE670_ElemetarySchoolRegistration_Project/config/database.properties"));
			dbprops.load(getClass().getResourceAsStream("/com/elementaryschool/config/database.properties"));
			// Read the dbprops

			String user = dbprops.getProperty("username");
			String password = dbprops.getProperty("password");
			String url = dbprops.getProperty("databaseurl");
			// establish the connection
			con4 = DriverManager.getConnection(url, user, password);

			DefaultTableModel model = new DefaultTableModel(
					new String[] { "GRADE ID", "TEACHER FIRST NAME", "TEACHER LAST NAME", "TEACHING EXP" }, 0);

			st = con4.prepareStatement("SELECT * FROM teacher");

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				String a = rs.getString("tfirstname");
				String b = rs.getString("tlastname");
				String c = rs.getString("teachergrade");
				String d = rs.getString("teacherexp");

				model.addRow(new Object[] { c, a, b, d });
				// Below Link was helpful in getting information to have data in to JTable
				// https://stackoverflow.com/questions/27815400/retrieving-data-from-jdbc-database-into-jtable/43772751

			}
			// Below Code closes Resultset, Statement and Connection
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
					Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, ex);
				}
			if (st != null)
				try {
					st.close();
				} catch (SQLException ex) {
					Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, ex);
				}
			if (con4 != null)
				try {
					con4.close();
				} catch (SQLException ex) {
					Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, ex);
				}

			return model;

		} catch (SQLException ex) {
			Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, ex);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return teachermodel; // All Rows of Data is returned to JTable

	}
}
