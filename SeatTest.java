package TheaterSystem;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class SeatTest {

  @Test
  void testConstructor() {
    Seat s = new Seat(true, 'a', 1);
    assertNotNull(s, "test of seat constructor failed");
  }
  
  @Test
  void testSetReserved() {
    Seat s = new Seat(true, 'a', 1);
    s.setReserved(true);
    assertEquals(s.isReserved, true);
  }

}
