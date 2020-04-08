
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
    
    /**
     * Checks what account is currently logged in
     * @param account - The account being checked for admin, employee, user, or guest
     */
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
    
    /**
     * Logs the user into the movie system
     */
	private void login() {
	  System.out.println("Enter your first name:");
	  String firstName = key.next();
	  System.out.println("Enter your last name:");
	  String lastName = key.next();
	  System.out.println("Enter your password:");
	  String password = key.next();
	  tsUI.checkAccountType(ts.login(firstName, lastName, password));
	} 

	/**
	 * Creates one of three different accounts: User, Admin, Employee
	 */
	private void createAccount() {
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
      if(isAdmin == true && isEmployee == true) {
        System.out.println("Sorry, something has gone wrong. You cannot be both an admin and an employee.");
      }
      else {
      ts.createAccount(firstName, lastName, phoneNumber, password, isEmployee, isAdmin);
      tsUI.checkAccountType(ts.login(firstName, lastName, password));
      }
	}

	/**
	 * Displays the user-interface for guests
	 */
	private void displayGuest() {
	  System.out.println("Welcome, Guest.");
	  while(quit == false) {
	    System.out.println("Please select from the following options:\n1. Display the list of events"
	      + "\n2. Search for events by name\n3. Search for events by genre\n4. Search for events by user rating"
	      + "\n5. Search for events by age rating \n6. Purchase ticket\n7. Quit");
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
            tsUI.searchByUserRating();
            break;
            
          case 5:
            tsUI.searchByAgeRating();
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

	/**
	 * Displays the user-interface for users
	 */
	private void displayUser() {
	  System.out.println("Welcome, " + ts.currentAccount.firstName +".");
      while(quit == false) {
        System.out.println("Please select from the following options:\n1. Display the list of events"
           + "\n2. Search for events by name\n3. Search for events by genre\n4. Search for events by user rating"
           + "\n5. Search for events by age rating \n6. Purchase ticket \n7. Get a refund \n8. Leave a review \n9. Quit");
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
            tsUI.searchByAgeRating();;
            break;
            
          case 5:
            tsUI.searchByUserRating();;
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

	/**
	 * Displays the user-interface for employees
	 */
	private void displayEmployee() {
	  System.out.println("Welcome, " + ts.currentAccount.firstName +".");
	  while(quit == false) {
        System.out.println("Please select from the following "
            + "options:\n1. Display the list of events\n2. Search for events by name\n3. Search for events"
            + " by genre\n4. Search for events by user rating\n5. Search for events by age rating\n6. Purchase ticket\n7. "
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
            tsUI.searchByUserRating();
            break;
            
          case 5:
            tsUI.searchByAgeRating();
 
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

	/**
	 * Displays the user-interface for admin
	 */
	private void displayAdmin() {
	  System.out.println("Welcome, Admin: " + ts.currentAccount.firstName +".");
	  while(quit == false) {
        System.out.println("Please select from the following options:\n1. Display the list of events"
           + "\n2. Search for events by name\n3. Search for events by genre\n4. Search for events by user rating"
           + "\n5. Search for events by age rating\n6. Purchase ticket \n7. Get a refund \n8. Leave a review "
           + "\n9. Remove a review \n10. Add show \n11. Remove show \n12. Quit");
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
            tsUI.searchByUserRating();
            break;
            
          case 5:
            tsUI.searchByAgeRating();
            
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

	/**
	 * Searches for a show by name
	 */
	private void searchByName() {
		System.out.println("What is the name of the show you would like to search for?");
		String showName = key.nextLine();
		ArrayList<Show> results = ts.searchShowName(showName);
		for(Show show : results) {
			System.out.println(show.toString());
		}
	}

	/**
	 * Searches for a show by it's genre type
	 */
	private void searchByGenre() {
	     System.out.println("What is the genre of the show you would like to search for?");
	        String genre = key.nextLine();
	        ArrayList<Show> results = ts.searchGenre(genre);
	        for(Show show : results) {
	            System.out.println(show.toString());
	        }
	}

	/**
	 * Searches for a show by it's age rating
	 */
	private void searchByAgeRating() {
      System.out.println("What is the age rating of the show you would like to search for?");
      String rating = key.nextLine();
      ArrayList<Show> results = ts.searchAgeRating(rating);
      for(Show show : results) {
          System.out.println(show.toString());
      }
	}
	
	/**
     * Searches for a show by it's age rating
     */
    private void searchByUserRating() {
      System.out.println("What is the user rating of the show you would like to search for?");
      double rating = key.nextDouble();
      ArrayList<Show> results = ts.searchRating(rating);
      for(Show show : results) {
          System.out.println(show.toString());
      }
    }
	
	/**
	 * Adds a show to the theater system
	 */
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
	              } else {
	                System.out.println("Please enter a valid response: G, PG, PG-13, R");
	              }
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
	            
	            System.out.println("Please enter the start time for the movie in the hh/mm AM/PM format with a space in-between. EX: 08:30 AM");
	            boolean startLoop = true;
	            String startTime = "";
	            while (startLoop != false) {
	              startTime = key.nextLine();
	              if (startTime.length() != 8) {
	                System.out.println("Invalid time format, please try again.");
	              } else {
	                  int hour = Integer.parseInt(startTime.substring(0,2));
	                  int minute = Integer.parseInt(startTime.substring(3,5));
	                  String am_PM = startTime.substring(6,8);
	                  
	                  if (hour <= 12 && hour > -1 && minute <= 60 && minute > -1 && (am_PM.equals("AM") || am_PM.equals("PM"))) {
                        startLoop = false;
                      } else {
                        System.out.println("INVALID FORMAT");  
                      }
	              }
	            }
	            
	            System.out.println("Please enter the end time for the movie:  EX: 08:30 AM");
	            boolean endLoop = true;
	            String endTime = "";
	            while (endLoop != false) {
	              endTime = key.nextLine();
	              if (endTime.length() != 8) {
	                System.out.println("Invalid time format, please try again.");
	              } else {
	                  int hour = Integer.parseInt(endTime.substring(0,2));
	                  int minute = Integer.parseInt(endTime.substring(3,5));
	                  String am_PM = endTime.substring(6,8);
	                  if (hour <= 12 && hour > -1 && minute <= 60 && minute > -1 && (am_PM.equals("AM") || am_PM.equals("PM"))) {
	                    endLoop = false;
	                  } else {
	                    System.out.println("INVALID FORMAT");
	                  }
	              }            
	          }
	            
	            System.out.println("Enter the venue that the movie is going to be shown at:");
	            boolean venLoop = true;
	            Venue returnVenue = new Venue("");
	            
	            while (venLoop != false) {
	             String venueName = key.nextLine();
	             
	             for (int i = 0; i < ts.venues.size(); i++) {
	               if (ts.venues.get(i).getName().equalsIgnoreCase(venueName)) {
	                 returnVenue = ts.venues.get(i);
	                 venLoop = false;
	               } else {
	                 System.out.println("That venue does not exist, please enter another venue name");
	               }
	             }
	           }
	            
	            System.out.println("Enter the number of the theater that the movie is going to be shown at:");
	            boolean theaLoop = true;
	            int theaterNum = 0;
	            while(theaLoop != false) {
	              theaterNum = key.nextInt();
	              System.out.println(theaterNum);
	              if (returnVenue.theaters.get(theaterNum -1) == null) {
	              System.out.println("Sorry that theater does not exist, please enter a valid theater.");
	            } else {
	              theaLoop = false;
	            }
	           }
	            
	          Movie returnMovie = new Movie (returnVenue, returnVenue.theaters.get(theaterNum-1), startTime, endTime, 
	                name, description, ageRating, price, genre, actors, producers, directors);
	            ts.addEvent(returnVenue.theaters.get(theaterNum-1), returnMovie);
	            System.out.println("Successfully Added Event!");
	            quit = true;
	            break;
	            
	          case 2:
	            System.out.println("Please enter the play's name:");
                String pName = key.nextLine();
                
                System.out.println("Please enter an appropriate description:");
                String pDescription = key.nextLine();
                
                System.out.println("Please enter the ageRating of the play choose from: G, PG, PG-13, R");
                String pAgeRating = null;
                boolean pAgeLoop = true;
               
                while (pAgeLoop != false) {
                  pAgeRating  = key.nextLine();
                  
                  if (pAgeRating.equals("G") || pAgeRating.equals("PG") || pAgeRating.equals("PG-13") || pAgeRating.equals("R")) {
                    pAgeLoop = false;
                  } else {
                    System.out.println("Please enter a valid response: G, PG, PG-13, R");
                  }
                }
                
                System.out.println("Please enter the price for the tickets:");
                double pPrice = key.nextDouble();
                key.nextLine();
                
                System.out.println("Please enter the genre of the play: American, Alternative, Classical, Comedy, Drama, French, Historical, and Romance");
                String pGenre = null;
                boolean pGenreLoop = true;
                
                while (pGenreLoop != false) {
                  pGenre = key.nextLine();
                  
                  if (pGenre.equals("American") || pGenre.equals("Alternative") || pGenre.equals("Classical") ||  pGenre.equals("Comedy") || pGenre.equals("Drama") ||
                      pGenre.equals("French") || pGenre.equals("Historical") || pGenre.equals("Romance")) {
                    pGenreLoop = false;
                      } else {
                        System.out.println("Please enter one of the following genres: American, Alternative, Classical, Comedy, Drama, French, Historical, and Romance");
                      }
                }
                
                System.out.println("Please enter the number of actors for the play,"
                    + "followed by all the actors for the play:");
                System.out.println("Enter the number of actors.");
                int paActorNum = key.nextInt();
                key.nextLine();
                
                String[] pActors = new String[paActorNum];
                for (int i = 0; i < pActors.length; i++) {
                  System.out.println("Enter the name of the actor:");
                  pActors[i] = key.nextLine();
                }
                
                System.out.println("Please enter the number of producers for the play,"
                    + "followed by all the producers for the play:");
                System.out.println("Enter the number of producers.");
                int pProducerNum = key.nextInt();
                key.nextLine();
                
                String[] pProducers = new String[pProducerNum];
                for (int i = 0; i < pProducers.length; i++) {
                  System.out.println("Enter the name of the producer:");
                  pProducers[i] = key.nextLine();
                }
                
                System.out.println("Please enter the number of playwrites for the play,"
                    + "followed by all the playwrites for the play:");
                System.out.println("Enter the number of playwrites.");
                int playwriteNum = key.nextInt();
                key.nextLine();
                
                String[] playwriters = new String[playwriteNum];
                for (int i = 0; i < playwriters.length; i++) {
                  System.out.println("Enter the name of the directors:");
                  playwriters[i] = key.nextLine();
                }
                
                System.out.println("Please enter the start time for the play in the hh/mm AM/PM format with a space in-between. EX: 08:30 AM");
                boolean pStartLoop = true;
                String pStartTime = "";
                while (pStartLoop != false) {
                  pStartTime = key.nextLine();
                  if (pStartTime.length() != 8) {
                    System.out.println("Invalid time format, please try again.");
                  } else {
                      int hour = Integer.parseInt(pStartTime.substring(0,2));
                      int minute = Integer.parseInt(pStartTime.substring(3,5));
                      String am_PM = pStartTime.substring(6,8);
                      
                      if (hour <= 12 && hour > -1 && minute <= 60 && minute > -1 && (am_PM.equalsIgnoreCase("AM") || am_PM.equalsIgnoreCase("PM"))) {
                        pStartLoop = false;
                      } else {
                        System.out.println("INVALID FORMAT");  
                      }
                  }
                }
                
                System.out.println("Please enter the end time for the play in the hh/mm AM/PM format with a space in-between. EX: 08:30 AM");
                boolean pEndLoop = true;
                String pEndTime = "";
                while (pEndLoop != false) {
                  pEndTime = key.nextLine();
                  if (pEndTime.length() != 8) {
                    System.out.println("Invalid time format, please try again.");
                  } else {
                      int hour = Integer.parseInt(pEndTime.substring(0,2));
                      int minute = Integer.parseInt(pEndTime.substring(3,5));
                      String am_PM = pEndTime.substring(6,8);
                      
                      if (hour <= 12 && hour > -1 && minute <= 60 && minute > -1 && (am_PM.equals("AM") || am_PM.equals("PM"))) {
                        pEndLoop = false;
                      } else {
                        System.out.println("INVALID FORMAT"); 
                      }
                  }
                }
                
                System.out.println("Enter the venue that the play is going to be shown at:");
                boolean pVenLoop = true;
                Venue pReturnVenue = new Venue("");
                
                while (pVenLoop != false) {
                 String venueName = key.nextLine();
                 
                 for (int i = 0; i < ts.venues.size(); i++) {
                   if (ts.venues.get(i).getName().equalsIgnoreCase(venueName)) {
                     pReturnVenue = ts.venues.get(i);
                     pVenLoop = false;
                   } else {
                     System.out.println("That venue does not exist, please enter another venue name");
                   }
                 }
               }
                
                System.out.println("Enter the number of the theater that the play is going to be shown at:");
                boolean pTheaLoop = true;
                int pTheaterNum = 0;
                while(pTheaLoop != false) {
                  theaterNum = key.nextInt();
                  if (pReturnVenue.theaters.get(pTheaterNum -1) == null) {
                  System.out.println("Sorry that theater does not exist, please enter a valid theater.");
                } else {
                  pTheaLoop = false;
                }
               }
                
              Play returnPlay = new Play (pReturnVenue, pReturnVenue.theaters.get(pTheaterNum-1), pStartTime, pEndTime, 
                    pName, pDescription, pAgeRating, pPrice, pGenre, pActors, pProducers, playwriters);
                ts.addEvent(pReturnVenue.theaters.get(pTheaterNum-1), returnPlay);
                System.out.println("Successfully Added Event!");
                quit = true;
                break;
                
	          case 3:
	            System.out.println("Please enter the concert's name:");
                String cName = key.nextLine();
                
                System.out.println("Please enter an appropriate description:");
                String cDescription = key.nextLine();
                
                System.out.println("Please enter the ageRating of the concert choose from: G, PG, PG-13, R");
                String cAgeRating = null;
                boolean cAgeLoop = true;
               
                while (cAgeLoop != false) {
                  cAgeRating  = key.nextLine();
                  
                  if (cAgeRating.equals("G") || cAgeRating.equals("PG") || cAgeRating.equals("PG-13") || cAgeRating.equals("R")) {
                    cAgeLoop = false;
                  } else {
                    System.out.println("Please enter a valid response: G, PG, PG-13, R");
                  }
                }
                
                System.out.println("Please enter the price for the tickets:");
                double cPrice = key.nextDouble();
                key.nextLine();
                
                System.out.println("Please enter the genre of the concert: Rock, Jazz, Metal, Country, Rap, R&B, Alternative, and J-Pop");
                String cGenre = null;
                boolean cGenreLoop = true;
                
                while (cGenreLoop != false) {
                  cGenre = key.nextLine();
                  
                  if (cGenre.equals("Rock") || cGenre.equals("Jazz") || cGenre.equals("Metal") ||  cGenre.equals("Country") || cGenre.equals("Rap") ||
                      cGenre.equals("R&B") || cGenre.equals("Alternative") || cGenre.equals("J-Pop")) {
                    cGenreLoop = false;
                      } else {
                        System.out.println("Please enter one of the following genres: Rock, Jazz, Metal, Country, Rap, R&B, Alternative, and J-Pop");
                      }
                }
                
                System.out.println("Please enter the number of performers for the concert,"
                    + "followed by all the performers for the concert:");
                System.out.println("Enter the number of performers.");
                int performerNum = key.nextInt();
                key.nextLine();
                
                String[] performers = new String[performerNum];
                for (int i = 0; i < performers.length; i++) {
                  System.out.println("Enter the name of the performer:");
                  performers[i] = key.nextLine();
                }
                
                System.out.println("Please enter the start time for the concert in the hh/mm AM/PM format with a space in-between. EX: 08:30 AM");
                boolean cStartLoop = true;
                String cStartTime = "";
                while (cStartLoop != false) {
                  cStartTime = key.nextLine();
                  if (cStartTime.length() != 8) {
                    System.out.println("Invalid time format, please try again.");
                  } else {
                      int hour = Integer.parseInt(cStartTime.substring(0,2));
                      int minute = Integer.parseInt(cStartTime.substring(3,5));
                      String am_PM = cStartTime.substring(6,8);
                      if (hour <= 12 && hour > -1 && minute <= 60 && minute > -1 && (am_PM.equals("AM") || am_PM.equals("PM"))) {
                        cStartLoop = false;
                      } else {
                        System.out.println("INVALID FORMAT");
                      }
                  }
                }
                
                System.out.println("Please enter the end time for the concert in the hh/mm AM/PM format with a space in-between. EX: 08:30 AM");
                boolean cEndLoop = true;
                String cEndTime = "";
                while (cEndLoop != false) {
                  cEndTime = key.nextLine();
                  if (cEndTime.length() != 8) {
                    System.out.println("Invalid time format, please try again.");
                  } else {
                      int hour = Integer.parseInt(cEndTime.substring(0,2));
                      int minute = Integer.parseInt(cEndTime.substring(3,5));
                      String am_PM = cEndTime.substring(6,8);
                      if (hour <= 12 && hour > -1 && minute <= 60 && minute > -1 && (am_PM.equals("AM") || am_PM.equals("PM"))) {
                        cEndLoop = false;
                      } else {
                        System.out.println("INVALID FORMAT");
                      }     
                  }
                }
                
                System.out.println("Enter the venue that the concert is going to be shown at:");
                boolean cVenLoop = true;
                Venue cReturnVenue = new Venue("");
                
                while (cVenLoop != false) {
                 String venueName = key.nextLine();
                 
                 for (int i = 0; i < ts.venues.size(); i++) {
                   if (ts.venues.get(i).getName().equalsIgnoreCase(venueName)) {
                     cReturnVenue = ts.venues.get(i);
                     cVenLoop = false;
                   } else {
                     System.out.println("That venue does not exist, please enter another venue name");
                   }
                 }
               }
                
                System.out.println("Enter the number of the theater that the play is going to be shown at:");
                boolean cTheaLoop = true;
                int cTheaterNum = 0;
                while(cTheaLoop != false) {
                  theaterNum = key.nextInt();
                  if (cReturnVenue.theaters.get(cTheaterNum -1) == null) {
                  System.out.println("Sorry that theater does not exist, please enter a valid theater.");
                } else {
                  cTheaLoop = false;
                }
               }
                
                Concert returnConcert= new Concert (cReturnVenue, cReturnVenue.theaters.get(cTheaterNum-1), cStartTime, cEndTime, 
                    cName, cDescription, cAgeRating, cPrice, cGenre, performers);
                ts.addEvent(cReturnVenue.theaters.get(cTheaterNum-1), returnConcert);
                System.out.println("Successfully Added Event!");
                quit = true;
                break;
                
                default:
                  System.out.println("Invalid Selection");
                  break;                
	      }
	     } 
	    }
	 
	/**
	 * Removes a show from the theater system
	 */
	private void removeEvent() {
	  System.out.println("Please enter the name of the event you would like to remove");
	  String input = key.nextLine();
	  ArrayList<Show> results = ts.searchShowName(input);
	  for(int i = 1; i <= results.size(); i++) {
		  System.out.println("" + i + results.get(i-1).toString());
	  }
	  System.out.println("Please enter the number of the event you would like to remove");
	  int deleteNum = key.nextInt();
	  key.hasNextLine();
	  results.get(deleteNum-1).theater.shows.remove(results.get(deleteNum-1));
	  System.out.println("Show deleted");
	}
/**
 * This method displays the list of all the events
 */
	private void displayEventList() {
	   for (Venue venue : ts.venues) {
        for (Theater theater : venue.theaters) {
          for (Show show : theater.shows) {
               
              System.out.println(show.name+"\n"); 
          }
        }
	  }	  
	}
  /**
   * This method takes in a theater and calls the displaySeats method in the TheaterSystem class
   * @param theater
   */
	private void displaySeats(Theater theater) {
		ts.displaySeats(theater);
	}
	/**
	 * This method takes in user input and allows the user to purchase a ticket for a specific seat or any untaken seat,
	 * calling the purchaseTicket method in the TheaterSystem class
	 */
	private void purchaseTicket() {
	  System.out.println("What is the name of the show you would like to purchase a ticket for?");
      String showName = key.nextLine();
      ArrayList<Show> results = ts.searchShowName(showName);
      Show show;
      for(Show s : results) {
        show = s;
        System.out.println("Would you like to purchase a specific seat? Enter yes or no:");
        String response = key.nextLine();
        if (response.equalsIgnoreCase("yes")) {
          System.out.println("Enter the letter of the seat you would like:");
          char row = key.nextLine().charAt(0);
          System.out.println("Enter the number of the column of the seat you would like:");
          int col = key.nextInt();
          System.out.println(ts.purchaseTicket(show, row, col));
        }
        else if (response.equalsIgnoreCase("no")) {
          System.out.println(ts.purchaseTicket(show));
        }
        else {
          System.out.println("Incorrect input, ticket purchasing cancelled.");
        }
      }
	}
	/**
	 * This method allows the user to get a ticket refunded for a specific show
	 */
	private void getRefund() {
	  System.out.println("What is the name of the show you would like to refund a ticket for?");
      String showName = key.nextLine();
      ArrayList<Show> results = ts.searchShowName(showName);
      Show show;
      for(Show s : results) {
        show = s;
        System.out.println(ts.refundTicket(show));
      }
	}
	
	/**
	 * Allows user to leave a review
	 */
	private void leaveReview() {
		System.out.println("What is the name of the event would you like to leave a review for?");
		boolean quit = false;
		Show currShow = null;
		while (!quit) {
			String showName = key.nextLine();
			ArrayList<Show> results = ts.searchShowName(showName);
			for(Show show : results) {
				if(show.name.equalsIgnoreCase(showName)) {
					currShow = show;
					quit = true;
				} else {
					System.out.println("That is not the name of an even stored in the system, please enter a valid event name.");
				}
			}
		}
		quit = false;
		System.out.println("Please enter a rating out of 10:");
		double rating = key.nextDouble();
		while(!quit) {
			rating = Math.round(rating*10);
			rating = rating / 10;
			if(rating <= 10 && rating >= 0) {
				quit = true;
			} else {
				System.out.println("Make sure your rating is between 0 and 10");
			}
		}
		key.nextLine();
		System.out.println("Please enter a review:");
		String review = key.nextLine();
		currShow.addRating(rating, review);
		System.out.println("Rating has been added! Thanks for your feedback!");
	}
	/**
	 * This method takes in user input to remove a review, calling on the deleteReview method in the TheaterSystem class
	 */
	private void removeReview() {
	  System.out.println("What is the name of the event would you like to remove the review of?");
      boolean quit = false;
      Show currShow = null;
      while (!quit) {
          String showName = key.nextLine();
          ArrayList<Show> results = ts.searchShowName(showName);
          for(Show show : results) {
              if(show.name.equalsIgnoreCase(showName)) {
                  currShow = show;
                  quit = true;
              } else {
                  System.out.println("That is not the name of an even stored in the system, please enter a valid event name.");
              }
          }
      }
      quit = false;
      System.out.println("Please enter the rating from the review you want to remove:");
      double rating = key.nextDouble();
      while(!quit) {
          rating = Math.round(rating*10);
          rating = rating / 10;
          if(rating <= 10 && rating >= 0) {
              quit = true;
          } else {
              System.out.println("Make sure the rating entered is correct (between 0 and 10)");
          }
      }
      key.hasNextLine();
      System.out.println("Enter the text of the review you want to remove word for word:");
      String review = key.nextLine();
      ts.deleteReview(rating, review, currShow);
	}
}



