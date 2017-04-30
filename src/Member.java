/**
 * Member Class sub class of person
 * Super class of Premium and Student
 * 
 * @author Daemon-Macklin 20075689
 *
 */

import java.util.HashMap;
import java.util.Date;
import java.util.SortedSet;
import java.util.TreeSet;

public abstract class Member extends Person {
	
	private double height;
	private double startingWeight;
	private HashMap <Date, Assessment> assessments; 
	// hash map to record members progress(from trainers)
	
	/**
	 * Constructor for Member
	 * @param email Member email
	 * @param name Member name
	 * @param address Member address
	 * @param gender Member gender
	 * @param height Member height
	 * @param startingWeight Member starting Weight
	 */
	public Member(String email, String name, String address, String gender, double height, double startingWeight){	
		super(email, name, address, gender);
		this.setHeight(height);
		this.setStartingWeight(startingWeight);
		assessments = new HashMap <Date, Assessment>();
		fillAssessment();
	}
	
	/**
	 * toString for member data
	 */
	public String toString(){
		return super.toString() +
				"\n\tHeight: "+ this.getHeight() + " metres" +
	            ",  Starting Weight: " + this.getStartingWeight() + " kgs";
	}
	
	/**
	 * Calculates BMI for member
	 * @param weight in kg 
	 * @return BMI value
	 */
	public double calculateBMI(double weight){
		double height = this.getHeight();
		
		double bmiValue = weight/(height*height);
			return bmiValue;
	}
		
	/**
	 * Uses BMI value to find which BMI category the member is in
	 * @param bmiValue
	 * @return String of BMI category member is in
	 */
	public String determineBMICategory(double bmiValue){
		String str = "";
		  if(bmiValue < 15){
			  str = "Very Severely Underweight";
		  }
		  else if(bmiValue < 16){
			  str ="Severely UnderWeight";
		  }
		  else if(bmiValue < 18.5){
			  str ="UnderWeight";
		  }
		  else if(bmiValue < 25){
			  str = "Normal";
		  }
		  else if(bmiValue < 30){
			  str = "OverWeight";
		  }
		  else if(bmiValue < 35){
			  str = "Moerately Obese";
		  }
		  else if(bmiValue < 40){
			  str = "Severely Obese";
		  }
		  else {
			  str = "Very Severely Obese";
		  }
			return str;
	}
	/**
	 * This method returns a boolean to indicate if the member has an ideal body 
	 * weight based on the Devine formula 
	 * 
	 * <pre>
	 *	For Males the ideal body weight is: 50 + 2.3kg for every inch over 5 feet
	 *	
	 *	For Females the ideal body weight is: 45.5 + 2.3kg for every inch over 5 feet
	 *
	 *	Note if no gender is specified, return the result of the female calulation.
	 *
	 * @param weight The member's weight in kgs
	 * @return	true if the result o the devine formula is within 2 kgs (inclusive)
	 * of the starting weight;
	 * false if it is outside this range.
	 */
	public boolean isIdealBodyWeight(double weight){
		{
			 double fiveFeet = 60.0;
			 double idealBodyWeight;
			 double inches = conversion(this.getHeight());

			 if (inches <= fiveFeet){
			 if (this.getGender().equals("M")){
			 idealBodyWeight = 50;
			 }
			 else{ 
			 idealBodyWeight = 45.5;
			 }
			 }
			 else{
			 if (this.getGender().equals("M")){
			 idealBodyWeight = 50 + ((inches - fiveFeet) * 2.3);
			 }
			 else{
			 idealBodyWeight = 45.5 + ((inches - fiveFeet) * 2.3);
			 }
			 }

			 return ( (idealBodyWeight <= (weight + 2.0))
			 && (idealBodyWeight >= (weight - 2.0))
			 );
			 }
	}
	
	public double conversion(double height){
		double heightIN = height/.0254;
		return heightIN;
	}
	
	/**
	 * Adds assessment from driver menu
	 * @param newAssessment
	 */
	public void addAssessment(Assessment newAssessment) {
		Date date = new Date();
		assessments.put(date, newAssessment);
	}
	
	/**
	 * Method called when member is created to fill in assessment so it's not null.
	 */
	public void fillAssessment(){
		assessments.put(new Date(), null);
	}
	
	/**
	 * Returns latest assessment
	 * @return
	 */
	public Assessment latestAssessment(){
		//Returns latest assessment based on last entry 
		return getAssessments().get(sortedAssessmentDates().last());
	}
		
	/**
	 * Returns assessments sorted by date
	 * @return
	 */
	public SortedSet<Date> sortedAssessmentDates(){
		//Returns the assessment dates sorted in date order
		return new TreeSet<Date>(getAssessments().keySet());
	}
	
	/**
	 * Setter for height with validation
	 * for max height and min height.
	 * @param height
	 */
	public void setHeight(double height){
		if(this.height ==0){
		if(height > 1 && height < 3){
		this.height = height;
		}
		else{
			this.height = 1;
		}
		}
		else{
			if(height > 1 && height < 3){
				this.height = height;
			}
		}
	}
	
	/**
	 * Setter for starting weight with validation
	 * for max weight and min weight
	 * @param startingWeight
	 */
	public void setStartingWeight(double startingWeight){
		if(this.startingWeight == 0){
		if(startingWeight > 35 && startingWeight < 250){
		this.startingWeight = startingWeight;
		}
		else{
			this.startingWeight = 35;
		}
		}
		else{
			if(startingWeight > 35 && startingWeight < 250){
				this.startingWeight = startingWeight;
				}
		}
		}
	
	/**
	 * Getter for height
	 * @return
	 */
	public double getHeight(){
		return height;
	}
	
	/**
	 * getter for members starting weight
	 * @return
	 */
	public double getStartingWeight(){
		return startingWeight;
	}
	
	/**
	 * 
	 * Getter for members assessments
	 * @return
	 */
	public HashMap<Date, Assessment> getAssessments(){
		return assessments;
	}
}
