package com.elementaryschool.model.services.studentservice;
import com.elementaryschool.model.domain.Student;
import com.elementaryschool.model.services.SchoolService;



/**
 * @author Danish Kamaal
 *
 */

/** 
 * Create a student application object 
 * @param Student
 * register student data
 *  
 * 
 * */

public interface RegisterStudentService extends SchoolService {
	
	public boolean registerStudent(Student student);
}
