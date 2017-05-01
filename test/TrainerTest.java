/**
 * Test for trainer class
 * 
 * @author Daemon-Macklin 20075689	
 */
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TrainerTest {
	private Trainer train1;
	private Trainer trainInvalid;

 /**
 * Set up test fixtures
 * 
 * Called before every test method
 */
@Before
public void setup(){
	
	train1 = new Trainer("Joe@Trainers.ie", "Joe", "Kerry", "M", "Running");
	trainInvalid = new Trainer("Jess@Trainers.ie", "Valid name is 30 chars to here everything else is too long", "Dublin", "b", "Cross-fit");
	
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
  assertNotNull(train1); //will test these in testGetters()
  assertEquals("Valid name is 30 chars to here", trainInvalid.getName());
  assertEquals("Jess@Trainers.ie", trainInvalid.getEmail());
  assertEquals("Unspecified", trainInvalid.getGender());
  assertEquals("Dublin", trainInvalid.getAddress());
  assertEquals("Cross-fit", trainInvalid.getSpeciality());
}

/**
 * Test all getters using valid data
 */
@Test
public void testGetters() {
  assertEquals("Joe", train1.getName());
  assertEquals("Joe@Trainers.ie", train1.getEmail());
  assertEquals("M", train1.getGender());
  assertEquals("Kerry", train1.getAddress());
  assertEquals("Running", train1.getSpeciality());
}

/**
 * Test all setters for StudentMember
 */
@Test
public void testSetters() {
  train1.setName("Jane");
  assertEquals("Jane", train1.getName());
  train1.setName("This name is far too long for the validation rules");
  assertEquals("Jane", train1.getName()); 
  
  assertEquals("Joe@Trainers.ie", train1.getEmail());
  train1.setEmail("someoneElse@wit.ie");
  assertEquals("someoneElse@wit.ie", train1.getEmail());
  
  assertEquals("M", train1.getGender());
  train1.setGender("anythinginvalid");
  assertEquals("M", train1.getGender());
  
  assertEquals("Kerry", train1.getAddress());
  train1.setAddress("no validation rules on address");
  assertEquals("no validation rules on address", train1.getAddress());
  
  assertEquals("Running", train1.getSpeciality());
  train1.setSpeciality("no validation rules on speciality");
  assertEquals("no validation rules on speciality", train1.getSpeciality());
}

/**
 * Test the ToString Method for StudentMember
 *  
 */
@Test
public void testToString() {
  assertEquals(
  			"Trainer [" +
				"Email: " +"Joe@Trainers.ie" + 
				", Name:" + "Joe" + 
				" (" + "M" + ")" + 
				", Address:" + "Kerry" + "." + 
				 ", Speciality:" + "Running"
	            ,
	            train1.toString());
 
}



}













