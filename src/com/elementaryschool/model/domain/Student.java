package com.elementaryschool.model.domain;

/**
 * 
 * @author Danish Kamaal
 */

public class Student {

	/** ID of Student */

	private int id;

	/** First Name of Student */

	private String sFirstName;

	/** Last Name of Student */

	private String sLastName;

	/** Age of Student */

	private String age;

	/** email of Student */

	private String email;

	/** Mobile of Student */

	private String mobile;

	/**
	 * Grade of Student-Using it for matching with SQL Database.
	 */

	private String sgrade;

	/**
	 * @param id
	 * @param sFirstName
	 * @param sLastName
	 * @param age
	 * @param email
	 * @param mobile
	 * @param sgrade
	 */
	
	public Student()
	{
		// TODO Auto-generated constructor stub
	}
	
	public Student(int id, String sFirstName, String sLastName, String age, String email, String mobile,
			String sgrade) {
		super();
		this.id = id;
		this.sFirstName = sFirstName;
		this.sLastName = sLastName;
		this.age = age;
		this.email = email;
		this.mobile = mobile;
		this.sgrade = sgrade;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the sFirstName
	 */
	public String getsFirstName() {
		return sFirstName;
	}

	/**
	 * @param sFirstName the sFirstName to set
	 */
	public void setsFirstName(String sFirstName) {
		this.sFirstName = sFirstName;
	}

	/**
	 * @return the sLastName
	 */
	public String getsLastName() {
		return sLastName;
	}

	/**
	 * @param sLastName the sLastName to set
	 */
	public void setsLastName(String sLastName) {
		this.sLastName = sLastName;
	}

	/**
	 * @return the age
	 */
	public String getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(String age) {
		this.age = age;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the sgrade
	 */
	public String getSgrade() {
		return sgrade;
	}

	/**
	 * @param sgrade the sgrade to set
	 */
	public void setSgrade(String sgrade) {
		this.sgrade = sgrade;
	}

	/**
	 * Validate if the instance variables are valid
	 * 
	 * @return boolean - true if instance variables are valid, else false
	 */

	public boolean validate() {

		if (id <= 0)
			return false;
		if (sFirstName == null)
			return false;
		if (sLastName == null)
			return false;
		if (age == null)
			return false;
		if (email == null)
			return false;
		if (mobile == null)
			return false;
		if (sgrade == null)
			return false;

		return true;
	}

	
}
	