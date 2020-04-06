package TheaterSystem;
import java.util.Scanner;
/**
 * This is the class that displays the system to the user
 * 
 * @author Rebekah Soard, Ian McDowell, Miles Littlejohn
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
	         + "\n2. Create an account\n3. Continue as Guest\n4. Quit");
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
	  while(quit == false) {
	    System.out.println("Welcome Guest, please select from the following options:\n1. Display the list of events"
	      + "\n2. Search for events by name\n3. Search for events by genre\n4. Search for events by rating"
	      + "\n5. Display an event's info\n6. Purchase ticket\n7. Quit");
	    int response = key.nextInt();
        key.nextLine();
        switch (response) {
          case 1:
            tsUI.displayEventList();
            break;
          case 2:
            tsUI.searchByName();
            break;
          case 3:
            tsUI.searchByGenre();
            break;
          case 4:
            tsUI.searchByRating();
            break;
          case 5:
            tsUI.displayEventInfo();
            break;
          case 6:
            tsUI.purchaseTicket();
            break;
          case 7:
            quit = true;
            break;
          default:
            System.out.println("Invalid Selection");
            break;
        }
	  }
	}

	private void displayUser() {
      while(quit == false) {
        System.out.println("Welcome, " + ts.currentAccount.firstName + "!\nPlease select from the following options:\n1. Display the list of events"
           + "\n2. Search for events by name\n3. Search for events by genre\n4. Search for events by rating\n5. Display an event's information"
           + "\n6. Purchase ticket \n7. Get a refund \n8. Leave a review \n9. Quit");
        int response = key.nextInt();
        key.nextLine();
        switch (response) {
          case 1:
            tsUI.displayEventList();
            break;
            
          case 2:
            tsUI.searchByName();
            break;
            
          case 3:
            tsUI.searchByGenre();
            break;
            
          case 4:
            tsUI.searchByRating();
            break;
            
          case 5: 
            tsUI.displayEventInfo();
            break;
            
          case 6:
            tsUI.purchaseTicket();
            break;
            
          case 7:
            tsUI.getRefund();
            break;
            
          case 8:
            tsUI.leaveReview();
            break;
            
          case 9:
            quit = true;
            break;
            
          default:
            System.out.println("Invalid Selection");
            break;
        }
      } 
	}

	private void displayEmployee() {
<<<<<<< HEAD
	  while(quit == false) {
        System.out.println("Welcome, "+ts.currentAccount.firstName+", please select from the following "
            + "options:\n1. Display the list of events\n2. Search for events by name\n3. Search for events"
            + " by genre\n4. Search for events by rating\n5. Display an event's info\n6. Purchase ticket\n7. "
            + "Get a refund\n8. Leave a review\n9. Add a show\n10. Remove a show\n11. Quit");
        int response = key.nextInt();
        key.nextLine();
        switch (response) {
          case 1:
            tsUI.displayEventList();
            break;
          case 2:
            tsUI.searchByName();
            break;
          case 3:
            tsUI.searchByGenre();
            break;
          case 4:
            tsUI.searchByRating();
            break;
          case 5:
            tsUI.displayEventInfo();
            break;
          case 6:
            tsUI.purchaseTicket();
            break;
          case 7:
            
            break;
          case 8:
            break;
          case 9:
            break;
          case 10:
            break;
          case 11:
            quit = true;
            break;
          default:
            System.out.println("Invalid Selection");
            break;
        }
      }
=======
	  
>>>>>>> 2cc4787bd2fe56990848fb63c42f57cbe43fd273
	}

	private void displayAdmin() {
	  while(quit == false) {
        System.out.println("Welcome, Admin: " + ts.currentAccount.firstName + "!\nPlease select from the following options:\n1. Display the list of events"
           + "\n2. Search for events by name\n3. Search for events by genre\n4. Search for events by rating\n5. Display an event's information"
           + "\n6. Purchase ticket \n7. Get a refund \n8. Leave a review \n9. Remove a review \n10. Add show \n11. Remove show \n12. Quit");
        int response = key.nextInt();
        key.nextLine();
        switch (response) {
          case 1:
            tsUI.displayEventList();
            break;
            
          case 2:
            tsUI.searchByName();
            break;
            
          case 3:
            tsUI.searchByGenre();
            break;
            
          case 4:
            tsUI.searchByRating();
            break;
            
          case 5: 
            tsUI.displayEventInfo();
            break;
            
          case 6:
            tsUI.purchaseTicket();
            break;
            
          case 7:
            tsUI.getRefund();
            break;
            
          case 8:
            tsUI.leaveReview();
            break;
            
          case 9:
            tsUI.removeReview();
            break;
            
          case 10:
            tsUI.addEvent();
            break;
            
          case 11:
            tsUI.removeReview();
            break;
            
          case 12:
            quit = true;
            break;
            
          default:
            System.out.println("Invalid Selection");
            break;
        }
      } 
	}

	private void searchByName() {
	  System.out.println("Please enter the name of the show you want to find:");
	  ts.searchShowName(key.nextLine());
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
	private void displayEventInfo() {
		//System.out.println(event.toString());
	}

	private void displaySeats() {

	}

	private void purchaseTicket() {

	}
	
	private void getRefund() {
	  
	}
	
	private void leaveReview() {
	  
	}
	
	private void removeReview() {
	  
	}
}


