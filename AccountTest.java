package TheaterSystem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tests the Account Class
 * @author Ian McDowell
 *
 */
class AccountTest {

	@Test
	void testCreateAccount() {
		Account newAcc = new Account("first","last");
		assertNotNull(newAcc, "Account should be created with a first and last name.");
	}
	
	@Test
	void testValidGetLastName() {
		Account newAcc = new Account("first","last");
		assertEquals("last",newAcc.getLastName(), "Last name should be \"last\".");
	}

}
