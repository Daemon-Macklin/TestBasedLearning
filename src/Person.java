/**
 * Person Class super class for both 
 * members and trainers
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
	
	/**
	 * Constructor for person class
	 * @param email Persons email
	 * @param name Persons name
	 * @param address Persons address
	 * @param gender Persons gender
	 */
	public Person(String email, String name, String address, String gender){
		this.setEmail(email);
		this.setName(name);
		this.setAddress(address);
		this.setGender(gender);
	}
	
	/**
	 * toString for all the persons data
	 */
	public String toString(){
	return ("StudentMember [" +
			"Email: " + this.getEmail() + 
			", Name:" + this.getName() + 
			" (" + this.getGender() + ")" + 
			", Address:" + this.getAddress() + "."); 
	}
	
	/**
	 * Setter for persons name with validation for length of name
	 * @param name
	 */
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
	
	/**
	 * Setter for email
	 * @param email
	 */
	public void setEmail(String email){
		this.email = email;
	}
	
	/**
	 * Setter for address
	 * @param address
	 */
	public void setAddress(String address){
		this.address = address;
	}
	
	/**
	 * Setter for gender with validation
	 * @param gender
	 */
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
	
	/**
	 * Getter for name
	 * @return Persons name
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 * Getter for email
	 * @return Persons email
	 */
	public String getEmail(){
		return this.email;
	}
	
	/**
	 * Getter for address
	 * @return Persons address
	 */
	public String getAddress(){
		return this.address;
	}
	
	/**
	 * Getter for gender
	 * @return Persons gender 
	 */
	public String getGender(){
		return this.gender;
	}
	
}

