package elemetaryschoolregistration.domain;

public class Teacher {
	/**
	 * 
	 * @author Danish Kamaal
	 */

	/** First Name of Teacher */

	private String tFirstName;

	/** Last Name of Teacher */

	private String tLastName;

	/** Teaching Experience */

	private int teacherExp;

	/**
	 * Teacher's Grade-Using it for matching with SQL Database, so that
	 * Object-Relational Mapping Can be done
	 */

	private int teacherGrade;

	/**
	 * @param tFirstName
	 * @param tLastName
	 * @param teacherExp
	 * @param teacherGrade
	 */
	public Teacher(String tFirstName, String tLastName, int teacherExp, int teacherGrade) {
		// super();
		this.tFirstName = tFirstName;
		this.tLastName = tLastName;
		this.teacherExp = teacherExp;
		this.teacherGrade = teacherGrade;
	}

	/**
	 * @return the tFirstName
	 */
	public String gettFirstName() {
		return tFirstName;
	}

	/**
	 * @param tFirstName the tFirstName to set
	 */
	public void settFirstName(String tFirstName) {
		this.tFirstName = tFirstName;
	}

	/**
	 * @return the tLastName
	 */
	public String gettLastName() {
		return tLastName;
	}

	/**
	 * @param tLastName the tLastName to set
	 */
	public void settLastName(String tLastName) {
		this.tLastName = tLastName;
	}

	/**
	 * @return the teacherExp
	 */
	public int getTeacherExp() {
		return teacherExp;
	}

	/**
	 * @param teacherExp the teacherExp to set
	 */
	public void setTeacherExp(int teacherExp) {
		this.teacherExp = teacherExp;
	}

	/**
	 * @return the teacherGrade
	 */
	public int getTeacherGrade() {
		return teacherGrade;
	}

	/**
	 * @param teacherGrade the teacherGrade to set
	 */
	public void setTeacherGrade(int teacherGrade) {
		this.teacherGrade = teacherGrade;
	}

	/**
	 * Validate if the instance variables are valid
	 * 
	 * @return boolean - true if instance variables are valid, else false
	 */

	public boolean validate() {

		if (tFirstName == null)
			return false;
		if (tLastName == null)
			return false;
		if (teacherExp < 0)
			return false;
		if (teacherGrade <= 0)
			return false;

		return true;
	}
}
