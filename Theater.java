package TheaterSystem;

import java.util.ArrayList;

/***
 * This class is for containing all the information for a theater including the
 * seats, events, and venue it is in
 * 
 * @author Bekah
 *
 */
public class Theater {
	public ArrayList<Seat> seats;
	public ArrayList<Show> shows;
	public Venue venueContaining;

	public Theater(ArrayList<Seat> seats, Venue venueContaining) {
		this.seats = seats;
		this.venueContaining = venueContaining;
		this.shows = new ArrayList<Show>();
	}

	/***
	 * This class takes in what is needed to create a movie (in the movie
	 * constructor), and adds the movie to the event array list
	 * 
	 * @param startTime   the movie's start time
	 * @param endTime     the movie's end time
	 * @param name        the movie's name
	 * @param description the movie's description
	 * @param ageRating   the age rating for the movie
	 * @param price       the price of the movie's ticket
	 * @param actors      the actors starring in the movie
	 * @param producers   the producers of the movie
	 * @param directors   the directors of the movie
	 */
	public void addMovie(String startTime, String endTime, String name, String description, String ageRating,
			double price, String[] actors, String[] producers, String[] directors) {
		Movie movie = new Movie(this.venueContaining, this, startTime, endTime, name, description, ageRating, price, actors, producers, directors);
		this.shows.add(movie);
	}

	/***
	 * This class takes in what is needed to create a play (in the play
	 * constructor), and adds the play to the event array list
	 * 
	 * @param startTime   the start time of the play
	 * @param endTime     the end time of the play
	 * @param name        the name of the play
	 * @param description the description of the play
	 * @param ageRating   the age rating for the play
	 * @param price       the price of the play's ticket
	 * @param actors      the actors starring in the play
	 * @param producers   the producers of the play
	 * @param playwrites  the playwrites
	 */
	public void addPlay(String startTime, String endTime, String name, String description, String ageRating,
			double price, String[] actors, String[] producers, String[] playwrites) {
		Play play = new Play(this.venueContaining, this ,startTime, endTime, name, description, ageRating, price, actors, producers, playwrites);
		this.shows.add(play);
	}

	/***
	 * This class takes in what is needed to create a concert (in the concert
	 * constructor), and adds the concert to the event array list
	 * 
	 * @param startTime   the start time of the concert
	 * @param endTime     the end time of the concert
	 * @param name        the name of the concert
	 * @param description the description of the concert
	 * @param ageRating   the age rating for the concert
	 * @param price       the price of the concert's ticket
	 * @param performers  the performers in the concert
	 */
	public void addConcert(String startTime, String endTime, String name, String description, String ageRating,
			double price, String[] performers) {
		Concert concert = new Concert(this.venueContaining, this, startTime, endTime, name, description, ageRating, price, performers);
		this.shows.add(concert);
	}
}
