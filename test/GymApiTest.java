import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * GymApi Test class for the GymApi class
 * @author Daemon Macklin 20075689
 *
 */
public class GymApiTest {
	Member member;
	Member member2;
	Trainer trainer;
	private int index;
	private int invalidIndex;
	GymApi gymApi;
	
	/**
	   * Set up test fixtures
	   * 
	   * Called before every test method
	   */
	  @Before
	  public void setUp() {
		this.gymApi = new GymApi();
	    member = new StudentMember("joesoap@wit.ie", "Joe Soap", "wit", "M", 1.8, 65, "200011","WIT", "Package 1" );
	    trainer = new Trainer("Joe@Trainers.ie", "Joe", "Kerry", "M", "Running");
	    index = 1;
	    invalidIndex = 3;
	    gymApi.addMember(member);
	    gymApi.addTrainer(trainer);
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
	   * Test for addMember method
	   */
	  @Test
	  public void testAddMember(){
		 gymApi.addMember(member);
		 assertEquals(member, gymApi.getMembers().get(index));
	  }
	  
	  /**
	   * Test for add trainer method
	   */
	  @Test
	  public void testAddTrainer(){
		  gymApi.addTrainer(trainer);
		  assertEquals(trainer, gymApi.getTrainers().get(index));
	  }
	  
	  /**
	   * Test for number of members method
	   */
	  @Test
	  public void testNoMembers(){
		  assertEquals(gymApi.getMembers().size(), gymApi.numberOfMembers());
	  }
	  
	  /**
	   * Test for number of trainers method
	   */
	  @Test
	  public void testNoTrainers(){
		  assertEquals(gymApi.getTrainers().size(), gymApi.numberOfTrainers());
	  }
	  
	  /**
	   * Test for valid member method
	   */
	  @Test
	  public void testValidMember(){
		 assertEquals(false, gymApi.isValidMemberIndex(invalidIndex));
		assertEquals(true, gymApi.isValidMemberIndex(index));
	  }	  
	  /**
	   * Test for valid trainer method
	   */
	  @Test
	  public void testValidTrainer(){
		  assertEquals(false, gymApi.isValidTrainerIndex(invalidIndex));
			assertEquals(true, gymApi.isValidTrainerIndex(index));
	  }
	  
	  /**
	   * Test for search member by email method
	   */
	  @Test
	  public void testSearchMembersByEmail(){
		  assertEquals(member, gymApi.searchMembersByEmail("joesoap@wit.ie"));
		  assertEquals(null, gymApi.searchMembersByEmail("Invalid Email"));
	  }
}
