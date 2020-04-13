package TheaterSystem;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ConcertTest {

  @Test
  void testConstructor() {
    Venue v = new Venue(null);
    Theater t = new Theater(null,null);
    Concert concert = new Concert ( v , t, null, null, null, null, null, 0, null, null);
    assertNotNull(concert,"This concert has null data");
  }

}
