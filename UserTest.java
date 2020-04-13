package TheaterSystem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tests the User Class
 * @author Ian McDowell
 *
 */
class UserTest {

	@Test
	void testCreateUser() {
		User u = new User("first","last","pass","1234");
		assertNotNull(u,"User account should be created.");
	}
	
	@Test
	void testGetPassword() {
		User u = new User("first","last","pass","1234");
		assertEquals("pass",u.getPassword(),"User account should be created.");
	}
	
	@Test
	void testGetPhoneNumber() {
		User u = new User("first","last","pass","1234");
		assertEquals("1234",u.getPhoneNumber(),"User account should be created.");
	}

}
