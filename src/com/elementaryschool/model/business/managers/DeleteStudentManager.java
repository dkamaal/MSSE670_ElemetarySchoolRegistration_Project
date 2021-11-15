package com.elementaryschool.model.business.managers;

import com.elementaryschool.model.business.exceptions.ServiceLoadException;
import com.elementaryschool.model.business.factory.SchoolServiceFactory;
import com.elementaryschool.model.domain.Student;
import com.elementaryschool.model.services.studentservice.DeleteStudentService;

/**
 * Delete Student Manager
 * 
 * 
 * 
 * @author Danish Kamaal
 *
 */
//Thomas, I. (2013). E-Pedigree Project Code. Anderson College of Business & Computing, Regis University

public class DeleteStudentManager extends ManagerSuperType {

	public DeleteStudentManager() {
		
	}
	
	public boolean deleteNewStudent(Student student) throws ServiceLoadException{
		
		boolean isNewStudentDeleted = false;
		
	 	SchoolServiceFactory serviceFactory = new SchoolServiceFactory();
    	DeleteStudentService deleteStudentSvc = (DeleteStudentService)serviceFactory.getService("DeleteStudentService");
    	deleteStudentSvc.deleteStudent(student);
    	
    	return isNewStudentDeleted;
		
	}
	
}