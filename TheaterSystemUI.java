package TheaterSystem;
import java.util.Scanner;
/**
 * This is the class that displays the system to the user
 * 
 * @author Rebekah Soard, Ian McDowell
 *
 */
public class TheaterSystemUI {
    public static void main(String[] args) {
        TheaterSystemUI tsUI = new TheaterSystemUI();
        Scanner key = new Scanner(System.in);
        boolean quit = false;
        while(quit == false) {
	    System.out.println("Welcome to the Theater System.\nPlease select from the"
	        + " following options:\n1. Login\n2. Create an account\n3. Continue as guest\n"
	        + "4. quit");
        int response = key.nextInt();
        key.nextLine();
        } 
    }
	

	//private int checkUserType() {

	//}

	private void displayMainMenu() {

	}

	private void login() {
	}

	private void createAccount() {

	}

	private void displayGuest() {

	}

	private void displayUser() {

	}

	private void displayEmployee() {

	}

	private void displayAdmin() {

	}

	private void searchByName() {

	}

	private void searchByGenre() {

	}

	private void searchByRating() {

	}

	private void addEvent() {

	}

	private void displayEventList() {

	}

	/**
	 * Displays and event's information
	 * 
	 * @param event The event to display
	 */
	private void displayEventInfo(Event event) {
		System.out.println(event.toString());
	}

	private void displaySeats() {

	}

	private void getUserInput() {

	}
}


