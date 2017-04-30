/**
 * Premium Member Class
 * Sub class of member
 * 
 * @author Daemon-Macklin 20075689
 *
 */

public class PremiumMember extends Member {
	
	private String packageChosen;

	/**
	 * Constructor for premium member
	 * @param email Member email
	 * @param name Member name
	 * @param address Member address
	 * @param gender Member gender
	 * @param height Member height
	 * @param weight Member weight
	 * @param packageChosen Members chosen package
	 */
	public PremiumMember(String email, String name, String address, String gender, double height, double weight, String packageChosen){
		
		super(email, name, address, gender, height, weight);
		this.setPackageChosen(packageChosen);
		
	}
	
	/**
	 * Getter for chosenPackage 
	 * @return chosen package
	 */
	public String getPackageChosen() {
		return packageChosen;
	}

	/**
	 * Setter for chosen package
	 * @param packageChosen
	 */
	public void setPackageChosen(String packageChosen) {
		this.packageChosen = packageChosen;
	}
	
}
