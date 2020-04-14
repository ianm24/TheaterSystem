package TheaterSystem;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/**
 * Tests the JSONHandler Class
 * @author Ian McDowell
 *
 */
class JSONHandlerTest {

	@Test
	void testLoadAccounts() {
		Admin a = new Admin("Ian","McDowell","badPassword","8675309",true);
		Employee e = new Employee("Sam","Miller","qwerty","8675309",true);
		User u = new User("Joe","Jones","12345","8675309");
		ArrayList<User> users = new ArrayList<User>();
		users.add(a);
		users.add(u);
		users.add(e);
		ArrayList<User> importedUsers = JSONHandler.loadAccounts();
		boolean success = true;
		for(int i = 0; i < users.size(); i++) {
			success = (users.get(i).firstName.equals(importedUsers.get(i).firstName));
		}		
		assertTrue(success,"The imported accounts should match the test ones.");
	}
	
	@Test
	void testSaveAccounts() {
		ArrayList<User> a = JSONHandler.loadAccounts();
		JSONHandler.saveAccounts(a);
		ArrayList<User> b = JSONHandler.loadAccounts();
		boolean success = true;
		for(int i = 0; i < a.size(); i++) {
			success = (a.get(i).firstName.equals(b.get(i).firstName));
		}		
		assertTrue(success,"The imported accounts should match the test ones.");
	}
	
	@Test
	void testSaveVenues() {
		ArrayList<Venue> a = JSONHandler.loadVenues();
		JSONHandler.saveVenues(a);
		ArrayList<Venue> b = JSONHandler.loadVenues();
		boolean success = true;
		for(int i = 0; i < a.size(); i++) {
			success = (a.get(i).getName().equals(b.get(i).getName()));
		}		
		assertTrue(success,"The imported venues should match the test ones.");
	}

}
