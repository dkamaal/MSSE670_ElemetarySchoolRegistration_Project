package com.elementaryschool.model.services.studentservice;

import com.elementaryschool.model.domain.Student;
import com.elementaryschool.model.services.SchoolService;


/**
 * @author Danish Kamaal
 *
 */

/** 
 * Delete a student application object 
 * @param Student
 * Delete student data
 *  
 * 
 * */

public interface DeleteStudentService extends SchoolService {
	
	public boolean deleteStudent(Student student);

}
