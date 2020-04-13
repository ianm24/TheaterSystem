package TheaterSystem;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class TheaterTest {

  @Test
  void testConstructor() {
    Venue venue = new Venue("venue1");
    ArrayList<Seat> seats = new ArrayList<Seat>();
    Theater t = new Theater(seats,venue);
    assertNotNull(t, "constructor failed test");
  }
  
  @Test
  void testAddMovie() {
    Venue venue = new Venue("venue1");
    ArrayList<Seat> seats = new ArrayList<Seat>();
    Theater t = new Theater(seats,venue);
    String[] actors = new String[1];
    String[] producers = new String[1];
    String[] directors = new String[1];
    t.addMovie("startTime", "endTime", "String name", "String description", "String ageRating",
        1.0, "String genre", actors, producers, directors);
    assertNotNull(t, "addMovie failed");
  }
  @Test
  void testAddPlay() {
    Venue venue = new Venue("venue1");
    ArrayList<Seat> seats = new ArrayList<Seat>();
    Theater t = new Theater(seats,venue);
    String[] actors = new String[1];
    String[] producers = new String[1];
    String[] playwrites = new String[1];
    t.addPlay("String startTime", "String endTime", "String name", "String description", "String ageRating",
        1.0, "String genre", actors, producers, playwrites);
    assertNotNull(t, "addPlay Failed");
  }
  @Test
  void testAddConcert() {
    Venue venue = new Venue("venue1");
    ArrayList<Seat> seats = new ArrayList<Seat>();
    Theater t = new Theater(seats,venue);
    String[] performers = new String[1];
    t.addConcert("String startTime", "String endTime", "String name", "String description", "String ageRating",
        1.0, "String genre", performers);
    assertNotNull(t, "addConcert Failed");
  }

}
