package TheaterSystem;

import java.util.ArrayList;
import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Used to import/export data to/from the Theater System
 * @author Ian McDowell
 *
 */
public class JSONHandler {
	private static final String VENUES_FILENAME = "venues.json";
	private static final String ACCOUNTS_FILENAME = "accounts.json";
	
	public ArrayList<Venue> loadVenues() {
		ArrayList<Venue> venues = new ArrayList<Venue>();
		try {
			FileReader reader = new FileReader(ACCOUNTS_FILENAME);
			JSONParser parser = new JSONParser();
			JSONArray venuesJSON = (JSONArray)new JSONParser().parse(reader);
			
			for(int i = 0; i < venuesJSON.size(); i++) {
				JSONObject JSONVenue = (JSONObject)venuesJSON.get(i);
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
