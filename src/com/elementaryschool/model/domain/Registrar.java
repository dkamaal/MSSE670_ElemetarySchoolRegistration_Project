package com.elementaryschool.model.domain;

public class Registrar {
	/**
	 * 
	 * @author Danish Kamaal
	 */

	/** School Name */

	private String schoolName;

	/**
	 * @param schoolName
	 */
	public Registrar(String schoolName) {
		// super();
		this.schoolName = schoolName;
	}

	/**
	 * @return the schoolName
	 */
	public String getSchoolName() {
		return schoolName;
	}

	/**
	 * @param schoolName the schoolName to set
	 */
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	/**
	 * Validate if the instance variables are valid
	 * 
	 * @return boolean - true if instance variables are valid, else false
	 */

	public boolean validate() {

		if (schoolName == null)
			return false;

		return true;
	}
}
