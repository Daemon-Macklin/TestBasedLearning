
public class StudentMember extends Member {
	
	private String studentId;
	private String collegeName;
	
	public StudentMember(String email, String name, String address, String gender){
		
		super(email, name, address, gender);
		this.setChosenPackage(collegeName);
		this.setCollegeName(collegeName);
		this.setStudentId(studentId);
		
	}
	
	public void setChosenPackage(String collegeName){
		// Check to see if college is in package hash map
		collegeName = this.collegeName;
	}
	
	public String getChoisePackage(){
		return this.collegeName;
	}
	
	public void setStudentId(String studentId){
		studentId = this.studentId;
	}
	
	public void setCollegeName(String collegeName){
		collegeName = this.collegeName;
	}
	
	public String getStudentId(){
		return this.studentId;
	}
	
	public String getCollegeName(){
		return this.collegeName;
	}
}
