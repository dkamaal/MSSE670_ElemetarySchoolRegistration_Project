package com.elementaryschool.model.services.studentservice;

import javax.swing.table.DefaultTableModel;

import com.elementaryschool.model.services.SchoolService;

/**
 * @author Danish Kamaal
 *
 */

/**
 * Shows Student Object
 * 
 * @param Student Displays Student Application Information in Table
 * 
 * 
 */
public interface DisplayStudentService extends SchoolService {

	public final String NAME = "DisplayStudentService";

	public DefaultTableModel displayStudent();
	
}
