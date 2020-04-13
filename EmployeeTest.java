package TheaterSystem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tests the Employee Class
 * @author Ian McDowell
 *
 */
class EmployeeTest {

	@Test
	void testCreateEmployee() {
		Employee e = new Employee("first","last","pass","1234", true);
		assertEquals(true,e.isEmployee,"isEmployee should be true on construction.");
	}

}
