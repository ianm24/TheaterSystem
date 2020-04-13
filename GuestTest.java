package TheaterSystem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tests the Guest Class
 * @author Ian McDowell
 *
 */
class GuestTest {

	@Test
	void testCreateGuest() {
		Guest newGuest = new Guest();
		assertEquals(true,newGuest.isGuest,"isGuest should be true on construction.");
	}

}
