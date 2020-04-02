package TheaterSystem;
import java.util.Scanner;
/**
 * This is the class that displays the system to the user
 * 
 * @author Rebekah Soard, Ian McDowell
 *
 */
public class TheaterSystemUI {
  public static TheaterSystemUI tsUI = new TheaterSystemUI();
  public static TheaterSystem ts = new TheaterSystem();
  public static Scanner key = new Scanner(System.in);
  public static boolean quit = false;
    public static void main(String[] args) {
        System.out.println("Welcome to the Theater System.");
        while(quit == false) {
	      System.out.println("Please select from the following options:\n1. Login"
	         + "\n2. Create an account\n3. Continue as Guest\n4. quit");
          int response = key.nextInt();
          key.nextLine();
          switch (response) {
            case 1:
              tsUI.login();
              break;
            case 2:
              tsUI.createAccount();
              break;
            case 3:
              tsUI.displayGuest();
              break;
            case 4:
              quit = true;
              break;
            default:
              System.out.println("Invalid Selection");
              break;
          }
        } 
        System.out.print("Thank you for using the Theater System.");
    }
	
	//private void displayMainMenu() {

	//}

	private void login() {
	  System.out.println("Enter your first name:");
	  String firstName = key.next();
	  System.out.println("Enter your last name:");
	  String lastName = key.next();
	  System.out.println("Enter your password:");
	  String password = key.next();
	  String accountType = ts.login(firstName, lastName, password);
	  switch(accountType) {
	    case "User":
	      tsUI.displayUser();
	      break;
	    case "Employee":
	      tsUI.displayEmployee();
	      break;
	    case "Admin":
	      tsUI.displayAdmin();
	      break;
	    case "Fail":
	      System.out.println("That account does not exist.");
	      return;
	  }
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


