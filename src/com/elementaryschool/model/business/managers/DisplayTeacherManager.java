package com.elementaryschool.model.business.managers;

import javax.swing.table.DefaultTableModel;

import com.elementaryschool.model.business.exceptions.ServiceLoadException;
import com.elementaryschool.model.business.factory.SchoolServiceFactory;
import com.elementaryschool.model.services.teacherservice.DisplayTeacherService;

/**
 * Display Teacher Manager
 * 
 * 
 * 
 * @author Danish Kamaal
 *
 */
//Thomas, I. (2013). E-Pedigree Project Code. Anderson College of Business & Computing, Regis University

public class DisplayTeacherManager extends ManagerSuperType {
	
	public DisplayTeacherManager() {
		
	}
	
	
	
	public DefaultTableModel displayTeacherTable() throws ServiceLoadException{
		
		
		
	 	SchoolServiceFactory serviceFactory = new SchoolServiceFactory();
    	DisplayTeacherService displayGradeSvc = (DisplayTeacherService)serviceFactory.getService("DisplayTeacherService");
    	DefaultTableModel displayTeacherManagerModel = displayGradeSvc.displayTeacher();
    	
    	return displayTeacherManagerModel;
		
	}
	
}
