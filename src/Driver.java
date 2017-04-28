/**
 * Driver Class
 * 
 * @author Daemon-Macklin
 *
 */

import java.util.Scanner;

public class Driver {
	
	public Scanner input;
	public GymApi gymApi;
	
	public static void main(String[] args){
		Driver gym = new Driver();
		gym.load();
	}
	
	public Driver(){
		input = new Scanner(System.in);
		this.gymApi = new GymApi();
	}
	
	public void load(){
		try {
			gymApi.load();
		} catch (Exception e) {
			System.out.println("Error Loading XML File");
		}
		this.runStart();
	}
	
	public int start(){
		int option; 
		System.out.println("----Welcome to Good Life Fitness----");
		System.out.println("----Would you like to login or register----");
		System.out.println(" 1) Login");
		System.out.println(" 2) Register");
		option = 0;
		while(option < 1 || option > 2){
			option = getIntOption();
			if(option < 1 || option > 2){
				this.optionError();
			}
		}
		return option;
	}
	
	public void runStart(){
		int option = start();
		
		switch(option){
		case 1:
			//login
			this.runPersonChoice();
			break;
		case 2:
			//register
			this.runRegister();
			break;
		default:
			this.optionError();
			break;
			}
		}
	
	public int personChoice(){
		int option;
		System.out.println("Are you a trainer or member?");
		System.out.println(" 1) Trainer");
		System.out.println(" 2) Member");
		option = 0;
		while(option < 1 || option > 2){
			option = getIntOption();
			if(option < 1 || option > 2){
				this.optionError();
			}
		}
		return option;
	}
	
	public void runPersonChoice(){
		int option = personChoice();
		
		switch(option){
		case 1:
			// trainer
			loginTrainer();
				break;
		case 2:
			//member
			loginMember();
			 break;
		default:
			this.optionError();
		}
	}
	
	public void loginTrainer(){
		boolean valid = false;
		while(!valid){
		String email = "";
		System.out.println("Please enter your Email");
		getStringOption();
		email = getStringOption();
		Trainer trainer = (Trainer) gymApi.searchTrainersByEmail(email);
		if(trainer == null){
			System.out.println("Access denied");
		}
		else{
			System.out.println("Welcome " + trainer.getName());
			this.runTrainerMenu(trainer);
			valid = true;
		}
	}
	}
	
	public void loginMember(){
		boolean valid = false;
		while(!valid){
		String email = "";
		System.out.println("Please enter your Email");
		getStringOption();
		email = getStringOption();
		Member member = (Member) gymApi.searchMembersByEmail(email);
		if(member == null){
			System.out.println("Access denied");
		}
		else{
			System.out.println("Welcome " + member.getName());
			this.runMemberMenu(member);
			valid = true;
		}
	  }
	}
	
	public int register(){
		int option;
		System.out.println("New Member or Trainer?");
		System.out.println(" 1) Trainer");
		System.out.println(" 2) Member");
		option = 0;
		while(option < 1 || option > 2){
			option = getIntOption();
			if(option < 1 || option > 2){
				this.optionError();
			}
		}
		return option;
	}
	
	public void runRegister(){
		int option = this.register();
		
		switch(option){
		case 1:
			//trainer
			registerTrainer();
				break;
		case 2:
			//member
			registerMember();
			this.loginMember();
			 break;
		default:
			this.optionError();
		}
	}
	
	public void registerTrainer(){
		System.out.println("email");
		getStringOption();
		String email = getStringOption();
		
		System.out.println("Name");
		String name = getStringOption();
		
		System.out.println("Address");
		String address = getStringOption();
		
		System.out.println("Gender");
		int genderOption;
		System.out.println("Gender");
		System.out.println(" 1) Male");
		System.out.println(" 2 Female");
		System.out.println(" 3) Other");
		genderOption = 0;
		String gender = "U";
		while(genderOption < 1 || genderOption > 3){
			genderOption = getIntOption();
			if(genderOption > 1 || genderOption < 3){
				if(genderOption == 1){
					gender = "M";
				}
				else if(genderOption == 2){
					gender = "F";
				}
				else if(genderOption == 3){
					gender = "U";
				}
			}
		}
		
		getStringOption();
		System.out.println("Speciality");
		String specility = getStringOption();
		
		gymApi.addTrainer(new Trainer(email, name, address, gender, specility));
		try {
			gymApi.save();
		} catch (Exception e) {
			System.out.println("Error while saving");
		}
		this.loginTrainer();
	}
	
