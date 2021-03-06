package TheaterSystem;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
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
    ArrayList<String> reviews = new ArrayList<String>();
    ArrayList<Double> userRating = new ArrayList<Double>();
    userRating.add(1.0);
    reviews.add("1");
    a[0] = "a";
    b[0] = "b";
    c[0] = "c";
    
    Movie movie = new Movie ( v , t, "8", "8", "n", "d", "aR", 0, "g", a, b, c);
    String s = "Venue: name \nTheater: 0 \nStart Time: 8 \nEnd Time: 8 \nName:n \nDescription:d \nAge Rating:aR \nPrice: $0 \nGenre: g \nUser Rating: 1 \nReviews:1\nActors:\n\ta\nProducers:\n\tb\nDirectors::\n\tc";
    assertEquals(movie.toString(), s);
  }
}
