package TheaterSystem;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PlayTest {

  @Test
  void testConstructor() {
    Venue v = new Venue(null);
    Theater t = new Theater(null,null);
    Play play = new Play ( v , t, null, null, null, null, null, 0, null, null, null, null);
    assertNotNull(play,"This play has null data");
  }

}
