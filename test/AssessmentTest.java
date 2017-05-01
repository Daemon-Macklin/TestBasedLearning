import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for Assessment class
 * @author Daemon-Macklin 20075689
 *
 */

public class AssessmentTest {
	private Assessment assessment1;
	private Assessment assessmentInvalid;
	private Trainer rocky;
	/**
	   * Set up test fixtures
	   * 
	   * Called before every test method
	   */
	  @Before
	  public void setUp() {
	     
	    assessment1 = new Assessment(76, 1, .5, .3, 1, 1.2, "Good work", rocky);
	    assessmentInvalid = new Assessment(30, 1, .5, .3, 1, .8, "Messer", rocky);
	  }
	  
	  /**
	   * Teardown test fixtures
	   * 
	   * Called after each test method
	   */
	  @After
	  public void tearDown() {
	    
	  }
	  
	  /**
	   * Test the contsructor  
	   */
	  @Test
	  public void testConstructor() {
	    assertNotNull(assessment1); //will test these in testGetters()
	    assertEquals(35, assessmentInvalid.getWeight(), .01);
	    assertEquals(1, assessmentInvalid.getChest(), .01);
	    assertEquals(.5, assessmentInvalid.getThigh(), .01);
	    assertEquals(.3, assessmentInvalid.getUpperArm(), .01);
	    assertEquals(1, assessmentInvalid.getWaist(), .01);
	    assertEquals(1, assessmentInvalid.getHips(), .01);
	    assertEquals(rocky, assessmentInvalid.getTrainer());
	    assertEquals("Messer", assessmentInvalid.getComment());
	  }
	  
	  /**
	   * Test all getters using valid data
	   */
	  @Test
	  public void testGetters() {
	    assertEquals(76, assessment1.getWeight(), .01);
	    assertEquals(1, assessment1.getChest(), .01);
	    assertEquals(.5, assessment1.getThigh(), .01);
	    assertEquals(.3, assessment1.getUpperArm(), .01);
	    assertEquals(1, assessment1.getWaist(), .01);
	    assertEquals(1.2, assessment1.getHips(), .01);
	    assertEquals(rocky, assessment1.getTrainer());
	    assertEquals("Good work", assessment1.getComment());
	  }
	  
	  /**
	   * Test all setters for StudentMember
	   */
	  @Test
	  public void testSetters() {
	    assessment1.setChest(1);
	    assertEquals(1, assessment1.getChest(), .01);
	    assessment1.setChest(.3);
	    assertEquals(.3 ,assessment1.getChest(), .01); 
	    
	    assessment1.setHips(1 , .8);
	    assertEquals(1, assessment1.getHips(), .01);
	    assessment1.setHips(1, 1.2);
	    assertEquals(1.2 ,assessment1.getHips(), .01); 
	    
	    assessment1.setWaist(1);
	    assertEquals(1, assessment1.getWaist(), .01);
	    
	    assessment1.setThigh(1);
	    assertEquals(1, assessment1.getThigh(), .01);
	    
	    assessment1.setUpperArm(1);
	    assertEquals(1, assessment1.getUpperArm(), .01);
	    
	    assessment1.setComment("There is no validtion on commetns");
	    assertEquals("There is no validtion on commetns", assessment1.getComment());

	    
	    assessment1.setTrainer(rocky);
	    assertEquals(rocky, assessment1.getTrainer());
	    
	    
	    assertEquals(76.0, assessment1.getWeight(), 0.01);
	    assessment1.setWeight(100);  //valid change
	    assertEquals(100, assessment1.getWeight(), 0.01);
	    assessment1.setWeight(34);  //invalid change - too low
	    assertEquals(100, assessment1.getWeight(), 0.01); 
	    assessment1.setWeight(251);  //invalid change - too high
	    assertEquals(100, assessment1.getWeight(), 0.01);
	  }
	  
	  /**
	   * Test the ToString Method for StudentMember
	   *  
	   */
	  @Test
	  public void testToString() {
	    assertEquals( "Assessment [weight=" + 76.0 + ", chest=" + 1.0 + 
				", thigh=" + .5 + ", upperArm=" + .3
				+ ", waist=" + 1.0 + ", hips=" + 1.2 + ", comment="
				+ "Good work" + ", trainer=" + rocky + "]"
		            ,
		            assessment1.toString());
	   
	  }


	
}
