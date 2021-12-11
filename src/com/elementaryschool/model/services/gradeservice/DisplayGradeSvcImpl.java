package com.elementaryschool.model.services.gradeservice;

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

import com.elementaryschool.model.domain.Grade;

public class DisplayGradeSvcImpl implements DisplayGradeService {

	private DefaultTableModel grademodel;

	public DefaultTableModel displayGrade() {

		// Grade gRD1 = new Grade();

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

			DefaultTableModel model = new DefaultTableModel(new String[] { "GRADE ID", "GRADE & SECTION" }, 0);

			st = con4.prepareStatement("SELECT * FROM grade");

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				String a = rs.getString("gid");
				String b = rs.getString("gradesection");

				model.addRow(new Object[] { a, b });

				// Below Link was helpful in getting information to have data in to JTable
				// https://stackoverflow.com/questions/27815400/retrieving-data-from-jdbc-database-into-jtable/43772751

			}
			// Below Code closes Resultset, Statement and Connection
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
					Logger.getLogger(Grade.class.getName()).log(Level.SEVERE, null, ex);
				}
			if (st != null)
				try {
					st.close();
				} catch (SQLException ex) {
					Logger.getLogger(Grade.class.getName()).log(Level.SEVERE, null, ex);
				}
			if (con4 != null)
				try {
					con4.close();
				} catch (SQLException ex) {
					Logger.getLogger(Grade.class.getName()).log(Level.SEVERE, null, ex);
				}

			return model;

		} catch (SQLException ex) {
			Logger.getLogger(Grade.class.getName()).log(Level.SEVERE, null, ex);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return grademodel; // All Rows of Data is returned to JTable

	}

}
