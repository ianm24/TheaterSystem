package TheaterSystem;

/**
 * Used to store the necessary constants for the JSONHandler
 * @author Ian McDowell
 *
 */
public abstract class JSONConstants {
	protected static final String VENUES_FILENAME = "src/TheaterSystem/venues.json";
	protected static final String ACCOUNTS_FILENAME = "src/TheaterSystem/accounts.json";
	protected static final String VENUE_NAME = "venueName";
	protected static final String THEATERS = "theaters";
	protected static final String SHOWS = "shows";
	protected static final int MOVIES = 0;
	protected static final int PLAYS = 1;
	protected static final int CONCERTS = 2;
	protected static final String EVENT_START_TIME = "startTime";
	protected static final String EVENT_END_TIME = "endTime";
	protected static final String EVENT_NAME = "name";
	protected static final String EVENT_DESCRIPTION = "description";
	protected static final String EVENT_AGE_RATING = "ageRating";
	protected static final String EVENT_USER_RATING = "userRating";
	protected static final String EVENT_PRICE = "price";
	protected static final String EVENT_GENRE = "genre";
	protected static final String EVENT_REVIEWS = "reviews";
	protected static final String EVENT_ACTORS = "actors";
	protected static final String EVENT_PRODUCERS = "producers";
	protected static final String MOVIE_DIRECTORS = "directors";
	protected static final String PLAY_PLAYWRITES = "playwrites";
	protected static final String CONCERT_PERFORMERS = "performers";
	protected static final String THEATER_SEATS = "seats";
	protected static final String SEATS_HANDICAPABLE = "isHandicapable";
	protected static final String SEATS_RESERVED = "isReserved";
	protected static final String SEATS_ROW = "row";
	protected static final String SEATS_COL = "col";
	protected static final String USER_FIRST_NAME = "firstName";
	protected static final String USER_LAST_NAME = "lastName";
	protected static final String USER_PASSWORD = "password";
	protected static final String USER_PHONE_NUMBER = "phoneNumber";
	protected static final String USER_IS_EMPLOYEE = "isEmployee";
	protected static final String USER_IS_ADMIN = "isAdmin";
}
