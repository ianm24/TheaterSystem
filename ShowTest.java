package TheaterSystem;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ShowTest {

  @Test
  void testConstructor() {
    Venue v = new Venue(null);
    Theater t = new Theater(null,null);
    Show s = new Show(v, t, null, null, null, null, null, 0, null);
    assertNotNull(s, "This show is null");
  }
  
  

}
