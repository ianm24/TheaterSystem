package TheaterSystem;

import java.io.FileWriter;
import java.util.ArrayList;

/**
 * The System that pulls all of the other classes together
 * 
 * @author Tyron Schultz, Miles Littlejohn
 *
 */
public class TheaterSystem {
	private ArrayList<User> accounts;
	public Account currentAccount;
	public String userAccountType;
	public ArrayList<Venue> venues;

	/**
	 * Default constructor for TheaterSystem that initializes the ArrayLists and
	 * loads from the JSON file
	 */
	public TheaterSystem() {
		accounts = new ArrayList<User>();
		venues = new ArrayList<Venue>();
		this.loadFromJSON();
		this.userAccountType = "Guest";
	}

	/**
	 * constructor
	 * 
	 * @param accounts that are currently in the system
	 * @param venues   that are currently in the system
	 */
	public TheaterSystem(ArrayList<User> accounts, ArrayList<Venue> venues) {
		this.accounts = accounts;
		this.venues = venues;
	}

	/**
	 * sets the currentAccount to the person who is logging in
	 * 
	 * @param firstName
	 * @param lastName
	 * @param password
	 * @return true if the login is successful but false otherwise
	 */
	public String login(String firstName, String lastName, String password) {
		for (User account : accounts) {
			if (account.firstName.equals(firstName) && account.getLastName().equals(lastName)
					&& account.getPassword().equals(password)) {
				currentAccount = account;
				updateAccountType();
				return this.userAccountType;
			} else {
				continue;
			}
		}
		return "Fail";
	}

	/**
	 * Helper method that updates the
	 */
	private void updateAccountType() {
		if (currentAccount.getClass().getName().contains("User")) {
			this.userAccountType = "User";
		} else if (currentAccount.getClass().getName().contains("Employee")) {
			this.userAccountType = "Employee";
		} else if (currentAccount.getClass().getName().contains("Admin")) {
			this.userAccountType = "Admin";
		}
	}

	/**
	 * Creates an account and adds it to the accounts arraylist
	 * 
	 * @param firstName
	 * @param lastName
	 * @param phoneNumber
	 * @param password
	 * @param isEmployee
	 * @param isAdmin
	 * @return confirmation message
	 */
	public String createAccount(String firstName, String lastName, String phoneNumber, String password,
			boolean isEmployee, boolean isAdmin) {
		if (isEmployee == true && isAdmin == true)
			return "Cannot be Employee and Admin";
		if (isEmployee) {
			Employee newAcc = new Employee(firstName, lastName, password, phoneNumber, isEmployee);
			this.accounts.add(newAcc);
			this.currentAccount = newAcc;
		} else if(isAdmin) {
			Admin newAcc = new Admin(firstName, lastName, password, phoneNumber, isAdmin);

			this.accounts.add(newAcc);
			this.currentAccount = newAcc;
		} else {
			User newAcc = new User(firstName, lastName, password, phoneNumber);
			this.accounts.add(newAcc);
			this.currentAccount = newAcc;
			this.updateAccountType();
		}
		return "Account created successfully";
	}

	/**
	 * returns an ArrayList of shows if the name matches
	 * 
	 * @param showName
	 * @return ArrayList of the matching shows
	 */
	public ArrayList<Show> searchShowName(String showName) {
		ArrayList<Show> matches = new ArrayList<Show>();
		for (Venue venue : venues) {
			for (Theater theater : venue.theaters) {
				for (Show show : theater.shows) {
					if (show.name.equalsIgnoreCase(showName))
						matches.add(show);
				}
			}
		}
		return matches;
	}

	/**
	 * returns an ArrayList of shows if the genre matches
	 * 
	 * @param showGenre
	 * @return ArrayList of the matching shows
	 */
	public ArrayList<Show> searchGenre(String genre) {
		ArrayList<Show> matches = new ArrayList<Show>();
		for (Venue venue : venues) {
			for (Theater theater : venue.theaters) {
				for (Show show : theater.shows) {
					if (show.genre.equalsIgnoreCase(genre))
						matches.add(show);
				}
			}
		}
		return matches;
	}

	/**
	 * Searches for all shows within 0.1 stars of the parameters
	 * 
	 * @param rating
	 * @return
	 */
	public ArrayList<Show> searchRating(Double rating) {
		ArrayList<Show> matches = new ArrayList<Show>();
		for (Venue venue : venues) {
			for (Theater theater : venue.theaters) {
				for (Show show : theater.shows) {
					if (Math.abs(show.getRating() - rating) < 0.1)
						matches.add(show);
				}
			}
		}
		return matches;
	}

