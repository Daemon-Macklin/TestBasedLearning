/**
 * Trainer Class
 * This class contains data for the
 * trainers. sub-class of person
 * @author Daemon-Macklin 20075689
 *
 */

public class Trainer extends Person{
	
	private String speciality;

	/**
	 * Constructor for the trainers class, takes in data 
	 * from the driver class
	 * @param email Trainers email
	 * @param name Trainers Name
	 * @param address Trainers Address
	 * @param gender Trainers gender
	 * @param speciality Trainers speciality
	 */
	public Trainer(String email, String name, String address, String gender, String speciality){
		//giving info to super class (person)
		super(email, name, address, gender);
		this.setSpeciality(speciality); 
		
	}
	
	/**
	 * Setter for a trainers speciality
	 * @param speciality
	 */
	public void setSpeciality(String speciality){
		this.speciality = speciality;
	}
	
	/**
	 * Getter for a trainers speciality 
	 * @return speciality
	 */
	public String getSpeciality(){
		return speciality; 
	}
	
	/**
	 * toString for returning all the trainers data
	 */
	public String toString(){
	return "Trainer [" + super.toString() +  ", Speciality:" + this.getSpeciality();
	}
}
