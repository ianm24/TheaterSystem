package TheaterSystem;

import java.util.ArrayList;

/**
 * The System that pulls all of the other classes together
 * @author Tyron Schultz, Miles Littlejohn
 *
 */
public class TheaterSystem {
	private ArrayList<User> accounts;
	public Account currentAccount;
	public ArrayList<Venue> venues;

	/**
	 * constructor
	 * @param accounts that are currently in the system
	 * @param venues that are currently in the system
	 */
	public TheaterSystem(ArrayList<User> accounts, ArrayList<Venue> venues) {
		this.accounts = accounts;
		this.venues = venues;
	}

	/**
	 * sets the currentAccount to the person who is logging in
	 * @param firstName
	 * @param lastName
	 * @param password
	 * @return true if the login is successful but false otherwise
	 */
	public boolean login(String firstName, String lastName, String password) {
		for(User account : accounts) {
			if(account.firstName.equals(firstName) && account.getLastName().equals(lastName) && account.getPassword().equals(password)) {
				currentAccount = account;
				return true;
			} else {
				continue;
			}
		}
		return false;
	}
	
	/**
	 * Creates an account and adds it to the accounts arraylist
	 * @param firstName
	 * @param lastName
	 * @param phoneNumber
	 * @param password
	 * @param isEmployee
	 * @param isAdmin
	 * @return confirmation message
	 */
	public String createAccount(String firstName, String lastName, String phoneNumber, String password, boolean isEmployee,
			boolean isAdmin) {
		if(isEmployee==true && isAdmin==true)
			return "Cannot be Employee and Admin";
		if(isEmployee) {
			Employee newAcc = new Employee(firstName, lastName, password, phoneNumber, isEmployee);
			this.accounts.add(newAcc);
			this.currentAccount = newAcc;
		} else if(isAdmin) {
			Admin newAcc = new Admin(firstName, lastName, password, phoneNumber, isEmployee);
			this.accounts.add(newAcc);
			this.currentAccount = newAcc;
		} else {
			User newAcc = new User(firstName, lastName, password, phoneNumber);
			this.accounts.add(newAcc);
			this.currentAccount = newAcc;
		}
		return "Account created successfully";
	}

	/**
	 * returns an ArrayList of shows if the name matches
	 * @param showName
	 * @return ArrayList of the matching shows
	 */
	public ArrayList<Show> searchShowName(String showName) {
		ArrayList<Show> matches = new ArrayList<Show>();
		for(Venue venue : venues) {
			for(Theater theater : venue.theaters) {
				for(Show show : theater.shows) {
					if(show.name.equalsIgnoreCase(showName))
						matches.add(show);
				}
			}
		}
		return matches;
	}

	/**
	 * returns an ArrayList of shows if the genre matches
	 * @param showGenre
	 * @return ArrayList of the matching shows
	 */
	public ArrayList<Show> searchGenre(String genre) {
		ArrayList<Show> matches = new ArrayList<Show>();
		for(Venue venue : venues) {
			for(Theater theater : venue.theaters) {
				for(Show show : theater.shows) {
					if(show.genre.equalsIgnoreCase(genre))
						matches.add(show);
				}
			}
		}
		return matches;
	}
	
	/**
	 * 
	 * @param rating
	 * @return
	 */
	public ArrayList<Show> searchRating(Double rating) {
		ArrayList<Show> matches = new ArrayList<Show>();
		for(Venue venue : venues) {
			for(Theater theater : venue.theaters) {
				for(Show show : theater.shows) {
					if(Math.abs(show.getRating()-rating)<0.1)
						matches.add(show);
				}
			}
		}
		return matches;
	}

	public ArrayList<Show> searchAgeRating(String ageRating) {

	}

	public void addShow(Theater theater) {

	}

	public void purchaseTicket(Show show) {

	}

	public void refundTicket(Show show) {

	}

	/**
	 * 
	 * @param show the show whose ticket is getting printed
	 * @return a string with the information for the show
	 */
	public String printTicket(Show show) {
	  return "Printing your ticket..." + "\nStart Time: " + show.startTime + " \nEnd Time: " + show.endTime + "Your event: "
	      + show.name + "\nYour Seat: ";
	}

	/**
	 * @param rating is the rating of the show
	 * @param review is the review of the show
	 * @param show the name of the show being altered
	 * Assigns a review to a specific show
	 */
	public void leaveReview(double rating, String review, Show show) {
	  show.addRating(rating, review);
	}

	/**
	 * 
	 * @param rating is the pre-existing rating
	 * @param review is the pre-existing review
	 * @param show the show that's getting thre review removed
	 * Removes the review off of a show
	 */
	public void deleteReview(double rating, String review, Show show) {
	  if (show.userRating.contains(rating) && show.reviews.contains(review)) {
	    show.userRating.remove(rating);
	    show.reviews.remove(review);
	  }
	}

	public void saveToJSON() {

	}

	public void loadFromJSON() {

	}

}
