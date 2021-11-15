package com.elementaryschool.model.services.studentservice;

import com.elementaryschool.model.domain.Student;
import com.elementaryschool.model.services.SchoolService;
/**
 * @author Danish Kamaal
 *
 */

/** 
 * Update student application object 
 * @param Student
 * Update student data
 *  
 * 
 * */
public interface UpdateStudentService extends SchoolService {

	public final String NAME = "UpdateStudentService";

	public boolean updateStudent(Student student);

}
