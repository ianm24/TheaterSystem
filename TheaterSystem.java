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

	public void leaveReview(double rating, String review, Show show) {

	}

	public void deleteReview(double rating, String review, Show show) {
	  
	}

	public void saveToJSON() {

	}

	public void loadFromJSON() {

	}

}
