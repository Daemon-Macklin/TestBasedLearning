/**
 * Assessment class, holds data for a members 
 * assessments. 
 *
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
	
	/**
	 * Constructor for Assessment class, takes data 
	 * from Driver class
	 * @param weight Weight in kg
	 * @param chest	chest length in M
	 * @param thigh thigh length in M
	 * @param upperArm upperArm length in M
	 * @param waist waist length in M
	 * @param hips hips length in M
	 * @param comment trainers comment
	 * @param trainer
	 */
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
	
	/**
	 * toString returning all assessment data 
	 */
	@Override
	public String toString() {
		return "Assessment [weight=" + this.getWeight() + ", chest=" + this.getChest() + ", thigh=" + this.getThigh() + ", upperArm=" + this.getUpperArm()
				+ ", waist=" + this.getWaist() + ", hips=" + this.getHips() + ", comment=" + this.getComment() + ", trainer=" + this.getTrainer().getName() + "]";
	}
	
	/**
	 * Getter for weight
	 * @return weight in kg
	 */
	public double getWeight() {
		return weight;
	}
	
	/**
	 * Setter for weight
	 * @param weight in kg
	 */
	public void setWeight(double weight) {
		if(weight > 35 && weight < 250){
		this.weight = weight;
		}
	}
	
	/**
	 * Getter for chest
	 * @return chest in M
	 */
	public double getChest() {
		return chest;
	}
	
	/**
	 * Setter for chest
	 * @param chest in M
	 */
	public void setChest(double chest) {
		this.chest = chest;
	}
	
	/**
	 * Getter for thigh
	 * @return thigh in M
	 */
	public double getThigh() {
		return thigh;
	}
	
	/**
	 * Setter for thigh
	 * @param thigh in M
	 */
	public void setThigh(double thigh) {
		this.thigh = thigh;
	}
	
	/**
	 * Getter for upperArm
	 * @return UpperArm in M
	 */
	public double getUpperArm() {
		return upperArm;
	}
	
	/**
	 * Setter for UpperArm
	 * @param upperArm in M
	 */
	public void setUpperArm(double upperArm) {
		this.upperArm = upperArm;
	}
	
	/**
	 *  Getter for hips
	 * @return hips in M
	 */
	public double getHips() {
		return hips;
	}
	
	/**
	 * Setter for hips
	 * @param hips in M
	 * @param waist in M
	 */
	public void setHips(double hips, double waist) {
		if(hips >= waist ){
		this.hips = hips;
		}
		else{
			this.hips = waist; 
		}
	}
	
	/**
	 * Getter for waist
	 * @return Waist in M
	 */
	public double getWaist() {
		return waist;
	}
	
	/**
	 * Setter for waist
	 * @param waist in M
	 */
	public void setWaist(double waist) {
		this.waist = waist;
	}
	
	/**
	 * Getter for trainer comment
	 * @return String comment
	 */
	public String getComment() {
		return comment;
	}
	
	/**
	 * Setter for trainer comment
	 * @param String comment
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	/**
	 * Getter for trainer 
	 * @return trainer
	 */
	public Trainer getTrainer() {
		return trainer;
	}
	
	/**
	 * Setter for trainer
	 * @param trainer
	 */
	public void setTrainer(Trainer trainer){
		this.trainer = trainer;
	}
}