	/**
	 * method to search by the age ratings of a movie
	 * 
	 * @param ageRating
	 * @return an arrayList of matches to the rating
	 */
	public ArrayList<Show> searchAgeRating(String ageRating) {
		ArrayList<Show> matches = new ArrayList<Show>();
		for (Venue venue : venues) {
			for (Theater theater : venue.theaters) {
				for (Show show : theater.shows) {
					if (show.ageRating.equalsIgnoreCase(ageRating))
						matches.add(show);
				}
			}
		}
		return matches;
	}

	public Seat seatSearch(Theater theater, char row, int col) {
		for (Seat seat : theater.seats) {
			if (seat.row == row && seat.col == col && seat.isReserved == false)
				return seat;
		}
		return null;
	}

	public Seat nextSeatSearch(Theater theater) {
		for (Seat seat : theater.seats)
			if (seat.isReserved == false)
				return seat;
		return null;
	}

	/**
	 * 
	 * @param show
	 * @return Buys a random seat
	 */
	public String purchaseTicket(Show show) {
		String print = "";
		Seat userSeat = this.nextSeatSearch(show.theater);
		userSeat.isReserved = true;
		this.currentAccount.ticketsPurchased++;
		if (this.currentAccount.ticketsPurchased == 11) {
			print += "Congratulations this ticket is free!\n";
			this.currentAccount.ticketsPurchased -= 10;
		}
		print += this.printTicket(show, userSeat);
		return print;
	}

	/**
	 * 
	 * @param show
	 * @param row
	 * @param col  Buys a specific seat
	 */
	public String purchaseTicket(Show show, char row, int col) {
		String print = "";
		Seat userSeat = this.seatSearch(show.theater, row, col);
		userSeat.isReserved = true;
		this.currentAccount.ticketsPurchased++;
		if (this.currentAccount.ticketsPurchased == 11) {
			print += "Congratulations this ticket is free!\n";
			this.currentAccount.ticketsPurchased -= 10;
		}
		print += this.printTicket(show, userSeat);
		return print;
	}

	/**
	 * 
	 * @param show
	 * @return Refunds a pre-purchased ticket
	 */
	public String refundTicket(Show show) {
		return "Ticket refunded";
	}

	/**
	 * 
	 * @param show the show whose ticket is getting printed
	 * @return a string with the information for the show
	 */
	public String printTicket(Show show, Seat seat) {
		try {
            FileWriter writer = new FileWriter(show.name+"ticket.txt");
            writer.write("******************************\n");
            writer.write("*****     " +currentAccount.firstName+ "'s Ticket     *****\n");
            writer.write("Show: "+show.name+"\n");
            writer.write("Start time: "+show.startTime+"\n");
            writer.write("End time: "+show.endTime+"\n");
            writer.write("Your Seat is: "+seat.row+seat.col+"\n");
            writer.write("******************************\n");
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }
		return "Printing your ticket..." + "\nStart Time: " + show.startTime + " \nEnd Time: " + show.endTime
				+ "Your event: " + show.name + "\nYour Seat: " + seat.row + ":" + seat.col;

	}

	/**
	 * @param rating is the rating of the show
	 * @param review is the review of the show
	 * @param show   the name of the show being altered Assigns a review to a
	 *               specific show
	 */
	public void leaveReview(double rating, String review, Show show) {
		show.addRating(rating, review);
	}

	/**
	 * 
	 * @param rating is the pre-existing rating
	 * @param review is the pre-existing review
	 * @param show   the show that's getting thre review removed Removes the review
	 *               off of a show
	 */
	public void deleteReview(double rating, String review, Show show) {
		if (show.userRating.contains(rating) && show.reviews.contains(review)) {
			show.userRating.remove(rating);
			show.reviews.remove(review);
		}
	}
	public void addEvent(Theater theater, Show show) {
		theater.shows.add(show);
	}

	public void saveToJSON() {
		JSONHandler.saveAccounts(this.accounts);
		JSONHandler.saveVenues(this.venues);
	}

	public void loadFromJSON() {
		this.accounts = JSONHandler.loadAccounts();
		this.venues = JSONHandler.loadVenues();
	}

}
