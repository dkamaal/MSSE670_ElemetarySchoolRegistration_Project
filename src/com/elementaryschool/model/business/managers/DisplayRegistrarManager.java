package com.elementaryschool.model.business.managers;

import com.elementaryschool.model.business.exceptions.ServiceLoadException;
import com.elementaryschool.model.business.factory.SchoolServiceFactory;
import com.elementaryschool.model.services.registrarservice.DisplayRegistrarService;

/**
 * Display Registrar Manager
 * 
 * 
 * 
 * @author Danish Kamaal
 *
 */
//Thomas, I. (2013). E-Pedigree Project Code. Anderson College of Business & Computing, Regis University

public class DisplayRegistrarManager extends ManagerSuperType {
	
	public DisplayRegistrarManager() {
		
	}
	
	
	
	public String displayRegistrarSchoolName() throws ServiceLoadException{
		
		
		
	 	SchoolServiceFactory serviceFactory = new SchoolServiceFactory();
    	DisplayRegistrarService displayRegistrarSvc = (DisplayRegistrarService)serviceFactory.getService("DisplayRegistrarService");
    	String displayRegistrarManagerSchoolName = displayRegistrarSvc.displayRegistrar();
    	
    	return displayRegistrarManagerSchoolName;
		
	}
	
}