
public class Trainer extends Person{
	
	private String speciality;

	public Trainer(String email, String name, String address, String gender, String speciality){
		
		super(email, name, address, gender);
		this.setSpeciality(speciality); 
		
	}
	public void setSpeciality(String speciality){
		this.speciality = speciality;
	}
	
	public String getSpeciality(){
		return speciality; 
	}
	
	public String toString(){
	return super.toString() +  ", Speciality:" + this.getSpeciality();
	}
}
