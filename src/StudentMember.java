import java.util.Date;
import java.util.HashMap;

public class StudentMember extends Member {
	
	private String studentId;
	private String collegeName;
	private String chosenPackage;
	
	public StudentMember(String email, String name, String address, String gender, double height, double weight, String studentId, String collegeName,String chosenPackage){
		
		super(email, name, address, gender, height, weight);
		this.setCollegeName(collegeName);
		this.setStudentId(studentId);
		this.setChosenPackage(chosenPackage);
		
	}
	
	@Override
	public String toString() {
		return super.toString() + ", StudentId=" + this.getStudentId() + 
	            " , College Name=" + this.getCollegeName() + 
	            ", Chosen Package=" + this.getChosenPackage()
	            + "]" ;        
	}

	public void setStudentId(String studentId){
		int maxLength = (studentId.length() < 6)?studentId.length():6;
		studentId = studentId.substring(0, maxLength);
		this.studentId = studentId;
	}
	
	public void setCollegeName(String collegeName){
		this.collegeName = collegeName;
	}
	
	public void setChosenPackage(String chosenPackage){
		this.chosenPackage = chosenPackage;
	}
	
	public String getChosenPackage(){
		return this.chosenPackage;
	}
	
	public String getStudentId(){
		return this.studentId;
	}
	
	public String getCollegeName(){
		return this.collegeName;
	}

	public void setAssessments(HashMap<Date, Assessment> assessments) {
	 	
	}
}
