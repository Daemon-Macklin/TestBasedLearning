/**
 * Premium Member Class
 * 
 * @author Daemon-Macklin 20075689
 *
 */

public class PremiumMember extends Member {
	
	private String packageChosen;


	public PremiumMember(String email, String name, String address, String gender, double height, double weight, String packageChosen){
		
		super(email, name, address, gender, height, weight);
		this.setPackageChosen(packageChosen);
		
	}
	
	
	public String getPackageChosen() {
		return packageChosen;
	}


	public void setPackageChosen(String packageChosen) {
		this.packageChosen = packageChosen;
	}
	
}
