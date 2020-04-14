package TheaterSystem;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;

class TheaterSystemTest {
	
	@Test
	void notNullTest() {
		TheaterSystem ts = new TheaterSystem();
		assertNotNull(ts);
	}
	
	@Test
	void loginTest() {
		TheaterSystem ts = new TheaterSystem();
		ts.login("Ian", "McDowell", "badPassword");
		assertEquals(ts.userAccountType, "Admin");
	}
	
	@Test
	void createAccountEmployee() {
		TheaterSystem ts = new TheaterSystem();
		ts.createAccount("Tyron", "Schultz", "8888888888", "12345", true, false);
		assertEquals(ts.userAccountType, "Employee");
	}
	
	@Test
	void createAccountAdmin() {
		TheaterSystem ts = new TheaterSystem();
		ts.createAccount("bames", "Schultz", "8888888888", "12345", false, true);
		assertEquals(ts.userAccountType, "Admin");
	}
	
	@Test
	void createAccountUser() {
		TheaterSystem ts = new TheaterSystem();
		ts.createAccount("james", "Schultz", "8888888888", "12345", false, false);
		assertEquals(ts.userAccountType, "User");
	}
	
	@Test
	void searchShowNameTest() {
		TheaterSystem ts = new TheaterSystem();
		ArrayList<Show> results = ts.searchShowName("The Jungle Book");
		assertEquals(results.size(), 1);
	}
	
	@Test
	void searchGenreTest() {
		TheaterSystem ts = new TheaterSystem();
		ArrayList<Show> results = ts.searchGenre("Action");
		assertEquals(results.size(), 2);
	}
	
	@Test
	void searchRatingTest() {
		TheaterSystem ts = new TheaterSystem();
		ArrayList<Show> results = ts.searchRating(0.0);
		assertEquals(results.size(), 0);
	}
	
	@Test
	void searchAgeRatingTest() {
		TheaterSystem ts = new TheaterSystem();
		ArrayList<Show> results = ts.searchAgeRating("G");
		assertEquals(results.size(), 3);
	}
	
	@Test
	void seatSearchTest() {
		TheaterSystem ts = new TheaterSystem();
		Seat results = ts.seatSearch(ts.venues.get(0).theaters.get(0),'a',1);
		assertNotNull(results);
	}
	
	@Test
	void nextSeatSearchTest() {
		TheaterSystem ts = new TheaterSystem();
		Seat results = ts.nextSeatSearch(ts.venues.get(0).theaters.get(0));
		assertNotNull(results);
	}
	
	@Test
	void purchaseSpecificSeat() {
		TheaterSystem ts = new TheaterSystem();
		String results = ts.purchaseTicket(ts.searchShowName("The Jungle Book").get(0), 'b', 4);
		assertNotNull(results);
	}
	
	@Test
	void purchaseTicker() {
		TheaterSystem ts = new TheaterSystem();
		ts.login("Ian", "McDowell", "badPassword");
		ts.currentAccount.ticketsPurchased = 10;
		String results = ts.purchaseTicket(ts.searchShowName("The Jungle Book").get(0));
		assertNotNull(results);
	}
	
	@Test
	void displaySeatsTest() {
		TheaterSystem ts = new TheaterSystem();
		String results = ts.displaySeats(ts.venues.get(0).theaters.get(0));
		assertNotNull(results);
	}
	
	@Test
	void deleteReviewTest() {
		TheaterSystem ts = new TheaterSystem();
		Show show = ts.searchShowName("The Jungle Book").get(0);
		ts.leaveReview(3.0, "cool show", show);
		ts.deleteReview(3.0, "cool show", show);
		assertEquals(show.reviews.size(), 1);
	}
	

}
