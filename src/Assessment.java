/**
 * Member Class
 * 
 * @author Daemon-Macklin 20075689
 *
 */

public class Assessment {
	// weight, chest, thigh, upperArm, waist, hips,
	//comment and a Trainer
	
	private double weight;

	private double chest;
	private double thigh;
	private double upperArm;
	private double waist;
	private double hips;
	private String comment;
	private Trainer trainer;
	
	public Assessment(double weight, double chest, double thigh, double upperArm, double waist, double hips, String comment, Trainer trainer){
		this.setWeight(weight);
		this.setChest(chest);
		this.setThigh(thigh);
		this.setUpperArm(upperArm);
		this.setWaist(waist);
		this.setHips(hips, waist);
		this.setComment(comment);
		this.setTrainer(trainer);
	}
	
	@Override
	public String toString() {
		return "Assessment [weight=" + this.getWeight() + ", chest=" + this.getChest() + ", thigh=" + this.getThigh() + ", upperArm=" + this.getUpperArm()
				+ ", waist=" + this.getWaist() + ", hips=" + this.getHips() + ", comment=" + this.getComment() + ", trainer=" + this.getTrainer().getName() + "]";
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		if(weight > 30 && weight < 250){
		this.weight = weight;
		}
	}
	
	public double getChest() {
		return chest;
	}
	
	public void setChest(double chest) {
		this.chest = chest;
	}
	
	public double getThigh() {
		return thigh;
	}
	
	public void setThigh(double thigh) {
		this.thigh = thigh;
	}
	
	public double getUpperArm() {
		return upperArm;
	}
	
	public void setUpperArm(double upperArm) {
		this.upperArm = upperArm;
	}
	
	public double getHips() {
		return hips;
	}
	
	public void setHips(double hips, double waist) {
		if(hips >= waist ){
		this.hips = hips;
		}
		else{
			this.hips = 1.2; 
		}
	}
	
	public double getWaist() {
		return waist;
	}
	
	public void setWaist(double waist) {
		this.waist = waist;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public Trainer getTrainer() {
		return trainer;
	}
	
	public void setTrainer(Trainer trainer){
		this.trainer = trainer;
	}
}


