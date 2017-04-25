import java.util.ArrayList;
import java.io.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.util.HashMap;

public class GymApi {
	 
	private ArrayList<Member> members;
	private ArrayList<Trainer> trainers;
	public static HashMap<String, String> packageMap;
	
	public GymApi(){
	this.trainers = new ArrayList<Trainer>();
	this.members = new ArrayList<Member>();
	GymApi.packageMap = new HashMap<String, String>();
	this.fillPackageMap();
	}
	
	public void addMember(Member member){
		 members.add(member);
		 System.out.println("Added Member " + member.toString());
	}
	
	public void addTrainer(Trainer trainer){
		trainers.add(trainer);
		System.out.println("Added Trainer " + trainer.toString());
	}
	
	public int numberOfMembers(){
		return members.size();
	}
	
	public int numberOfTrainers(){
		return trainers.size();
	}
	
	public ArrayList<Member> getMembers(){
		return this.members; 
	}
	
	public ArrayList<Trainer> getTrainers(){
		return this.trainers;
	}
	
	public boolean isValidMemberIndex(int index){
		boolean valid = false;
			if(index < members.size()){
				valid = true;
		}
			return valid;
	}
	
	public boolean isValidTrainerIndex(int index){
		boolean valid = false;
		if(index < trainers.size()){
			valid = true;
	}
		return valid;
	}
	
	public Member searchMembersByEmail(String emailEntered){
		members = this.getMembers();
		Member memberWanted = null;
		for(int i = 0; i < members.size(); i++){
			if(members.get(i).getEmail() == emailEntered){
			 memberWanted = members.get(i);
			} 
		  }
		return memberWanted;
	}
	
	public Person searchTrainersByEmail(String emailEntered){
		Trainer trainerWanted = null;
		for(int i = 0; i < trainers.size(); i++){
			if(trainers.get(i).getEmail() == emailEntered){
			 trainerWanted = trainers.get(i);
			} 
		}
		return trainerWanted;
	}
	
	public String listMembers(){
		members = this.getMembers();
		String str = "";
		for(int i = 0; i < members.size(); i++){
			str = str + members.get(i);
		}
		return str;
	}
	
	public String listMembersWithIdealWeight(){
		members = this.getMembers();
		String str = "";
		for(int i = 0; i < members.size(); i++){
			Member person = members.get(i);
			double memberWeight = person.latestAssessment().getWeight();
			if(person.getGender() == "m"){
				double extraWeight = 0;
				double heightIN = person.getHeight()/.0254;
				double extraHeight = heightIN - 60;
				if(extraHeight > 0){
					extraWeight = extraHeight*1.9;
				}
				double idealWeight = extraWeight + 52;
				if(idealWeight == memberWeight){
					str = str + person;
				}
			}
			else if(person.getGender() == "f"){
				double extraWeight = 0;
				double heightIN = person.getHeight()/.0254;
				double extraHeight = heightIN - 60;
				if(extraHeight > 0){
					extraWeight = extraHeight*1.7;
				}
				double idealWeight = extraWeight + 49;
				if(idealWeight == memberWeight){
					str = str + person;
				}
			}
			else if(person.getGender() == "Unspecified"){
				str = "Unavaliable";
			}
		}
		return str;
	}
	
	public String listMembersBySpecificeBMICategory(String category){
		members = this.getMembers();
		String str = "";
		for(int i = 0; i < members.size(); i++){
			Member person = members.get(i);
			double memberWeight = person.latestAssessment().getWeight();
			double bmiValue = members.get(i).calculateBMI(memberWeight);
			String BMICat = members.get(i).determineBMICategory(bmiValue);
			if(BMICat == category){
				str = str + " " + members.get(i);
			}
		}
		return str;
	}
	
	public String listMemberDetailsImperialAndMetric(){
		members = this.getMembers();
		String str = "";
			for(int i = 0; i < members.size(); i++){
				Member person = members.get(i);
				double height = person.getHeight();
				Assessment measuerments = person.latestAssessment();
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
			return str;
	}
	
	@SuppressWarnings("unchecked")
	public void load() throws Exception{
		XStream xstream = new XStream(new DomDriver());
		ObjectInputStream is = xstream.createObjectInputStream(new FileReader("personData.xml"));
		members = (ArrayList<Member>) is.readObject();
		trainers = (ArrayList<Trainer>) is.readObject();
		is.close();
	}
	
	public void save() throws Exception{
		XStream xstream = new XStream(new DomDriver());
		ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("personData.xml"));
		out.writeObject(members);
		out.writeObject(trainers);
		out.close();
	}
	
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



		
	
	
	
	
	
	
	
