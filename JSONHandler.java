package TheaterSystem;

import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Used to import/export data to/from the Theater System
 * @author Ian McDowell
 *
 */
public class JSONHandler extends JSONConstants{

	/**
	 * Loads the system's Venues from the JSON file
	 * @return Returns an ArrayList of Venues stored in the JSON file
	 */
	public static ArrayList<Venue> loadVenues() {
		ArrayList<Venue> venues = new ArrayList<Venue>();
		try {
			FileReader reader = new FileReader(VENUES_FILENAME);
			JSONParser parser = new JSONParser();
			JSONArray JSONVenues = (JSONArray)new JSONParser().parse(reader);
			for(int i = 0; i < JSONVenues.size(); i++) {
				JSONObject JSONVenue = (JSONObject)JSONVenues.get(i);
				String venueName = (String)JSONVenue.get(VENUE_NAME);
				Venue venue = new Venue(venueName);
				
				JSONArray JSONTheaters = (JSONArray)JSONVenue.get(THEATERS);
				ArrayList<Theater> theaters = new ArrayList<Theater>();
				
				for(int j = 0; j < JSONTheaters.size(); j++) {
					JSONObject JSONTheater = (JSONObject)JSONTheaters.get(j);
					
					JSONArray JSONSeats = (JSONArray)JSONTheater.get(THEATER_SEATS);
					ArrayList<Seat> seats = new ArrayList<Seat>();
					for(int k = 0; k < JSONSeats.size(); k++) {
						JSONObject JSONSeat = (JSONObject)JSONSeats.get(k);
						boolean isHandicapable = (boolean)JSONSeat.get(SEATS_HANDICAPABLE);
						boolean isReserved = (boolean)JSONSeat.get(SEATS_RESERVED);
						char row = (char)JSONSeat.get(SEATS_ROW);
						int col = (int)JSONSeat.get(SEATS_COL);
						Seat seat = new Seat(isHandicapable,row,col);
						seat.setReserved(isReserved);
						seats.add(seat);
					}
					venue.addTheater(seats);
					JSONObject JSONShows = (JSONObject)JSONTheater.get(SHOWS);
					ArrayList<Show> shows = new ArrayList<Show>();
					
					JSONArray JSONMovies = (JSONArray)JSONShows.get(MOVIES);					
					for(int k = 0; k < JSONMovies.size(); k++) {
						JSONObject JSONMovie = (JSONObject)JSONMovies.get(k);
						String startTime = (String)JSONMovie.get(EVENT_START_TIME);
						String endTime = (String)JSONMovie.get(EVENT_END_TIME);
						String name = (String)JSONMovie.get(EVENT_NAME);
						String description = (String)JSONMovie.get(EVENT_DESCRIPTION);
						String ageRating = (String)JSONMovie.get(EVENT_START_TIME);
						double[] userRating = (double[])JSONMovie.get(EVENT_USER_RATING);
						double price = (double)JSONMovie.get(EVENT_PRICE);
						String genre = (String)JSONMovie.get(EVENT_GENRE);
						String[] reviews = (String[])JSONMovie.get(EVENT_REVIEWS);
						String[] actors = (String[])JSONMovie.get(EVENT_ACTORS);
						String[] producers = (String[])JSONMovie.get(EVENT_PRODUCERS);
						String[] directors = (String[])JSONMovie.get(MOVIE_DIRECTORS);
						Movie movie = new Movie(venue,venue.theaters.get(j),startTime,
								endTime,name,description,ageRating,price,genre,actors,producers,directors);
						shows.add(movie);
					}
					JSONArray JSONPlays = (JSONArray)JSONShows.get(PLAYS);
					for(int k = 0; k < JSONPlays.size(); k++) {
						JSONObject JSONPlay = (JSONObject)JSONPlays.get(k);
						String startTime = (String)JSONPlay.get(EVENT_START_TIME);
						String endTime = (String)JSONPlay.get(EVENT_END_TIME);
						String name = (String)JSONPlay.get(EVENT_NAME);
						String description = (String)JSONPlay.get(EVENT_DESCRIPTION);
						String ageRating = (String)JSONPlay.get(EVENT_START_TIME);
						double[] userRating = (double[])JSONPlay.get(EVENT_USER_RATING);
						double price = (double)JSONPlay.get(EVENT_PRICE);
						String genre = (String)JSONPlay.get(EVENT_GENRE);
						String[] reviews = (String[])JSONPlay.get(EVENT_REVIEWS);
						String[] actors = (String[])JSONPlay.get(EVENT_ACTORS);
						String[] producers = (String[])JSONPlay.get(EVENT_PRODUCERS);
						String[] playwrites = (String[])JSONPlay.get(PLAY_PLAYWRITES);
						Play play = new Play(venue,venue.theaters.get(j),startTime,
								endTime,name,description,ageRating,price,genre,actors,producers,playwrites);
						shows.add(play);
					}
					JSONArray JSONConcerts = (JSONArray)JSONShows.get(CONCERTS);
					for(int k = 0; k < JSONConcerts.size(); k++) {
						JSONObject JSONConcert = (JSONObject)JSONConcerts.get(k);
						String startTime = (String)JSONConcert.get(EVENT_START_TIME);
						String endTime = (String)JSONConcert.get(EVENT_END_TIME);
						String name = (String)JSONConcert.get(EVENT_NAME);
						String description = (String)JSONConcert.get(EVENT_DESCRIPTION);
						String ageRating = (String)JSONConcert.get(EVENT_START_TIME);
						double[] userRating = (double[])JSONConcert.get(EVENT_USER_RATING);
						double price = (double)JSONConcert.get(EVENT_PRICE);
						String genre = (String)JSONConcert.get(EVENT_GENRE);
						String[] reviews = (String[])JSONConcert.get(EVENT_REVIEWS);
						String[] performers = (String[])JSONConcert.get(CONCERT_PERFORMERS);
						Concert concert = new Concert(venue,venue.theaters.get(j),startTime,
								endTime,name,description,ageRating,price,genre,performers);
						shows.add(concert);
					}
					venue.theaters.get(j).shows = shows;
				}
				venues.add(venue);
			}
			
			return venues;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Loads the system's Users from the JSON file
	 * @return Returns and ArrayList of Users stored in the JSON file
	 */
	public static ArrayList<User> loadAccounts() {
		ArrayList<User> users = new ArrayList<User>();
		try {
			FileReader reader = new FileReader(ACCOUNTS_FILENAME);
			JSONParser parser = new JSONParser();
			JSONArray JSONUsers = (JSONArray)new JSONParser().parse(reader);
			for(int i = 0; i < JSONUsers.size(); i++) {
				JSONObject JSONUser = (JSONObject)JSONUsers.get(i);
				String firstName = (String)JSONUser.get(USER_FIRST_NAME);
				String lastName = (String)JSONUser.get(USER_LAST_NAME);
				String password = (String)JSONUser.get(USER_PASSWORD);
				String phoneNumber = (String)JSONUser.get(USER_PHONE_NUMBER);
				boolean isEmployee = (boolean)JSONUser.get(USER_IS_EMPLOYEE);
				boolean isAdmin = (boolean)JSONUser.get(USER_IS_ADMIN);
				if(isEmployee) {
					Employee employee = new Employee(firstName,lastName,password,phoneNumber,isEmployee);
					users.add(employee);
				} else if(isAdmin) {
					Admin admin = new Admin(firstName,lastName,password,phoneNumber,isAdmin);
					users.add(admin);
				} else {
					User user = new User(firstName,lastName,password,phoneNumber);
					users.add(user);
				}
			}
			return users;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void saveAccounts(ArrayList<User> users) {
		JSONArray jsonUsers = new JSONArray();
		
		for(int i = 0; i < users.size(); i++ ) {
			jsonUsers.add(getAccountJSON(users.get(i)));
		}
		
		try(FileWriter file = new FileWriter(ACCOUNTS_FILENAME)) {
			file.write(jsonUsers.toJSONString());
			file.flush();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static JSONObject getAccountJSON(User user) {
		JSONObject accountDetails = new JSONObject();
		accountDetails.put(USER_FIRST_NAME, user.firstName);
		accountDetails.put(USER_LAST_NAME, user.getLastName());
		accountDetails.put(USER_PASSWORD, user.getPassword());
		accountDetails.put(USER_PHONE_NUMBER, user.getPhoneNumber());
		if (user.getClass().getName().contains("User")) {
			accountDetails.put(USER_IS_EMPLOYEE, false);
			accountDetails.put(USER_IS_ADMIN, false);
		} else if (user.getClass().getName().contains("Employee")) {
			accountDetails.put(USER_IS_EMPLOYEE, true);
			accountDetails.put(USER_IS_ADMIN, false);
		} else if (user.getClass().getName().contains("Admin")) {
			accountDetails.put(USER_IS_EMPLOYEE, false);
			accountDetails.put(USER_IS_ADMIN, true);
		}
		return accountDetails;
	}
}
