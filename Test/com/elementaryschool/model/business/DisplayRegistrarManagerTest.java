package com.elementaryschool.model.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;



import org.junit.Before;
import com.elementaryschool.model.business.exceptions.ServiceLoadException;
import com.elementaryschool.model.business.factory.SchoolServiceFactory;
import com.elementaryschool.model.business.managers.DisplayRegistrarManager;

public class DisplayRegistrarManagerTest {

	private String displayRegistrarManagerSchoolName;
	SchoolServiceFactory serviceFactory;

	@Before
	public void testSetUp() throws Exception {

		serviceFactory = new SchoolServiceFactory();

	}

	/**
	 * 
	 * @author Danish Kamaal
	 *
	 *         Testing DisplayRegistrarManager ability to get School name by
	 *         calling the service factory to serve up the DisplayRegistrarService
	 *         Then DisplayRegistrarManager can execute the DisplayRegistrarSvcImpl.
	 *
	 */

	@Test
	public String testDisplayRegistrarManager() {
		System.out.println("Starting testDisplayRegistrarManager()");

		DisplayRegistrarManager displayRegistrarManager = new DisplayRegistrarManager();
		try {

			String displayRegistrarSchNameTest = displayRegistrarManager.displayRegistrarSchoolName();

			return displayRegistrarSchNameTest;

		} catch (ServiceLoadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
		return displayRegistrarManagerSchoolName;

	}


	@Test

	public void testDisplayRegistrarManagerCompare() {

		try {
			DisplayRegistrarManagerTest dspRgsMgr = new DisplayRegistrarManagerTest();
			String RgsTestSchoolName = dspRgsMgr.testDisplayRegistrarManager();
			assertEquals(RgsTestSchoolName, "MSSE 670-Elementary School Registration Project");
			System.out.println("DisplayRegistrarManagerTest Passed");
		}

		catch (Exception e) {
			System.out.println("Unable to load School Name");
		}

	}

}
