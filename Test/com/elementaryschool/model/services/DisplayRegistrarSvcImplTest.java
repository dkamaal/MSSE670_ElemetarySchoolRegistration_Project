package com.elementaryschool.model.services;


import static org.junit.jupiter.api.Assertions.*;

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

import org.junit.jupiter.api.Test;

import com.elementaryschool.model.domain.Grade;

//Test to check if School Name is getting returned from Database
/**
 * 
 * @author Danish Kamaal
 */
class DisplayRegistrarSvcImplTest {

	@Test
	void testDisplayRegistrar() {
		System.out.println("Starting testDisplayRegistrar()");

		//School Name is returned

	
		String elementaryschoolname = "Elementary School Registration Project";

		Connection con3;
		PreparedStatement st;

		try {

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

			st = con3.prepareStatement("SELECT * FROM schoolnamelabel");
			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				assertEquals(elementaryschoolname, rs.getString("elementaryschoolname"));

				System.out.println("DisplayRegistrarTest PASSED");
			}
			rs.close();
			st.close();
			con3.close();

		} catch (SQLException ex) {
			Logger.getLogger(Grade.class.getName()).log(Level.SEVERE, null, ex);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}