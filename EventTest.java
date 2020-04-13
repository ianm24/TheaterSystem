package TheaterSystem;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class EventTest {

  @Test
  void testConstructor() {
    Venue v = new Venue(null);
    Theater t = new Theater(null,null);
    Event e = new Event(v, t, null, null);
    assertNotNull(e,"This event is null");
  }

}
