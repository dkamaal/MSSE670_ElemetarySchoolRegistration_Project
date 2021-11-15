package com.elementaryschool.model.services;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

import com.elementaryschool.model.domain.Grade;

//Test to check if Grade Table is returning data
/**
 * 
 * @author Danish Kamaal
 */
class DisplayGradeSvcImplTest {

	@Test
	void testDisplayGrade() {
		System.out.println("Starting testDisplayGrade()");

		// Grade table is returned

		int gid = 7;
		String gradesection = "THIRD-A";

		Connection con3;
		PreparedStatement st;

		try {

			// register Oracle thin driver with DriverManager service

			Class.forName("com.mysql.cj.jdbc.Driver");

			// variables

			final String url = "jdbc:mysql:///school";
			final String user = "root";
			final String password = "Root4you$";

			// establish the connection

			con3 = DriverManager.getConnection(url, user, password);

			st = con3.prepareStatement("SELECT * FROM grade where gid = 7");
			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				assertEquals(gid, rs.getInt(1));
				assertEquals(gradesection, rs.getString("gradesection"));

				System.out.println("DisplayGradeTest PASSED");
			}
			rs.close();
			st.close();
			con3.close();
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(Grade.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(Grade.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
}
