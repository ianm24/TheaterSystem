package TheaterSystem;

import java.util.ArrayList;

public class TheaterSystem {
	private ArrayList<Account> accounts;
	public Account currentAccount;
	public ArrayList<Venue> venues;

	public TheaterSystem(ArrayList<Account> accounts, ArrayList<Venue> venues) {
		this.accounts = accounts;
		this.venues = venues;
	}

	public boolean login(String firstName, String lastName, String password) {
		for(Account account : accounts) {
			
		}
	}

	public void createAccount(String firstName, String lastName, String phoneNumber, String password, boolean isEmployee,
			boolean isAdmin) {

	}

	public ArrayList<Event> searchEventName(String eventName) {

	}

	public ArrayList<Event> searchGenre(String genre) {

	}

	public ArrayList<Event> searchRating(String rating) {

	}

	public ArrayList<Event> searchAgeRating(String ageRating) {

	}

	public void addEvent(Theater theater) {

	}

	public void purchaseTicket(Event event) {

	}

	public void refundTicket(Event event) {

	}

	public String printTicket(Event event) {

	}

	public void leaveReview(double rating, String review, Event event) {

	}

	public void deleteReview(double rating, String review, Event event) {
	  
	}

	public void saveToJSON() {

	}

	public void loadFromJSON() {

	}

}
