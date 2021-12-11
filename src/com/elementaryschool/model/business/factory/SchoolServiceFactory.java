package com.elementaryschool.model.business.factory;

import java.util.Properties;

import com.elementaryschool.model.business.exceptions.ServiceLoadException;
import com.elementaryschool.model.services.SchoolService;

/**
 * School Service Factory Provides an interface to the Use Case Managers for
 * implementation services.
 * 
 * @author Danish Kamaal 
 * Thomas, I. (2013). E-Pedigree Project Code. Anderson College of Business & Computing, Regis University
 *
 */
public class SchoolServiceFactory {

	public SchoolServiceFactory() {
	}

	public SchoolService getService(String serviceName) throws ServiceLoadException {
		try {
			Class<?> c = Class.forName(getServImplName(serviceName));
			return (SchoolService) c.newInstance();
		} catch (Exception excp) {
			serviceName = serviceName + "Unable to load";
			throw new ServiceLoadException(serviceName, excp);
		}

	}

	private String getServImplName(String serviceName) throws Exception {

		//java.util.Properties props = new java.util.Properties();
		//java.io.FileInputStream source = new java.io.FileInputStream("com\\elementaryschool\\application.properties");
		
		
		// Load the Properties File

		Properties props = new Properties();
		//dbprops.load(new FileInputStream("C:/Users/danishkamaal2011/eclipse-workspace/MSSE670_ElemetarySchoolRegistration_Project/config/database.properties"));
		props.load(getClass().getResourceAsStream("/com/elementaryschool/config/application.properties"));
		
		//props.load(source);
		//source.close();
		return props.getProperty(serviceName);

	}

}