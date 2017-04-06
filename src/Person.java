
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
		
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public void setAddress(String address){
		this.address = address;
	}
	
	public void setGender(String gender){
		this.gender = gender;
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

