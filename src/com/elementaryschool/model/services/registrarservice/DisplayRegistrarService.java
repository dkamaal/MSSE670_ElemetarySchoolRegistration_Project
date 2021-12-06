package com.elementaryschool.model.services.registrarservice;


import com.elementaryschool.model.services.SchoolService;


/**
 * @author Danish Kamaal
 *
 */

/** 
 * Shows Registrar Object
 * @param Registrar
 * Displays School Name in Label
 *  
 * 
 * */

public interface DisplayRegistrarService extends SchoolService {
	
	public final String NAME = "DisplayRegistrarService";
	
	public String displayRegistrar();

}