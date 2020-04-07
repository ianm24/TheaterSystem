
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
	  System.out.println("Welcome, Guest.");
	  while(quit == false) {
	    System.out.println("Please select from the following options:\n1. Display the list of events"
	      + "\n2. Search for events by name\n3. Search for events by genre\n4. Search for events by rating"
	      + "\n5. Purchase ticket\n6. Quit");
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
            tsUI.purchaseTicket();
            break;
            
          case 6:
            quit = true;
            break;
            
          default:
            System.out.println("Invalid Selection");
            break;
        }
	  }
	}

	private void displayUser() {
	  System.out.println("Welcome, " + ts.currentAccount.firstName +".");
      while(quit == false) {
        System.out.println("Please select from the following options:\n1. Display the list of events"
           + "\n2. Search for events by name\n3. Search for events by genre\n4. Search for events by rating"
           + "\n5. Purchase ticket \n6. Get a refund \n7. Leave a review \n8. Quit");
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
            tsUI.purchaseTicket();
            break;
            
          case 6:
            tsUI.getRefund();
            break;
            
          case 7:
            tsUI.leaveReview();
            break;
            
          case 8:
            quit = true;
            break;
            
          default:
            System.out.println("Invalid Selection");
            break;
        }
      } 
	}

	private void displayEmployee() {
	  System.out.println("Welcome, " + ts.currentAccount.firstName +".");
	  while(quit == false) {
        System.out.println("Please select from the following "
            + "options:\n1. Display the list of events\n2. Search for events by name\n3. Search for events"
            + " by genre\n4. Search for events by rating\n5. Purchase ticket\n6. "
            + "Get a refund\n7. Leave a review\n8. Add a show\n9. Remove a show\n10. Quit");
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
            tsUI.purchaseTicket();
            break;
            
          case 6:
            tsUI.getRefund();
            break;
            
          case 7:
           tsUI.leaveReview();
            break;
            
          case 8:
            tsUI.addEvent();
            break;
            
          case 9:
            tsUI.removeEvent();
            break;
            
          case 10:
            quit = true;
            break;
          default:
            System.out.println("Invalid Selection");
            break;
        }
      }
	  
	}

	private void displayAdmin() {
	  System.out.println("Welcome, Admin: " + ts.currentAccount.firstName +".");
	  while(quit == false) {
        System.out.println("Please select from the following options:\n1. Display the list of events"
           + "\n2. Search for events by name\n3. Search for events by genre\n4. Search for events by rating"
           + "\n5. Purchase ticket \n6. Get a refund \n7. Leave a review \n8. Remove a review \n9. Add show \n10. Remove show \n11. Quit");
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
            tsUI.purchaseTicket();
            break;
            
          case 6:
            tsUI.getRefund();
            break;
            
          case 7:
            tsUI.leaveReview();
            break;
            
          case 8:
            tsUI.removeReview();
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

	private void searchByName() {
		System.out.println("What is the name of the show you would like to search for?");
		String showName = key.nextLine();
		ArrayList<Show> results = ts.searchShowName(showName);
		for(Show show : results) {
			System.out.println(show.toString());
		}
	}

	private void searchByGenre() {
	     System.out.println("What is the genre of the show you would like to search for?");
	        String genre = key.nextLine();
	        ArrayList<Show> results = ts.searchGenre(genre);
	        for(Show show : results) {
	            System.out.println(show.toString());
	        }
	}

	private void searchByRating() {
      System.out.println("What is the rating of the show you would like to search for?");
      String rating = key.nextLine();
      ArrayList<Show> results = ts.searchGenre(rating);
      for(Show show : results) {
          System.out.println(show.toString());
      }
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
	              if (returnVenue.theaters.get(theaterNum -1) == null) {
	              System.out.println("Sorry that theater does not exist, please enter a valid theater.");
	            } else {
	              theaLoop = true;
	            }
	           }
	            
	          Movie returnMovie = new Movie (returnVenue, returnVenue.theaters.get(theaterNum-1), startTime, endTime, 
	                name, description, ageRating, price, genre, actors, producers, directors);
	            ts.addEvent(returnVenue.theaters.get(theaterNum-1), returnMovie);
	            break;
	      }
	     } 
	    }
	 
	
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

	private void displayEventList() {
	   for (Venue venue : ts.venues) {
        for (Theater theater : venue.theaters) {
          for (Show show : theater.shows) {
               
              System.out.println(show.name+"\n"); 
          }
        }
	  }	  
	}

	private void displaySeats(Theater theater) {
		ts.displaySeats(theater);
	}

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
          ts.purchaseTicket(show, row, col);
        }
        else if (response.equalsIgnoreCase("no")) {
          ts.purchaseTicket(show);
        }
        else {
          System.out.println("Incorrect input, ticket purchasing cancelled.");
        }
      }
	}
	
	private void getRefund() {
	  System.out.println("What is the name of the show you would like to purchase a ticket for?");
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
		key.hasNextLine();
		System.out.println("Please enter a review:");
		String review = key.nextLine();
		currShow.addRating(rating, review);
		System.out.println("Rating has been added! Thanks for your feedback!");
	}
	
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



