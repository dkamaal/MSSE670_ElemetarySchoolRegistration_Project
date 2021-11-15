package com.elementaryschool.model.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;



import javax.swing.table.DefaultTableModel;

import org.junit.Before;
import com.elementaryschool.model.business.exceptions.ServiceLoadException;
import com.elementaryschool.model.business.factory.SchoolServiceFactory;
import com.elementaryschool.model.business.managers.DisplayGradeManager;

public class DisplayGradeManagerTest {

	private DefaultTableModel displayGradeManagerTable;
	SchoolServiceFactory serviceFactory;

	@Before
	public void testSetUp() throws Exception {

		serviceFactory = new SchoolServiceFactory();

	}

	/**
	 * 
	 * @author Danish Kamaal
	 *
	 *         Testing DisplayGradeManager ability to get Grade Table by
	 *         calling the service factory to serve up the DisplayGradeService
	 *         Then DisplayGradeManager can execute the DisplayGradeSvcImpl.
	 *
	 */

	@Test
	public DefaultTableModel testDisplayGradeManager() {
		System.out.println("Starting testDisplayGradeManager()");

		DisplayGradeManager displayGradeManager = new DisplayGradeManager();
		try {

			DefaultTableModel displayGradeManagerModelTest = displayGradeManager.displayGradeTable();

			return displayGradeManagerModelTest;

		} catch (ServiceLoadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return displayGradeManagerTable;

	}


	@Test

	public void testDisplayGradeManagerCompare() {

		try {
			DisplayGradeManagerTest dspGrdMgr = new DisplayGradeManagerTest();
			DefaultTableModel grdTestModel = dspGrdMgr.testDisplayGradeManager();
			assertNotNull(grdTestModel, "Test Failed");
			System.out.println("DisplayGradeManagerTest Passed");
		}

		catch (Exception e) {
			System.out.println("Unable to load Grade Table");
		}

	}

}
