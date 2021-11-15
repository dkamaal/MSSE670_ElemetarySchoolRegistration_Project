package com.elementaryschool.model.services.teacherservice;

import javax.swing.table.DefaultTableModel;

import com.elementaryschool.model.domain.Teacher;
import com.elementaryschool.model.services.SchoolService;

/**
 * @author Danish Kamaal
 *
 */

/** 
 * Shows Teacher Object
 * @param Teacher
 * Displays Teacher Information in Table
 *  
 * 
 * */

public interface DisplayTeacherService extends SchoolService {
	
	public final String NAME = "DisplayTeacherService";
	
	public DefaultTableModel displayTeacher();

}