	public void registerMember(){
		System.out.println("----Register Member----");
		getStringOption();
		
		System.out.println("email");
		String email = getStringOption();
		
		System.out.println("Name");
		String name = getStringOption();
		
		System.out.println("Address");
		String address = getStringOption();
		
		int genderOption;
		System.out.println("Gender");
		System.out.println(" 1) Male");
		System.out.println(" 2 Female");
		System.out.println(" 3) Other");
		genderOption = 0;
		String gender = "U";
		while(genderOption < 1 || genderOption > 3){
			genderOption = getIntOption();
			if(genderOption > 1 || genderOption < 3){
				if(genderOption == 1){
					gender = "M";
				}
				else if(genderOption == 2){
					gender = "F";
				}
				else if(genderOption == 3){
					gender = "U";
				}
			}
		}
				
		
		System.out.println("Height(Between 1-3 meters");
		double height = getDoubleOption();
		
		System.out.println("Starting Weight");
		double weight = getDoubleOption();
		
		int memberOption;
		System.out.println("Student Member or Premium Member?");
		System.out.println(" 1) Student Member");
		System.out.println(" 2) Premium Member");
		memberOption = 0;
		while(memberOption < 1 || memberOption > 2){
			memberOption = getIntOption();
			if(memberOption > 1 || memberOption < 2){
				if(memberOption == 1){
					System.out.println("----Student Member----");
					getStringOption();
					System.out.println("Student ID");
					String studentId = getStringOption();
					
					System.out.println("College Name");
					String collegeName = getStringOption();
					
					gymApi.addMember(new StudentMember(email, name, address, gender, height, weight, studentId, collegeName, collegeName));
				}
				else if(memberOption == 2){
					String chosenPackage = runPackage();
					
					gymApi.addMember(new PremiumMember(email, name, address, gender, height, weight, chosenPackage));
				}
			}
		}
		try {
			gymApi.save();
		} catch (Exception e) {
			System.out.println("Error while saving");
		}
		return;
	}
	
	public int packageMenu(){
		int option;
		System.out.println("----Please select a package----");
		System.out.println(" 1) Package 1 Permium");
		System.out.println(" 2) Package 2 Normal");
		System.out.println(" 3) Package 3 Basic");
		option = 0;
		while(option < 1 || option > 3){
			option = getIntOption();
			if(option < 1 || option > 3){
				this.optionError();
			}
		}
		return option;
	}
	
	public String runPackage(){
		int option = packageMenu();
		String str;
		switch(option){
		case 1:
			return "Package 1";
		case 2:
			return "Package 2";
		case 3:
			return "Package 3";
		case 4:
			System.out.println("Name of College (i.e: WIT)");
			str = getStringOption();
			return str;
		default:
			this.optionError();
			return "";
		}
	}
	
	public int trainerMenu(){
		int option;
		System.out.println("---Trainer Menu---");
		System.out.println(" 1) Add Member");
		System.out.println(" 2) List all Members");
		System.out.println(" 3) List all Members with ideal body weight");
		System.out.println(" 4) List all Members with specific BMI category");
		System.out.println(" 5) Search Member by email");
		System.out.println(" 6) Add an assessment for a member");
		System.out.println(" 7) View assessments");
		System.out.println(" 8) Exit");
		option = 0;
		while(option < 1 || option > 8){
			option = getIntOption();
			if(option < 1 || option > 8){
				this.optionError();
			}
		}
		return option;
	}
	
	public void runTrainerMenu(Trainer trainer){
		int option = trainerMenu();
		
		switch(option){
		case 1:
			// register member
			registerMember();
			runTrainerMenu(trainer);
				break;
		case 2:
			// List members
			System.out.println(gymApi.listMembers());
			getStringOption();
			runTrainerMenu(trainer);
			 break;
		case 3:
			// List members with Ideal weight
			System.out.println(gymApi.listMembersWithIdealWeight());
			getStringOption();
			runTrainerMenu(trainer);
			break;
		case 4:
			//List members with bmi category
			String category = runCategoryMenu();
			System.out.println(gymApi.listMembersBySpecificeBMICategory(category));
			getStringOption();
			runTrainerMenu(trainer);
			break;
		case 5:
			//search members by email
			System.out.println("Please enter Email");
			String email = getStringOption();
			gymApi.searchMembersByEmail(email);
			getStringOption();
			runTrainerMenu(trainer);
			break;
		case 6:
			//add assessment
			addAssessment(trainer);
			runTrainerMenu(trainer);
			break;
		case 7:
			//View assesments for member
			System.out.println("Please enter Email");
			 getStringOption();
			String emailentered = getStringOption();
			Member assessMember = gymApi.searchMembersByEmail(emailentered);
			if(assessMember.getAssessments() == null){
				System.out.println("No Assessment Data for this User");
			}
			else{
			assessMember.latestAssessment().toString();
			}
			getStringOption();
			runTrainerMenu(trainer);
			break;
		case 8:
			exit();
			break;
		default:
			this.optionError();
		}
	}
	
