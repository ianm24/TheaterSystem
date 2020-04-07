package TheaterSystem;

import java.util.ArrayList;
import java.io.File;
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
			if(!new File(VENUES_FILENAME).exists()) {
				new FileWriter(VENUES_FILENAME).flush();
				return venues;
			}
			FileReader reader = new FileReader(VENUES_FILENAME);
			JSONArray JSONVenues = (JSONArray)new JSONParser().parse(reader);
			for(int i = 0; i < JSONVenues.size(); i++) {
				JSONObject JSONVenue = (JSONObject)JSONVenues.get(i);
				String venueName = (String)JSONVenue.get(VENUE_NAME);
				System.out.println(venueName);
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
						String row = (String)JSONSeat.get(SEATS_ROW);
						char rowChar = (char)row.charAt(0);
						long col = (long)JSONSeat.get(SEATS_COL);
						int colInt = Math.toIntExact(col);
						Seat seat = new Seat(isHandicapable,rowChar,colInt);
						seat.setReserved(isReserved);
						seats.add(seat);
					}
					venue.addTheater(seats);
					JSONArray JSONShows = (JSONArray)JSONTheater.get(SHOWS);
					ArrayList<Show> shows = new ArrayList<Show>();
					
					JSONArray JSONMovies = (JSONArray)JSONShows.get(MOVIES);
					for(int k = 0; k < JSONMovies.size(); k++) {
						JSONObject JSONMovie = (JSONObject)JSONMovies.get(k);
						String startTime = (String)JSONMovie.get(EVENT_START_TIME);
						String endTime = (String)JSONMovie.get(EVENT_END_TIME);
						String name = (String)JSONMovie.get(EVENT_NAME);
						String description = (String)JSONMovie.get(EVENT_DESCRIPTION);
						String ageRating = (String)JSONMovie.get(EVENT_AGE_RATING);
						JSONArray userRatingJSON = (JSONArray)JSONMovie.get(EVENT_USER_RATING);
						double[] userRating = new double[userRatingJSON.size()];
						for(int m = 0; m < userRatingJSON.size(); m++) {
							userRating[m] = (double)userRatingJSON.get(m);
						}
						double price = (double)JSONMovie.get(EVENT_PRICE);
						String genre = (String)JSONMovie.get(EVENT_GENRE);
						JSONArray reviewsJSON = (JSONArray)JSONMovie.get(EVENT_REVIEWS);
						String[] reviews = new String[reviewsJSON.size()];
						for(int m = 0; m < reviewsJSON.size(); m++) {
							reviews[m] = (String)reviewsJSON.get(m);
						}
						JSONArray actorsJSON = (JSONArray)JSONMovie.get(EVENT_ACTORS);
						String[] actors = new String[actorsJSON.size()];
						for(int m = 0; m < actorsJSON.size(); m++) {
							actors[m] = (String)actorsJSON.get(m);
						}
						JSONArray producersJSON = (JSONArray)JSONMovie.get(EVENT_PRODUCERS);
						String[] producers = new String[producersJSON.size()];
						for(int m = 0; m < producersJSON.size(); m++) {
							producers[m] = (String)producersJSON.get(m);
						}
						JSONArray directorsJSON = (JSONArray)JSONMovie.get(MOVIE_DIRECTORS);
						String[] directors = new String[directorsJSON.size()];
						for(int m = 0; m < directorsJSON.size(); m++) {
							directors[m] = (String)directorsJSON.get(m);
						}
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
						String ageRating = (String)JSONPlay.get(EVENT_AGE_RATING);
						JSONArray userRatingJSON = (JSONArray)JSONPlay.get(EVENT_USER_RATING);
						double[] userRating = new double[userRatingJSON.size()];
						for(int m = 0; m < userRatingJSON.size(); m++) {
							userRating[m] = (double)userRatingJSON.get(m);
						}
						double price = (double)JSONPlay.get(EVENT_PRICE);
						String genre = (String)JSONPlay.get(EVENT_GENRE);
						JSONArray reviewsJSON = (JSONArray)JSONPlay.get(EVENT_REVIEWS);
						String[] reviews = new String[reviewsJSON.size()];
						for(int m = 0; m < reviewsJSON.size(); m++) {
							reviews[m] = (String)reviewsJSON.get(m);
						}
						JSONArray actorsJSON = (JSONArray)JSONPlay.get(EVENT_ACTORS);
						String[] actors = new String[actorsJSON.size()];
						for(int m = 0; m < actorsJSON.size(); m++) {
							actors[m] = (String)actorsJSON.get(m);
						}
						JSONArray producersJSON = (JSONArray)JSONPlay.get(EVENT_PRODUCERS);
						String[] producers = new String[producersJSON.size()];
						for(int m = 0; m < producersJSON.size(); m++) {
							producers[m] = (String)producersJSON.get(m);
						}
						JSONArray playwritesJSON = (JSONArray)JSONPlay.get(PLAY_PLAYWRITES);
						String[] playwrites = new String[producersJSON.size()];
						for(int m = 0; m < playwritesJSON.size(); m++) {
							playwrites[m] = (String)playwritesJSON.get(m);
						}
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
						String ageRating = (String)JSONConcert.get(EVENT_AGE_RATING);
						JSONArray userRatingJSON = (JSONArray)JSONConcert.get(EVENT_USER_RATING);
						double[] userRating = new double[userRatingJSON.size()];
						for(int m = 0; m < userRatingJSON.size(); m++) {
							userRating[m] = (double)userRatingJSON.get(m);
						}
						double price = (double)JSONConcert.get(EVENT_PRICE);
						String genre = (String)JSONConcert.get(EVENT_GENRE);
						JSONArray reviewsJSON = (JSONArray)JSONConcert.get(EVENT_REVIEWS);
						String[] reviews = new String[reviewsJSON.size()];
						for(int m = 0; m < reviewsJSON.size(); m++) {
							reviews[m] = (String)reviewsJSON.get(m);
						}
						JSONArray performersJSON = (JSONArray)JSONConcert.get(CONCERT_PERFORMERS);
						String[] performers = new String[performersJSON.size()];
						for(int m = 0; m < performersJSON.size(); m++) {
							performers[m] = (String)performersJSON.get(m);
						}
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
			if(!new File(ACCOUNTS_FILENAME).exists()) {
				new FileWriter(ACCOUNTS_FILENAME).flush();
				return users;
			}
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
			seats.add(getSeatJSON(theater.seats.get(i)));
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
		if(show.userRating == null) {
			showDetails.put(EVENT_USER_RATING, new JSONArray());
		} else {
			JSONArray userRating = new JSONArray();
			for(int i = 0; i < show.userRating.size(); i++) {
				userRating.add(show.userRating.get(i));
			}
			showDetails.put(EVENT_USER_RATING, userRating);
		}
		showDetails.put(EVENT_PRICE, show.price);
		showDetails.put(EVENT_GENRE, show.genre);
		if(show.reviews == null) {
			showDetails.put(EVENT_REVIEWS, new JSONArray());
		} else {
			JSONArray reviews = new JSONArray();
			for(int i = 0; i < show.reviews.size(); i++) {
				reviews.add(show.reviews.get(i));
			}
			showDetails.put(EVENT_REVIEWS, reviews);
		}
		if(show.getClass().getName().contains("Movie")) {
			Movie movie = (Movie) show;
			JSONArray actors = new JSONArray();
			for(int i = 0; i < movie.actors.length; i++) {
				actors.add(movie.actors[i]);
			}
			showDetails.put(EVENT_ACTORS, actors);
			JSONArray producers = new JSONArray();
			for(int i = 0; i < movie.producers.length; i++) {
				producers.add(movie.producers[i]);
			}
			showDetails.put(EVENT_PRODUCERS, producers);
			JSONArray directors = new JSONArray();
			for(int i = 0; i < movie.directors.length; i++) {
				directors.add(movie.directors[i]);
			}
			showDetails.put(MOVIE_DIRECTORS, directors);
		} else if(show.getClass().getName().contains("Play")) {
			Play play = (Play) show;
			JSONArray actors = new JSONArray();
			for(int i = 0; i < play.actors.length; i++) {
				actors.add(play.actors[i]);
			}
			showDetails.put(EVENT_ACTORS, actors);
			JSONArray producers = new JSONArray();
			for(int i = 0; i < play.producers.length; i++) {
				producers.add(play.producers[i]);
			}
			showDetails.put(EVENT_PRODUCERS, producers);
			JSONArray playwrites = new JSONArray();
			for(int i = 0; i < play.playwrites.length; i++) {
				playwrites.add(play.playwrites[i]);
			}
			showDetails.put(PLAY_PLAYWRITES, play.playwrites);
		} else if(show.getClass().getName().contains("Concert")) {
			Concert concert = (Concert) show;
			JSONArray performers = new JSONArray();
			for(int i = 0; i < concert.performers.length; i++) {
				performers.add(concert.performers[i]);
			}
			showDetails.put(CONCERT_PERFORMERS, performers);
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
		String row = String.valueOf(seat.row);
		seatDetails.put(SEATS_ROW, row);
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
