package TheaterSystem;

import java.util.ArrayList;

public class TheaterSystem {
	private ArrayList<Account> accounts;
	public Account currentAccount;
	public ArrayList<Venue> venues;

	public TheaterSystem(ArrayList<Account> accounts, ArrayList<Venue> venues) {

	}

	public void login(String firstName, String lastName, String phoneNumber, String password, bool isEmployee,
			bool isAdmin) {

	}

	public void createAccount(String firstName, String lastName, String phoneNumber, String password, bool isEmployee,
			bool isAdmin) {

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

	public void printTicket(Event event) {

	}

	public void leaveReview(int rating, String review) {

	}

	public void deleteReview(int rating, String review) {

	}

	public void saveToJSON() {

	}

	public void loadFromJSON() {

	}

}
