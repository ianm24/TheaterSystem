package TheaterSystem;

import java.util.ArrayList;

/**
 * 
 * @author Miles Creates the beginnings of a show
 */
public class Show extends Event {
	public String name;
	public String description;
	public String ageRating;
	public double userRating;
	public double price;
	public ArrayList<String> reviews;

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
	 *                    Creates a Show
	 */
	public Show(Venue venue, Theater theater, String startTime, String endTime, String name, String description,
			String ageRating, double price) {
		super(venue, theater, startTime, endTime);
		this.name = name;
		this.description = description;
		this.ageRating = ageRating;
		this.price = price;
		this.userRating = 0.0;
	}

	/**
	 * Displays all the information about the show
	 */
	public String toString() {
		return super.toString() + "\nName:" + this.name + "\nDescription:" + this.description + "\nAge Rating:"
				+ this.ageRating + "\nPrice: $" + this.price;
	}

	/**
	 * 
	 * @param rating the show's rating
	 * @param review a review left by a user
	 */
	public void addRating(double rating, String review) {
		this.userRating = rating;
		this.reviews.add(review);
	}
}
