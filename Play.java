package TheaterSystem;

/**
 * 
 * @author Miles This is the play class used to store play information
 *
 */
public class Play extends Show {
  public String[] actors;
  public String[] producers;
  public String[] playwrites;
  
  /**
   * 
   * @param venue       The venue the show is at
   * @param theater     The theater the show is at
   * @param startTime   The starting time of the show
   * @param endTime     The ending time of the show
   * @param name        The name of the show
   * @param description A short description of the show
   * @param ageRating   The recommended age rating for the show
   * @param price       The big boy question for the show a.k.a how much it costs
   * @param actors      The actors for the show
   * @param producers   The producers for the show
   * @param playwrites  The playwrites for the show 
   */
  public Play(Venue venue, Theater theater, String startTime, String endTime, String name, String description, 
      String ageRating, double price, String genre, String[] actors, String[] producers, String[] playwrites) {
    super(venue, theater, startTime, endTime, name, description, ageRating, price, genre);
    this.actors = actors;
    this.producers = producers;
    this.playwrites = playwrites;
  }
  
  /**
   * Displays all the information for a concert
   */
  public String toString() {
    String bosses = null;
    
    //adding actors
    for (int i = 0; i < this.actors.length; i++) {
      if (i == 0) {
        bosses = "\nActors: " + actors[i];
      }
      
      bosses += "\n" + actors[i];
    }
    
    //adding producers
    bosses += "\nProducers: ";
    for (int i = 0; i < this.producers.length; i++) {
      if (i == 0) {
        bosses = producers[i];
      }
      
      bosses += "\n" + producers[i];
    }
    
    //adding directors
    bosses += "\nDirectors: ";
    for (int i = 0; i < this.actors.length; i++) {
      if (i == 0) {
        bosses = "\nActors: " + playwrites[i];
      }
      
      bosses += "\n" + playwrites[i];
    }
    
    return super.toString() + bosses;
  }
  
  
}
