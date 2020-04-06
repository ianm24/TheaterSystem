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
						for(int rev = 0; rev < reviews.length; rev++) {
							movie.addRating(userRating[rev], reviews[rev]);
						}
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
						for(int rev = 0; rev < reviews.length; rev++) {
							play.addRating(userRating[rev], reviews[rev]);
						}
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
						for(int rev = 0; rev < reviews.length; rev++) {
							concert.addRating(userRating[rev], reviews[rev]);
						}
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
		return new ArrayList<Venue>();
	}
	
	/**
	 * Loads the system's Users from the JSON file
	 * @return Returns and ArrayList of Users stored in the JSON file
	 */
	public static ArrayList<User> loadAccounts() {
		ArrayList<User> users = new ArrayList<User>();
		try {
			FileReader reader = new FileReader(ACCOUNTS_FILENAME);
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
		return new ArrayList<User>();
	}

	/**
	 * Saves accounts to a JSON file
	 * @param users ArrayList of user accounts
	 */
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
	
	/**
	 * Saves venues to a JSON file
	 * @param venues ArrayList of venues
	 */
	public static void saveVenues(ArrayList<Venue> venues) {
		JSONArray jsonVenues = new JSONArray();
		
		for(int i = 0; i < venues.size(); i++ ) {
			jsonVenues.add(getVenueJSON(venues.get(i)));
		}
		
		try(FileWriter file = new FileWriter(VENUES_FILENAME)) {
			file.write(jsonVenues.toJSONString());
			file.flush();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Converts Venue object to JSON object
	 * @param venue Venue to be converted
	 * @return JSONObject with Venue information
	 */
	public static JSONObject getVenueJSON(Venue venue) {
		JSONObject venueDetails = new JSONObject();
		venueDetails.put(VENUE_NAME, venue.getName());
		JSONArray theaters = new JSONArray();
		for(int i = 0; i < venue.theaters.size(); i++) {
			theaters.add(getTheaterJSON(venue.theaters.get(i)));
		}
		venueDetails.put(THEATERS, theaters);
		return venueDetails;
	}

	/**
	 * Converts Theater object to JSON Object
	 * @param theater Theater to convert
	 * @return JSON object with theater data
	 */
	public static JSONObject getTheaterJSON(Theater theater) {
		JSONObject theaterDetails = new JSONObject();
		JSONArray shows = new JSONArray();
		JSONArray movies = new JSONArray();
		JSONArray plays = new JSONArray();
		JSONArray concerts = new JSONArray();
		JSONArray seats = new JSONArray();
		for(int i = 0; i < theater.shows.size(); i++) {
			Show currShow = theater.shows.get(i);
			if(currShow.getClass().getName().contains("Movie")) {
				movies.add(getShowJSON(currShow));
			} else if(currShow.getClass().getName().contains("Play")) {
				plays.add(getShowJSON(currShow));
			} else if(currShow.getClass().getName().contains("Concert")) {
				concerts.add(getShowJSON(currShow));
			}
		}
		shows.add(movies);
		shows.add(plays);
		shows.add(concerts);
		theaterDetails.put(SHOWS, shows);
		for(int i = 0; i < theater.seats.size(); i++) {
			shows.add(getSeatJSON(theater.seats.get(i)));
		}
		theaterDetails.put(THEATER_SEATS, seats);
		return theaterDetails;
	}
	
	/**
	 * Converts Show object to JSON Object
	 * @param show Show to convert
	 * @return JSON object with show data
	 */
	public static JSONObject getShowJSON(Show show) {
		JSONObject showDetails = new JSONObject();
		showDetails.put(EVENT_START_TIME, show.startTime);
		showDetails.put(EVENT_END_TIME, show.endTime);
		showDetails.put(EVENT_NAME, show.name);
		showDetails.put(EVENT_DESCRIPTION, show.description);
		showDetails.put(EVENT_AGE_RATING, show.ageRating);
		showDetails.put(EVENT_USER_RATING, show.userRating);
		showDetails.put(EVENT_PRICE, show.price);
		showDetails.put(EVENT_REVIEWS, show.reviews);
		if(show.getClass().getName().contains("Movie")) {
			Movie movie = (Movie) show;
			showDetails.put(EVENT_ACTORS, movie.actors);
			showDetails.put(EVENT_PRODUCERS, movie.producers);
			showDetails.put(MOVIE_DIRECTORS, movie.directors);
		} else if(show.getClass().getName().contains("Play")) {
			Play play = (Play) show;
			showDetails.put(EVENT_ACTORS, play.actors);
			showDetails.put(EVENT_PRODUCERS, play.producers);
			showDetails.put(PLAY_PLAYWRITES, play.playwrites);
		} else if(show.getClass().getName().contains("Concert")) {
			Concert concert = (Concert) show;
			showDetails.put(CONCERT_PERFORMERS, concert.performers);
		}
		
		return showDetails;
	}
	
	/**
	 * Converts Seat object to JSON Object
	 * @param seat Seat to convert
	 * @return JSON object with seat data
	 */
	public static JSONObject getSeatJSON(Seat seat) {
		JSONObject seatDetails = new JSONObject();
		seatDetails.put(SEATS_HANDICAPABLE, seat.isHandicapable);
		seatDetails.put(SEATS_RESERVED, seat.isReserved);
		seatDetails.put(SEATS_ROW, seat.row);
		seatDetails.put(SEATS_COL, seat.col);
		return seatDetails;
	}
	
	/**
	 * Converts Account object to JSON object
	 * @param user User to be converted
	 * @return JSON object with user data
	 */
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
