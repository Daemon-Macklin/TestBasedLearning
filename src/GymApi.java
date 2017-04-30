/**
 * GymApi Class a class that has multiple
 * methods with different functions.
 * As well as storing Arraylists for members and trainer 
 * and the hashmap for the packages.
 * 
 * @author Daemon-Macklin 20075689
 *
 */

import java.util.ArrayList;
import java.io.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.util.HashMap;

public class GymApi {
	 
	private ArrayList<Member> members;
	private ArrayList<Trainer> trainers;
	public static HashMap<String, String> packageMap;
	
	/**
	 * Constructor for gymapi class 
	 */
	public GymApi(){
	this.trainers = new ArrayList<Trainer>();
	this.members = new ArrayList<Member>();
	GymApi.packageMap = new HashMap<String, String>();
	this.fillPackageMap();
	}
	
	/**
	 * Method to add a new member to the member arraylist
	 * @param member
	 */
	public void addMember(Member member){
		 members.add(member);
		 System.out.println("Added Member " + member.toString());
	}
	
	/**
	 * Method to add a new trainer to the trainer arraylist
	 * @param trainer
	 */
	public void addTrainer(Trainer trainer){
		trainers.add(trainer);
		System.out.println("Added Trainer " + trainer.toString());
	}
	
	/**
	 * Gets the size of the members array
	 * @return number for members in array 
	 */
	public int numberOfMembers(){
		return members.size();
	}
	
	/**
	 *Gets the size of the trainers array 
	 * @return number of trainers in array
	 */
	public int numberOfTrainers(){
		return trainers.size();
	}
	
	/**
	 * Getter for Member arraylist
	 * @return Arraylist of Members 
	 */
	public ArrayList<Member> getMembers(){
		return this.members; 
	}
	
	/**
	 * Getter for Trainer arraylist
	 * @return Arraylist of trainers
	 */
	public ArrayList<Trainer> getTrainers(){
		return this.trainers;
	}
	
	/**
	 * Method to check if an index is valid for the member arraylist
	 * @param index Index number in question
	 * @return boolean value for index
	 */
	public boolean isValidMemberIndex(int index){
		boolean valid = false;
			if(index <= members.size()){
				valid = true;
		}
			return valid;
	}
	
	/**
	 * Method to check if an index is valid for the trainer arraylist
	 * @param index Index number in question
	 * @return boolean value for index
	 */
	public boolean isValidTrainerIndex(int index){
		boolean valid = false;
		if(index <= trainers.size()){
			valid = true;
	}
		return valid;
	}
	
	/**
	 * Searches through members Arraylist to find if there's a 
	 * matching email to the email entered and if so returns 
	 * the Member 
	 * @param emailEntered email in question
	 * @return if the search is successful it will return a member other 
	 * wise it will return null 
	 */
	public Member searchMembersByEmail(String emailEntered){
		ArrayList<Member> members = this.getMembers();
		Member memberWanted = null;
		for(int i = 0; i < members.size(); i++){
			if(members.get(i).getEmail().equals(emailEntered)){
			 memberWanted = members.get(i);
			} 
		  }
		return memberWanted;
	}
	
	/**
	 * Searches through trainers Arraylist to find if there's a 
	 * matching email to the email entered and if so returns 
	 * the Member 
	 * @param emailEntered email in question
	 * @return if the search is successful it will return a trainer other 
	 * wise it will return null 
	 */
	public Person searchTrainersByEmail(String emailEntered){
		ArrayList<Trainer> trainers = this.getTrainers();
		Trainer trainerWanted = null;
		for(int i = 0; i < trainers.size(); i++){
			if(trainers.get(i).getEmail().equals(emailEntered)){
			 trainerWanted = trainers.get(i);
			} 
		}
		return trainerWanted;
	}
	
	/**
	 * Lists out all the members in the 
	 * member arraylist
	 * @return string of members in the arraylist
	 */
	public String listMembers(){
		members = this.getMembers();
		String str = "";
		for(int i = 0; i < members.size(); i++){
			str = str + members.get(i);
		}
		if(str == ""){
			 return "No Members";	
			}
			else{
			return str;
			}
	}
	
