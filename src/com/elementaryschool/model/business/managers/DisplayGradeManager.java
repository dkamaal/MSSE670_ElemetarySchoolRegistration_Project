package com.elementaryschool.model.business.managers;

import javax.swing.table.DefaultTableModel;

import com.elementaryschool.model.business.exceptions.ServiceLoadException;
import com.elementaryschool.model.business.factory.SchoolServiceFactory;
import com.elementaryschool.model.services.gradeservice.DisplayGradeService;

/**
 * Display Grade Manager
 * 
 * 
 * 
 * @author Danish Kamaal
 *
 */
//Thomas, I. (2013). E-Pedigree Project Code. Anderson College of Business & Computing, Regis University

public class DisplayGradeManager extends ManagerSuperType {
	
	public DisplayGradeManager() {
		
	}
	
	
	
	public DefaultTableModel displayGradeTable() throws ServiceLoadException{
		
		
		
	 	SchoolServiceFactory serviceFactory = new SchoolServiceFactory();
    	DisplayGradeService displayGradeSvc = (DisplayGradeService)serviceFactory.getService("DisplayGradeService");
    	DefaultTableModel displayGradeManagerModel = displayGradeSvc.displayGrade();
    	
    	return displayGradeManagerModel;
		
	}
	
}

