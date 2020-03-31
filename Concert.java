package TheaterSystem;

/**
 * 
 * @author Miles This is the concert class used to store concert information
 * 
 */
public class Concert extends Show {
  public String[] performers;
  
  /**
   *@param venue        The venue the show is at
   * @param theater     The theater the show is at
   * @param startTime   The starting time of the show
   * @param endTime     The ending time of the show
   * @param name        The name of the show
   * @param description A short description of the show
   * @param ageRating   The recommended age rating for the show
   * @param price       The big boy question for the show a.k.a how much it costs
   * @param performers The performers for the concert
   * Takes in the basic information for a concert
   */
  public Concert (Venue venue, Theater theater, String startTime, String endTime, String name, String description,
      String ageRating, double price, String[] performers) {
   super(venue, theater, startTime, endTime, name, description, ageRating, price);
   this.performers = performers;
  }
  
  
  /**
   * Displays all the information for a concert
   */
  public String toString() {
    String musicians = null;
    
    for (int i = 0; i < this.performers.length; i++) {
      if (i == 0) {
        musicians = performers[i];
      }
      
      musicians = "\n" + performers[i];
    }
    
    return super.toString() + "\nPerformers:" + musicians;
  }
  
  
  
}
