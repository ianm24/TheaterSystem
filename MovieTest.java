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
  
  void testToString() {
    Venue v = new Venue ("name");
    Theater t = new Theater(null, null);
    String[] a = new String[0];
    String[] b = new String[0];
    String[] c = new String[0];
    
    a[0] = "a";
    b[0] = "b";
    c[0] = "c";
    Movie movie = new Movie ( v , t, "8", "8", "n", "d", "aR", 0, "g", a, b, c);
    String s = "Venue: name \nTheater: 0 \nStart Time: 8 \nEnd Time: 8 \nName: n \nDescription: d \nAge Rating: aR \nPrice: 0 \nGenre: g \n a \n\t b \n\t c";
    boolean again = movie.toString().equalsIgnoreCase(s);
    assertEquals(movie.toString(), );
  }
}
