package TheaterSystem;
import java.util.ArrayList;
/***
 * This class is for containing all the information for a theater including the seats,
 * events, and venue it is in
 * @author Bekah
 *
 */
public class Theater {
  public ArrayList<Seat> seats;
  public ArrayList<Event> events;
  public Venue venueContaining;
  public Theater(ArrayList<Seat> seats, Venue venueContaining) {
    this.seats = seats;
    this.venueContaining = venueContaining;
    this.events = new ArrayList<Event>();
  }
  /***
   * This class takes in what is needed to create a movie (in the movie constructor),
   * and adds the movie to the event array list
   * @param startTime
   * @param endTime
   * @param name
   * @param description
   * @param ageRating
   * @param price
   * @param actors
   * @param producers
   * @param directors
   */
  public void addMovie(String startTime, String endTime, String name, String
      description, String ageRating, double price, String[] actors, String[]
          producers, String[] directors) {
    this.events.add(Movie(startTime, endTime, name, description, ageRating, price, actors, producers, directors));
  }
  /***
   * This class takes in what is needed to create a play (in the play constructor),
   * and adds the play to the event array list 
   * @param startTime
   * @param endTime
   * @param name
   * @param description
   * @param ageRating
   * @param price
   * @param actors
   * @param producers
   * @param playwrites
   */
  public void addPlay(String startTime, String endTime, String name, String
      description, String ageRating, double price, String[] actors, String[]
          producers, String[] playwrites) {
    this.events.add(Play(startTime, endTime, name, description, ageRating, price, actors, producers, playwrites));
  }
  /***
   * This class takes in what is needed to create a concert (in the concert constructor),
   * and adds the concert to the event array list
   * @param startTime
   * @param endTime
   * @param name
   * @param description
   * @param ageRating
   * @param price
   * @param performers
   */
  public void addConcert(String startTime, String endTime, String name,
      String description, String ageRating, double price, String[]
          performers) {
    this.events.add(Concert(startTime, endTime, name, description, ageRating, price, performers));
  }
}
