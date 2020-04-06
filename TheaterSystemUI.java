package TheaterSystem;
import java.util.ArrayList;
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
            tsUI.getRefund();
            break;
            
          case 8:
           tsUI.leaveReview();
            break;
            
          case 9:
            tsUI.addEvent();
            break;
            
          case 10:
            tsUI.removeEvent();
            break;
            
          case 11:
            quit = true;
            break;
          default:
            System.out.println("Invalid Selection");
            break;
        }
      }
	  
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
            tsUI.removeEvent();
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
		System.out.println("What is the name of the show you would like to search for?");
		String showName = key.nextLine();
		ArrayList<Show> results = ts.searchShowName(showName);
		for(Show show : results) {
			System.out.println(show.toString());
		}
	   
	}

	private void searchByGenre() {
	  
	}

	private void searchByRating() {

	}

	private void addEvent() {
	  System.out.println("What type of event would you like to add? \n1. Movie \n2. Play \n3. Concert");
	  boolean quit = false;
	  int response = key.nextInt();
	  key.nextLine();
	  
	  
	  while (quit != true) {
	    switch (response) {
	      case 1:
	        System.out.println("Please enter the movie's name:");
	        String name = key.nextLine();
	        
	        System.out.println("Please enter an appropriate description:");
	        String description = key.nextLine();
	        
	        System.out.println("Please enter the ageRating of the movie choose from: G, PG, PG-13, R");
	        String ageRating = null;
	        boolean ageLoop = true;
	       
	        while (ageLoop != false) {
	          ageRating  = key.nextLine();
	          
	          if (ageRating.equals("G") || ageRating.equals("PG") || ageRating.equals("PG-13") || ageRating.equals("R")) {
	            ageLoop = false;
	          }
	          
	          System.out.println("Please enter a valid response: G, PG, PG-13, R");
	        }
	        
	        System.out.println("Please enter the price for the tickets:");
	        double price = key.nextDouble();
	        key.nextLine();
	        
	        System.out.println("Please enter the genre of the movie: Action, Adventure, Childrens, Comedy, Drama, Family, Horror, and Romance");
	        String genre = null;
	        boolean genreLoop = true;
	        
	        while (genreLoop != false) {
	          genre = key.nextLine();
	          
	          if (genre.equals("Action") || genre.equals("Adventure") || genre.equals("Childrens") ||  genre.equals("Comedy") || genre.equals("Drama") ||
	              genre.equals("Family") || genre.equals("Horror") || genre.equals("Romance")) {
	                genreLoop = false;
	              } else {
	                System.out.println("Please enter one of the following genres: Action, Adventure, Childrens, Comedy, Drama, Family, Horror, and Romance");
	              }
	        }
	        
	        System.out.println("Please enter the number of actors for the movie,"
	            + "followed by all the actors for the movie:");
	        System.out.println("Enter the number of actors.");
	        int actorNum = key.nextInt();
	        key.nextLine();
	        
	        String[] actors = new String[actorNum];
	        for (int i = 0; i < actors.length; i++) {
	          System.out.println("Enter the name of the actor:");
	          actors[i] = key.nextLine();
	        }
	        
	        System.out.println("Please enter the number of producers for the movie,"
                + "followed by all the producers for the movie:");
            System.out.println("Enter the number of producers.");
            int producerNum = key.nextInt();
            key.nextLine();
            
            String[] producers = new String[producerNum];
            for (int i = 0; i < producers.length; i++) {
              System.out.println("Enter the name of the producer:");
              producers[i] = key.nextLine();
            }
            
            System.out.println("Please enter the number of directors for the movie,"
                + "followed by all the directors for the movie:");
            System.out.println("Enter the number of directors.");
            int directorNum = key.nextInt();
            key.nextLine();
            
            String[] directors = new String[directorNum];
            for (int i = 0; i < directors.length; i++) {
              System.out.println("Enter the name of the directors:");
              directors[i] = key.nextLine();
            }
	        
            System.out.println("Please enter the start time for the movie in the hh/mm AM/PM format with a space in-between the time and AM or PM:");
            boolean startLoop = true;
            String startTime = key.nextLine();
            while (startLoop != false) {
              
              
              int hour = Integer.parseInt(startTime.substring(0,1));
              int minute = Integer.parseInt(startTime.substring(3,4));
              String am_PM = startTime.substring(6,7);
              if (hour > 13 || hour < 0) {
                System.out.println("Hour invalid, please enter valid time.");
              } else if (minute >= 60 || minute < 0) {
                System.out.println("Minute invalid, please enter valid time.");
              } else if(!am_PM.equalsIgnoreCase("AM") || !am_PM.equalsIgnoreCase("PM")) {
                System.out.println("Please enter AM or PM one space after the time");
              }
              
              startLoop = false;
            }
            
            
            System.out.println("Please enter the end time for the movie:");
            boolean endLoop = true;
            String endTime = key.nextLine();
            while (endLoop != false) {
              
              
              int hour = Integer.parseInt(endTime.substring(0,1));
              int minute = Integer.parseInt(endTime.substring(3,4));
              String am_PM = endTime.substring(6,7);
              if (hour > 13 || hour < 0) {
                System.out.println("Hour invalid, please enter valid time.");
              } else if (minute >= 60 || minute < 0) {
                System.out.println("Minute invalid, please enter valid time.");
              } else if(!am_PM.equalsIgnoreCase("AM") || !am_PM.equalsIgnoreCase("PM")) {
                System.out.println("Please enter AM or PM one space after the time.");
              }
              
              endLoop = false;
            }
            
            System.out.println("Enter the venue that the movie is going to be shown at:");
            String venueName = key.nextLine();
            Venue findVenue = new Venue(venueName);
            
            for (Venue findVenue : ts.venues) {
              if (findVenue.getName() =)
            }
	    }
	  }
	  
	  ts.addEvent(theater, show);
	}
	
	private void removeEvent() {
	  
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

	private void displaySeats(Theater theater) {
		ts.displaySeats(theater);
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