	/**
	 * Lists out all the members that have an Ideal Weight based on the devine method
	 * 
	 * Male ideal weight: 50 + 2.3kg for each inch over 5 feet.
	 * 
	 * Female ideal weight: 45 + 2.3kg for each inch over 5 feet.
	 * 
	 * if gender is unspecified returns the female result.
	 * 
	 * @return a list of members with ideal weight. 
	 */
//	public String listMembersWithIdealWeight(){
//		ArrayList<Member> members = this.getMembers();
//		String str = "";
//		if(members == null){
//			return "No Members";
//		}
//		else{
//		for(int i = 0; i < members.size(); i++){
//			Member person = members.get(i);
//			if(person.getAssessments() ==null) {
//				//returning string if theres no details for this member
//				System.out.println("Not enough Data to complete. Add assesment for " + person.getName());
//			}
//			else{
//			double memberWeight = person.latestAssessment().getWeight();
//			if(person.getGender() == "M"){
//				//Male calculation
//				double extraWeight = 0;
//				double heightIN = person.getHeight()/.0254;
//				double extraHeight = heightIN - 60;
//				if(extraHeight > 0){
//					extraWeight = extraHeight*2.3;
//				}
//				double idealWeight = extraWeight + 50;
//				if(idealWeight == memberWeight){
//					str = str + person;
//				}
//			}
//			else if(person.getGender() == "F" || person.getGender() == "U"){
//				//Female/unspecified calculation 
//				double extraWeight = 0;
//				double heightIN = person.getHeight()/.0254;
//				double extraHeight = heightIN - 60;
//				if(extraHeight > 0){
//					extraWeight = extraHeight*2.3;
//				}
//				double idealWeight = extraWeight + 45.5;
//				if(idealWeight == memberWeight){
//					str = str + person;
//				}
//			}
//		}
//		}
//	}
//		if(str == ""){
//		 return "No Members with ideal weight";	
//		}
//		else{
//		return str;
//		}
//	}
	
	/**
	 * Makes a list of all members in a specific BMI category
	 * @param category 
	 * @return a list of members in the catergory given
	 */
	public String listMembersBySpecificeBMICategory(String category){
		ArrayList<Member> members = this.getMembers();
		String str = "";
		for(int i = 0; i < members.size(); i++){
			Member person = members.get(i);
			double memberWeight = 0;
			if(person.getAssessments() == null){
				str = str + "Not enough Data to complete. Add assesment for :" + person.getName();
			}
			else{
				if(person.latestAssessment() == null){
					memberWeight = person.getStartingWeight();
				}
				else{
					memberWeight = person.latestAssessment().getWeight();
				}
			double bmiValue = person.calculateBMI(memberWeight);
			String BMICat = person.determineBMICategory(bmiValue);
			System.out.println("Category = " + category + "BMICAT = " + BMICat);
			if(BMICat.equals(category)){
				System.out.println("HEYIHHHAA");
				str = str + " " + person;
			}
		  }
		}
		if(str == ""){
			 return "No Members with in the " + category + " BMI category";	
			}
			else{
			return str;
			}
	}
		
	/**
	 * converts all members data to imperial
	 * @return string of members data in metric and imperial
	 */
	public String listMemberDetailsImperialAndMetric(){
		ArrayList<Member> members = this.getMembers();
		String str = "";
			for(int i = 0; i < members.size(); i++){
				Member person = members.get(i);
				double height = person.getHeight();
				Assessment measuerments = person.latestAssessment();
				//converting from metric to imperial
				double heightIN = height/.0254;
				double weightPD = measuerments.getWeight()/.45359237;
				double chestIN = measuerments.getChest()/.0254;
				double thighIN = measuerments.getThigh()/.0254;
				double upperArmIN= measuerments.getUpperArm()/.0254;
				double waistIN= measuerments.getWaist()/.0254;
				double hipsIN= measuerments.getHips()/.0254;
				str = str + " " + members.get(i) + " " + heightIN + " " + weightPD + " "
						+ chestIN + " " + thighIN + " " + upperArmIN + " " 
						+ waistIN + " " + hipsIN;
				}
			if(str == ""){
				 return "No Members";	
				}
				else{
				return str;
				}
	}
	
	/**
	 * Loads trainer and member data
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public void load() throws Exception{
		XStream xstream = new XStream(new DomDriver());
		ObjectInputStream is = xstream.createObjectInputStream(new FileReader("personData.xml"));
		members = (ArrayList<Member>) is.readObject();
		trainers = (ArrayList<Trainer>) is.readObject();
		is.close();
	}
	
	/**
	 * Saves trainer and member data
	 * @throws Exception
	 */
	public void save() throws Exception{
		XStream xstream = new XStream(new DomDriver());
		ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("personData.xml"));
		out.writeObject(members);
		out.writeObject(trainers);
		out.close();
	}
	
	/**
	 * 
	 */
	public void fillPackageMap(){
		packageMap.put("Package 1","Allowed access anytime to gym.\nFree access to all classes."
				+ "\nAccess to all changing areas including deluxe changing rooms." );
		packageMap.put("Package 2","Allowed access anytime to gym.\n€3 fee for all classes."
				+ "	\nAccess to all changing areas including deluxe changing rooms." );
		packageMap.put("Package 3", "Allowed access to gym at off-peak times.\n€5 fee for all"
				+ "classes. \nNo access to deluxe changing rooms.");
		packageMap.put("Wit", "Allowed access to gym during term time.\n€4 fee for all classes."
				+ "\nNo access to deluxe changing rooms.");
	}
}



		
	
	
	
	
	
	
	
