/**
 * Person Class
 * 
 * @author Daemon-Macklin 20075689
 *
 */

public abstract class Person {
//email
//name 
//address
//gender
	private String name;
	private String email;
	private String address;
	private String gender; 
	
	public Person(String email, String name, String address, String gender){
		this.setEmail(email);
		this.setName(name);
		this.setAddress(address);
		this.setGender(gender);
	}
	
	public String toString(){
	return ("StudentMember [" +
			"Email: " + this.getEmail() + 
			", Name:" + this.getName() + 
			" (" + this.getGender() + ")" + 
			", Address:" + this.getAddress() + "."); 
	}
	
	public void setName(String name){
		if(this.name == null){
		int maxLength = (name.length() < 30)?name.length():30;
		name = name.substring(0, maxLength);
		this.name = name;
		}
		else{
			if(name.length() < 30){
				this.name = name;
			}
		}
		
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public void setAddress(String address){
		this.address = address;
	}
	
	public void setGender(String gender){
		if(this.gender == null){
		String finalgender = "";
		if((gender == "m") || (gender == "M") || (gender == "male") || (gender == "Male")){
			finalgender = "M";
		}
		else if((gender == "f") || (gender == "F") || (gender == "female") || (gender == "Female")){
			finalgender = "F";
		}
		else{
			finalgender = "Unspecified";
		}
		this.gender = finalgender;
		}
		else{
			String finalgender = this.gender;
			if((gender == "m") || (gender == "M") || (gender == "male") || (gender == "Male")){
				finalgender = "M";
			}
			else if((gender == "f") || (gender == "F") || (gender == "female") || (gender == "Female")){
				finalgender = "F";
			}
			this.gender = finalgender;
		}
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getEmail(){
		return this.email;
	}
	
	public String getAddress(){
		return this.address;
	}
	
	public String getGender(){
		return this.gender;
	}
	
}

