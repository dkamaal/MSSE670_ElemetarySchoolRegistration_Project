package com.elementaryschool.model.business;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.table.DefaultTableModel;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.elementaryschool.model.business.exceptions.ServiceLoadException;
import com.elementaryschool.model.business.factory.SchoolServiceFactory;
import com.elementaryschool.model.business.managers.DisplayStudentManager;

public class DisplayStudentManagerTest {

	private DefaultTableModel displayStudentManagerTable;
	SchoolServiceFactory serviceFactory;

	@Before
	public void testSetUp() throws Exception {

		serviceFactory = new SchoolServiceFactory();

	}

	/**
	 * 
	 * @author Danish Kamaal
	 *
	 *         Testing DisplayStudentManager ability to view Student Registration by
	 *         calling the service factory to serve up the DisplayStudentService
	 *         Then DisplayStudentManager can execute the DisplayStudentSvcImpl.
	 *
	 */

	@Test
	public DefaultTableModel testDisplayStudentManager() {
		System.out.println("Starting testDisplayStudentManager()");

		DisplayStudentManager displayStudentManager = new DisplayStudentManager();
		try {

			DefaultTableModel displayStudentManagerModelTest = displayStudentManager.displayStudentTable();

			return displayStudentManagerModelTest;

		} catch (ServiceLoadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return displayStudentManagerTable;

	}


	@Test

	public void testDisplayStudentManagerCompare() {

		try {
			DisplayStudentManagerTest dspStuMgr = new DisplayStudentManagerTest();
			DefaultTableModel stuTestModel = dspStuMgr.testDisplayStudentManager();
			assertNotNull(stuTestModel, "Test Failed");
			System.out.println("DisplayStudentManagerTest Passed");
		}

		catch (Exception e) {
			System.out.println("Unable to load Student Table");
		}

	}

}
