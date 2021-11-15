package com.elementaryschool.model.business.managers;

import com.elementaryschool.model.business.exceptions.ServiceLoadException;
import com.elementaryschool.model.business.factory.SchoolServiceFactory;
import com.elementaryschool.model.services.SchoolService;


/**
 * Student Service Implementation Register Student Application
 * 
 * @author Danish Kamaal
 *
 */
//Thomas, I. (2013). E-Pedigree Project Code. Anderson College of Business & Computing, Regis University

public abstract class ManagerSuperType {
	private SchoolServiceFactory Servicefactory = new SchoolServiceFactory();
	
	protected SchoolService getService(String name) throws 
		ServiceLoadException
	{
	     return Servicefactory.getService(name);
	}
}
