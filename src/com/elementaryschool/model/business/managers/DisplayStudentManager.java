package com.elementaryschool.model.business.managers;

import javax.swing.table.DefaultTableModel;

import com.elementaryschool.model.business.exceptions.ServiceLoadException;
import com.elementaryschool.model.business.factory.SchoolServiceFactory;
import com.elementaryschool.model.services.studentservice.DisplayStudentService;

/**
 * Display Student Manager
 * 
 * 
 * 
 * @author Danish Kamaal
 *
 */
//Thomas, I. (2013). E-Pedigree Project Code. Anderson College of Business & Computing, Regis University

public class DisplayStudentManager extends ManagerSuperType {
	
	public DisplayStudentManager() {
		
	}
	
	
	
	public DefaultTableModel displayStudentTable() throws ServiceLoadException{
		
		
		
	 	SchoolServiceFactory serviceFactory = new SchoolServiceFactory();
    	DisplayStudentService displayStudentSvc = (DisplayStudentService)serviceFactory.getService("DisplayStudentService");
    	DefaultTableModel displayStudentManagerModel = displayStudentSvc.displayStudent();
    	
    	return displayStudentManagerModel;
		
	}
	
}

