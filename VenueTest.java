package TheaterSystem;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
class VenueTest {

  @Test
  void testGetName() {
   Venue venue = new Venue("venue name");
   assertEquals("venue name", venue.getName()); 
  }
  
  @Test
  void testAddTheater() {
    Venue venue = new Venue("venue1");
    ArrayList<Seat> seats = new ArrayList<Seat>();
    venue.addTheater(seats);
  }

}
