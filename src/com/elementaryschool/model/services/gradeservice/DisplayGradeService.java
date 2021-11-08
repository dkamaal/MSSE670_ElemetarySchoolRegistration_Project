package com.elementaryschool.model.services.gradeservice;

import javax.swing.table.DefaultTableModel;

import com.elementaryschool.model.domain.Student;
import com.elementaryschool.model.services.SchoolService;


/**
 * @author Danish Kamaal
 *
 */

/** 
 * Shows both Grade Object
 * @param Grade
 * Displays Grade Information in Table
 *  
 * 
 * */

public interface DisplayGradeService extends SchoolService {
	
	public DefaultTableModel displayGrade(Student student);

}
