package com.elementaryschool.model.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


import javax.swing.table.DefaultTableModel;

import org.junit.Before;
import com.elementaryschool.model.business.exceptions.ServiceLoadException;
import com.elementaryschool.model.business.factory.SchoolServiceFactory;
import com.elementaryschool.model.business.managers.DisplayTeacherManager;

public class DisplayTeacherManagerTest {

	private DefaultTableModel displayTeacherManagerTable;
	SchoolServiceFactory serviceFactory;

	@Before
	public void testSetUp() throws Exception {

		serviceFactory = new SchoolServiceFactory();

	}

	/**
	 * 
	 * @author Danish Kamaal
	 *
	 *         Testing DisplayTeacherManager ability to get Teacher Table by
	 *         calling the service factory to serve up the DisplayTeacherService
	 *         Then DisplayTeacherManager can execute the DisplayTeacherSvcImpl.
	 *
	 */

	@Test
	public DefaultTableModel testDisplayTeacherManager() {
		System.out.println("Starting testDisplayTeacherManager()");

		DisplayTeacherManager displayTeacherManager = new DisplayTeacherManager();
		try {

			DefaultTableModel displayTeacherManagerModelTest = displayTeacherManager.displayTeacherTable();

			return displayTeacherManagerModelTest;

		} catch (ServiceLoadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return displayTeacherManagerTable;

	}


	@Test

	public void testDisplayTeacherManagerCompare() {

		try {
			DisplayTeacherManagerTest dspTchMgr = new DisplayTeacherManagerTest();
			DefaultTableModel tchTestModel = dspTchMgr.testDisplayTeacherManager();
			assertNotNull(tchTestModel, "Test Failed");
			System.out.println("DisplayTeacherManagerTest Passed");
		}

		catch (Exception e) {
			System.out.println("Unable to load Teacher Table");
		}

	}

}
