package elemetaryschoolregistration.domain;

/**
 * 
 * @author Danish Kamaal
 */
public class Grade {

	/** Grade ID */

	private int gid;

	/** Grade and Section Name */

	private String gradeSection;

	/**
	 * @param gid
	 * @param gradeSection
	 */
	public Grade(int gid, String gradeSection) {
		// super();
		this.gid = gid;
		this.gradeSection = gradeSection;
	}

	/**
	 * @return the gid
	 */
	public int getGid() {
		return gid;
	}

	/**
	 * @param gid the gid to set
	 */
	public void setGid(int gid) {
		this.gid = gid;
	}

	/**
	 * @return the gradeSection
	 */
	public String getGradeSection() {
		return gradeSection;
	}

	/**
	 * @param gradeSection the gradeSection to set
	 */
	public void setGradeSection(String gradeSection) {
		this.gradeSection = gradeSection;
	}

	/**
	 * Validate if the instance variables are valid
	 * 
	 * @return boolean - true if instance variables are valid, else false
	 */

	public boolean validate() {

		if (gid <= 0)
			return false;
		if (gradeSection == null)
			return false;

		return true;
	}

}
