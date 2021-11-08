package com.elementaryschool.model.services.studentservice;

import com.elementaryschool.model.domain.Student;
import com.elementaryschool.model.services.SchoolService;

public interface UpdateStudentService extends SchoolService {
	
	public boolean updateStudent(Student student);

}
