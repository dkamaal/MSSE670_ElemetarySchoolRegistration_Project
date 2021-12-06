package com.elementaryschool.model.services.registrarservice;


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

import com.elementaryschool.model.domain.Grade;

public class DisplayRegistrarSvcImpl implements DisplayRegistrarService {



	public String displayRegistrar() {

		String eleSchName = null;

		Connection con4;
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
			con4 = DriverManager.getConnection(url, user, password);

			st = con4.prepareStatement("SELECT * FROM schoolnamelabel");

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				String esn = rs.getString("elementaryschoolname");
				return esn;
			}


		} catch (SQLException ex) {
			Logger.getLogger(Grade.class.getName()).log(Level.SEVERE, null, ex);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return eleSchName;
	}

}