
public class Trainer extends Person{
	
	private String speciality;

	public Trainer(String email, String name, String address, String gender, String specility){
		
		super(email, name, address, gender);
		this.setSpeciality(speciality); 
		
	}
	public void setSpeciality(String speciality){
		this.speciality = speciality;
	}
	
	public String getSpeciality(){
		return speciality; 
	}
	
}
