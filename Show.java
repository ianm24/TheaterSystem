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
	public ArrayList<Double> userRating;
	public double price; 
	public ArrayList<String> reviews;
	public String genre;

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
			String ageRating, double price, String genre) {
		super(venue, theater, startTime, endTime);
		this.name = name;
		this.description = description;
		this.userRating = new ArrayList<Double>();
		this.reviews = new ArrayList<String>();
		this.ageRating = ageRating;
		this.price = price;
		this.genre = genre;
	}

	/**
	 * Displays all the information about the show
	 */
	public String toString() {
		String reviewString = "";
		for(String review : this.reviews) {
			reviewString += "\n\t"+review;
		}
		return super.toString() + "\nName:" + this.name + "\nDescription:" + this.description + "\nAge Rating:"
				+ this.ageRating + "\nPrice: $" + this.price + "\nGenre: " + this.genre + "\nUser Rating: " + this.getRating()
				+ "\nReviews:" + reviewString;
	}

	/**
	 * 
	 * @param rating the show's rating
	 * @param review a review left by a user
	 */
	public void addRating(double rating, String review) {
		this.userRating.add(rating);
		this.reviews.add(review);
	}
	
	/**
	 * helping method to get 
	 * @return the average rating for the show
	 */
	public double getRating() {
		double uRating = 0;
		int num = 0;
		for(double rating : userRating) {
			uRating += rating;
			num++;
		}
		uRating/= num;
		return uRating;
	}
}
