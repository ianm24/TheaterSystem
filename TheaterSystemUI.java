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
        ts.saveToJSON();
        System.out.print("Thank you for using the Theater System.");
    }
    
    private void checkAccountType(String account) {
      switch(account) {
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
          System.out.println("Something has gone wrong. That account does not exist.");
          return;
      }
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
	  tsUI.checkAccountType(ts.login(firstName, lastName, password));
	} 

	private void createAccount() {
	  //String firstName, String lastName, String phoneNumber, String password,
	  //boolean isEmployee,boolean isAdmin
	  boolean employeeLoop = true;
	  boolean adminLoop = true;
	  boolean isEmployee = false, isAdmin = false;
	  System.out.println("Enter your first name:");
      String firstName = key.next();
      System.out.println("Enter your last name:");
      String lastName = key.next();
      System.out.println("Enter your password:");
      String password = key.next();
      System.out.println("Enter your phone number:");
      String phoneNumber = key.next();
      while (employeeLoop == true) {
        System.out.println("Are you an Employee? Enter true or false:");
        String eStatus = key.next();
        if(eStatus.equalsIgnoreCase("true")) {
         isEmployee = true;
         employeeLoop = false;
        }
        else if(eStatus.equalsIgnoreCase("false")) {
          isEmployee = false;
          employeeLoop = false;
        }
        else {
          System.out.println("Invalid Input.");
        }
      }
      while (adminLoop == true) {
        System.out.println("Are you an Admin? Enter true or false:");
        String aStatus = key.next();
        if(aStatus.equalsIgnoreCase("true")) {
         isAdmin = true;
         adminLoop = false;
        }
        else if(aStatus.equalsIgnoreCase("false")) {
          isAdmin = false;
          adminLoop = false;
        }
        else {
          System.out.println("Invalid Input.");
        }
      }
      ts.createAccount(firstName, lastName, phoneNumber, password, isEmployee, isAdmin);
      tsUI.checkAccountType(ts.login(firstName, lastName, password));
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


