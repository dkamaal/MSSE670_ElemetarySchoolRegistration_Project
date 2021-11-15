package com.elementaryschool.model.services.gradeservice;

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

public class DisplayGradeSvcImpl implements DisplayGradeService {

	private DefaultTableModel grademodel;

	public DefaultTableModel displayGrade() {

		// Grade gRD1 = new Grade();

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

			DefaultTableModel model = new DefaultTableModel(new String[] { "GRADE ID", "GRADE AND SECTION" }, 0);

			st = con4.prepareStatement("SELECT * FROM grade");

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				String a = rs.getString("gid");
				String b = rs.getString("gradesection");

				model.addRow(new Object[] { a, b });

				// Below Link was helpful in getting information to have data in to JTable
				// https://stackoverflow.com/questions/27815400/retrieving-data-from-jdbc-database-into-jtable/43772751

			}

			return model;

		} catch (ClassNotFoundException ex) {
			Logger.getLogger(Grade.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(Grade.class.getName()).log(Level.SEVERE, null, ex);
		}
		return grademodel; // All Rows of Data is returned to JTable

	}

}
