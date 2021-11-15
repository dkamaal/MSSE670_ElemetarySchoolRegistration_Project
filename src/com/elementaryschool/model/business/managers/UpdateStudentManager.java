package com.elementaryschool.model.business.managers;


import com.elementaryschool.model.business.exceptions.ServiceLoadException;
import com.elementaryschool.model.business.factory.SchoolServiceFactory;
import com.elementaryschool.model.domain.Student;
import com.elementaryschool.model.services.studentservice.UpdateStudentService;

/**
 * Update Student Manager
 * 
 * 
 * 
 * @author Danish Kamaal
 *
 */
//Thomas, I. (2013). E-Pedigree Project Code. Anderson College of Business & Computing, Regis University

public class UpdateStudentManager extends ManagerSuperType {

	public UpdateStudentManager() {
		
	}
	
	public boolean updateNewStudent(Student student) throws ServiceLoadException{
		
		boolean isNewStudentUpdated = false;
		
	 	SchoolServiceFactory serviceFactory = new SchoolServiceFactory();
    	UpdateStudentService updateStudentSvc = (UpdateStudentService)serviceFactory.getService("UpdateStudentService");
    	updateStudentSvc.updateStudent(student);
    	
    	return isNewStudentUpdated;
		
	}
	
}