package com.elementaryschool.model.business.managers;

import com.elementaryschool.model.business.exceptions.ServiceLoadException;
import com.elementaryschool.model.business.factory.SchoolServiceFactory;
import com.elementaryschool.model.domain.Student;
import com.elementaryschool.model.services.studentservice.RegisterStudentService;

/**
 * Register Student Manager
 * 
 * 
 * 
 * @author Danish Kamaal
 *
 */
//Thomas, I. (2013). E-Pedigree Project Code. Anderson College of Business & Computing, Regis University

public class RegisterStudentManager extends ManagerSuperType {

	public RegisterStudentManager() {
		
	}
	
	public boolean registerNewStudent(Student student) throws ServiceLoadException{
		
		boolean isNewStudentAdded = false;
		
	 	SchoolServiceFactory serviceFactory = new SchoolServiceFactory();
    	RegisterStudentService registerStudentSvc = (RegisterStudentService)serviceFactory.getService("RegisterStudentService");
    	registerStudentSvc.registerStudent(student);
    	
    	return isNewStudentAdded;
		
	}
	
}
