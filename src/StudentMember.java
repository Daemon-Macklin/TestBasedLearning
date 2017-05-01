import java.util.Date;
import java.util.HashMap;

/**
 * StudentMember Class 
 * Sub class of Member holds data for studentMembers
 * 
 * @author Daemon-Macklin 20075689
 *
 */

public class StudentMember extends Member {
	
	private String studentId;
	private String collegeName;
	private String chosenPackage;
	
	/**
	 * Constructor for student member
	 * @param email Member email
	 * @param name Member name
	 * @param address Member address
	 * @param gender Member gender
	 * @param height Member height
	 * @param weight Member weight
	 * @param studentId Member Student id
	 * @param collegeName Members collegename
	 * @param chosenPackage Members chosenpackage
	 */
	public StudentMember(String email, String name, String address, String gender, double height, double weight, String studentId, String collegeName,String chosenPackage){
		
		super(email, name, address, gender, height, weight);
		this.setCollegeName(collegeName);
		this.setStudentId(studentId);
		this.setChosenPackage(chosenPackage);
		
	}
	
	/**
	 * toString that displays all the students data
	 */
	@Override
	public String toString() {
		return ("StudentMember [" + super.toString() + ", StudentId=" + this.getStudentId() + 
	            " , College Name=" + this.getCollegeName() + 
	            ", Chosen Package=" + this.getChosenPackage()
	            + "]" );        
	}
	
	/**
	 * Setter for student id with validation for length 
	 * @param studentId
	 */
	public void setStudentId(String studentId){
		int maxLength = (studentId.length() < 6)?studentId.length():6;
		studentId = studentId.substring(0, maxLength);
		this.studentId = studentId;
	}
	
	/**
	 * Setter for college name
	 * @param collegeName
	 */
	public void setCollegeName(String collegeName){
		this.collegeName = collegeName;
	}
	
	/**
	 * Setter for chosenPackage
	 * @param chosenPackage
	 */
	public void setChosenPackage(String chosenPackage){
		this.chosenPackage = chosenPackage;
	}
	
	/**
	 * Getter for chosenPackage
	 * @return chosenPackage
	 */
	public String getChosenPackage(){
		return this.chosenPackage;
	}
	
	/**
	 * Getter for student id 
	 * @return students id
	 */
	public String getStudentId(){
		return this.studentId;
	}
	
	/**
	 * Getter for college name
	 * @return college name
	 */
	public String getCollegeName(){
		return this.collegeName;
	}

	/**
	 * Setter for assessments
	 * @param assessments
	 */
	public void setAssessments(HashMap<Date, Assessment> assessments) {
		
	}
}
