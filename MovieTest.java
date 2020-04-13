package TheaterSystem;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MovieTest {

  @Test
  void testConstructor() {
    Venue v = new Venue (null);
    Theater t = new Theater(null, null);
    Movie movie = new Movie ( v , t, null, null, null, null, null, 0, null, null, null, null);
    assertNotNull(movie, "This movie has null data.");
  }
}
