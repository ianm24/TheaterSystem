package TheaterSystem;

import java.util.ArrayList;

public class TheaterSystem {
	private ArrayList<User> accounts;
	public Account currentAccount;
	public ArrayList<Venue> venues;

	public TheaterSystem(ArrayList<User> accounts, ArrayList<Venue> venues) {
		this.accounts = accounts;
		this.venues = venues;
	}

	public boolean login(String firstName, String lastName, String password) {
		for(Account account : accounts) {
			if(account.firstName.equals(firstName) && account.getLastName().equals(lastName) && account.getPassword().equals(password)) {
				currentAccount = account;
				return true;
			} else {
				continue;
			}
		}
		return false;
	}

	public String createAccount(String firstName, String lastName, String phoneNumber, String password, boolean isEmployee,
			boolean isAdmin) {
		if(isEmployee==true && isAdmin==true)
			return "Cannot be Employee and Admin";
		if(isEmployee) {
			Employee newAcc = new Employee(firstName, lastName, password, phoneNumber, isEmployee);
			this.accounts.add(newAcc);
		} else if(isAdmin) {
			Admin newAcc = new Admin(firstName, lastName, password, phoneNumber, isEmployee);
			this.accounts.add(newAcc);
		} else {
			User newAcc = new User(firstName, lastName, password, phoneNumber);
			this.accounts.add(newAcc);
		}
		return "Account created successfully";
	}

	public ArrayList<Show> searchShowName(String showName) {
		
	}

	public ArrayList<Show> searchGenre(String genre) {

	}

	public ArrayList<Show> searchRating(String rating) {

	}

	public ArrayList<Show> searchAgeRating(String ageRating) {

	}

	public void addShow(Theater theater) {

	}

	public void purchaseTicket(Show show) {

	}

	public void refundTicket(Show show) {

	}

	public String printTicket(Show show) {

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
	  if (show.userRating == rating && show.reviews.contains(review)) {
	    show.userRating = 0;
	    show.reviews.remove(review);
	  }
	}

	public void saveToJSON() {

	}

	public void loadFromJSON() {

	}

}
