package TheaterSystem;

/**
 * Holds information for a movie
 * @author Ian McDowell
 *
 */
public class Movie extends Show{
	public String[] actors;
	public String[] producers;
	public String[] directors;
	
	/**
	 * Creates a new Movie
	 * @param venue The Venue the Movie is playing at
	 * @param theater The Theater the Movie is playing at
	 * @param startTime The start time of the Movie
	 * @param endTime The end time of the Movie
	 * @param name The name of the Movie
	 * @param description The description of the Movie
	 * @param ageRating The age rating of the Movie
	 * @param price The price of the Movie
	 * @param actors The actors of the Movie
	 * @param producers The producers of the Movie
	 * @param directors The directors of the Movie
	 */
	public Movie(Venue venue, Theater theater, String startTime, String endTime,
			String name, String description, String ageRating, double price, String genre,
			String[] actors, String[] producers, String[] directors) {
		super(venue,theater,startTime,endTime,name,description,ageRating,price, genre);
		this.actors = actors;
		this.producers = producers;
		this.directors = directors;
	}
	
	/**
	 * Returns a string with the Movie's information
	 */
	public String toString() {
		String returnString = super.toString() + "\nActors:";
		for(String actor : this.actors) {
			returnString += "\n\t" + actor;
		}
		returnString += "\nProducers:";
		for(String producer : this.producers) {
			returnString += "\n\t" + producer;
		}
		returnString += "\nDirectors::";
		for(String directors : this.directors) {
			returnString += "\n\t" + directors;
		}
		return returnString;
	}
}
