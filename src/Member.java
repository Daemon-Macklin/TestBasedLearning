import java.util.HashMap;
import java.util.Date;
import java.util.SortedSet;
import java.util.TreeSet;

public abstract class Member extends Person {
	
	private double height;
	private double startingWeight;
	private String packageChosen;
	private HashMap <String, String> Assessment; 
	// hash map to record members progress(from trainers)
 
	public Member(String email, String name, String address, String gender){
		
		super(email, name, address, gender);
		this.setHeight(height);
		this.setStartingWeight(startingWeight);
	}
	
	public double calculateBMI(double weight){
		double height = this.getHeight();
		
		double bmiValue = weight/(height*height);
			return bmiValue;
	}
		
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
	
	public Assessment latestAssessment(){
		//Returns lastest assessment based on last entry 
		return getAssessments().get(sortedAssessmentDates().last());
	}
		
	public SortedSet<Date> sortedAssessmentDates(){
		//Returns the assessment dates sorted in date order
		return new TreeSet<Date>(getAssessments()keySet());
	}
	
	public void setHeight(double height){
		if(height > 1 && height < 3){
		height = this.height;
		}
	}
	
	public void setStartingWeight(double startingWeight){
		if(startingWeight > 30 && startingWeight < 250){
		startingWeight = this.startingWeight;
		}
	}
	
	public double getHeight(){
		return height;
	}
	
	
	public double getStartingWeight(){
		return startingWeight;
	}
	
	public HashMap<String, String> getAssessments(){
		return Assessment;
	}
}
