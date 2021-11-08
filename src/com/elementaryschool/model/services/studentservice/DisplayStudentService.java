package com.elementaryschool.model.services.studentservice;

import javax.swing.table.DefaultTableModel;

import com.elementaryschool.model.domain.Student;
import com.elementaryschool.model.services.SchoolService;

public interface DisplayStudentService extends SchoolService {
	
	/**
	 * @author Danish Kamaal
	 *
	 */

	/** 
	 * Shows Student Object
	 * @param Student
	 * Displays Student Application Information in Table
	 *  
	 * 
	 * */
	
	public DefaultTableModel displayStudent(Student student);

}
