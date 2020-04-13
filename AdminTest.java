package TheaterSystem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tests the Admin Class
 * @author Ian McDowell
 *
 */
class AdminTest {

	@Test
	void testCreateAdmin() {
		Admin a = new Admin("first","last","pass","1234",true);
		assertEquals(true,a.isAdmin,"isAdmin should be true on construction.");
	}

}