	public void addAssessment(Trainer trainer){
		System.out.println("Please provide all relevant data");
		getStringOption();
		
		Member member = null;
		boolean validMember = false;
		while(!validMember){
		System.out.println("Member email");
		member = (Member) gymApi.searchMembersByEmail(getStringOption());
		if(member != null){
			validMember = true;
		  }
		}
		
		System.out.println("Weight(KG)");
		double weight = getDoubleOption();
		
		System.out.println("Chest (M)");
		double chest = getDoubleOption();
		
		System.out.println("Thigh (M)");
		double thigh = getDoubleOption();
		
		System.out.println("Upper Arm (M");
		double upperArm = getDoubleOption();
		
		System.out.println("Waist (M)");
		double waist = getDoubleOption();
		
		System.out.println("Hips (M)");
		double hips = getDoubleOption();
		
		getStringOption();
		System.out.println("Comment");
		String comment = getStringOption();
		
		member.addAssessment(new Assessment(weight, chest, thigh, upperArm, waist, hips, comment, trainer));
	}
	
	public int categoryMenu(){
		int option;
		System.out.println("----Select BMI Category");
		System.out.println(" 1) Very Severely Underweight");
		System.out.println(" 2) Severely Underweight");
		System.out.println(" 3) Underweight");
		System.out.println(" 4) Normal");
		System.out.println(" 5) Overweight");
		System.out.println(" 6) Moderatly Obese");
		System.out.println(" 7) Severely Obese");
		System.out.println(" 8) Very Severely Obese");
		option = 0;
		while(option < 1 || option > 8){
			option = getIntOption();
			if(option < 1 || option > 8){
				this.optionError();
			}
		}
		return option;
	}
	
	public String runCategoryMenu(){
		int option = categoryMenu();
		String str = "";
		switch(option){
		case 1:
			str = "Very Severely Underweight";
			break;
		case 2:
			str = "Severely Underweight";
			break;
		case 3:
			str = "Underweight";
			break;
		case 4:
			str = "Normal";
			break;
		case 5:
			str = "Overweight";
			break;
		case 6:
			str = "Moderatly Obese";
			break;
		case 7:
			str = "Severely Obese";
			break;
		case 8:
			str = "Very Severely Obese";
			break;
		default:
			this.optionError();
		}
		return str;
	}
	
	public int memberMenu(Member member){
		int option;
		System.out.println("----Member Menu----");
		System.out.println("----Welcome " + member.getName() + "----");
		System.out.println(" 1) View Profile");
		System.out.println(" 2) Update Profile");
		System.out.println(" 3) View Progress");
		System.out.println(" 4) Exit");
		option = 0;
		while(option < 1 || option > 4){
			option = getIntOption();
			if(option < 1 || option > 4){
				this.optionError();
			}
		}
		return option;
	}
	
	public void runMemberMenu(Member member){
		
		int option = memberMenu(member);
		switch(option){
		case 1:
			System.out.println(member.toString());
			getStringOption();
			runMemberMenu(member);
			break;
		case 2:
			updateProfile(member);
			getStringOption();
			runMemberMenu(member);
			break;
		case 3:
			//view progress
			if(member.getAssessments() == null){
				System.out.println("No Assessment data");
			}
			else{
			member.latestAssessment();
			}
			getStringOption();
			runMemberMenu(member);
			break;
		case 4:
			exit();
			// exit
			break;
		default:
			this.optionError();
		}
		
	}
	
	public void updateProfile(Member member){
		System.out.println("Update profile");
		getStringOption();
		
		System.out.println("New Name");
		member.setName(getStringOption());
		
		System.out.println("New Email");
		member.setEmail(getStringOption());
		
		System.out.println("New Address");
		member.setAddress(getStringOption());
		
		int genderOption;
		System.out.println("New Gender");
		System.out.println(" 1) Male");
		System.out.println(" 2 Female");
		System.out.println(" 3) Other");
		genderOption = 0;
		String gender = "U";
		while(genderOption < 1 || genderOption > 3){
			genderOption = getIntOption();
			if(genderOption > 1 || genderOption < 3){
				if(genderOption == 1){
					gender = "M";
				}
				else if(genderOption == 2){
					gender = "F";
				}
				else if(genderOption == 3){
					gender = "U";
				}
			}
		}
		
		member.setGender(gender);
		
		System.out.println("New Height");
		member.setHeight(getDoubleOption());
	}
	
	public void exit(){
		try {
			gymApi.save();
		} catch (Exception e) {
			System.out.println("Error while saving");
		}
		runStart();
	}
	
	
	//utility funcions
	private String getStringOption() {
	      System.out.print("> ");
	      String text = input.nextLine();
	      return text;
	  }
	
	private double getDoubleOption(){
		System.out.println("> ");
		double option = input.nextDouble();
		return option;
	}
	
	private int getIntOption(){
		System.out.println("> ");
		int option = input.nextInt();
		return option;
	}
	
	public void optionError(){
		System.out.println("Invalid option selected");
	}
}
