
public class PremiumMember extends Member {
	
	private String packageChoice;
	
	public PremiumMember(String email, String name, String address, String gender){
		
		super(email, name, address, gender);
		this.setChosenPackage(packageChoice);
		
	}
	
	public void setChosenPackage(String packageChoice){
		packageChoice = this.packageChoice;
	}
	
	public String getChosenPackage(){
		return packageChoice;
	}
}
