package bookManager;

public class Main {
	
	/* Method menuOption
	* This method displays the menu options for the user. .
	*/
	
	public static void menuOption() {
		System.out.println("\n\t1) Book Options");
		System.out.println("\t2) User Options");
		System.out.println("\t3) Checkout Option");
		System.out.println("\t4) Quit");
	}
	
	
	/* Method bookOption
	* This method displays the submenu options for the user.
	*/
	public static void bookOption() {
		System.out.println("\n\t1) Add Book");
		System.out.println("\t2) Remove Book");
		System.out.println("\t3) Display Books");
		System.out.println("\t4) Return to menu");
	}
	
	/* Method userOption
	* This method displays the submenu options for the user. .
	*/
	public static void userOption() {
		System.out.println("\n\t1) Add user");
		System.out.println("\t2) Remove user");
		System.out.println("\t3) Display users");
		System.out.println("\t4) Return to menu");
	}
	
	/* Method checkoutO
	* This method displays the submenu options for the user. .
	*/
	public static void checkoutOption() {
		System.out.println("\n\t1) Checkout book");
		System.out.println("\t2) Return books");
		System.out.println("\t3) Display Checkedout Books");
		System.out.println("\t4) Return to Menu");
	}

	public static void main(String[] args) {
		System.out.println("Welcome to the library management System"); // Welcome the user to the program
		int menuChoice = 0; // Integer variable that will store the users menu choice.
		int userBookChoice = 0; // Integer variable that will store the users book choice.
		int userChoice = 0; // Integer variable that will store the users choice.
		int checkoutOption = 0; // Integer variable that will store the users checkout  choice.
		
		BookMaintenance books = new BookMaintenance(10);  // Object created so that the  book Maintenance class can be called and used in the Main class
		UserMaintenance users = new UserMaintenance();	// Object created so that the user Maintenance class can be called and used in the Main class
		CheckoutMaintenance checkout = new CheckoutMaintenance(); // Object created for the checkoutMaintence class can be called and used in the Main class

		do { // Goes into a do loop that will execute the code before checking again.
			menuOption();
			menuChoice = Utils.inputIntegerBetween("Please select and option: ", 1, 4);
			
			if(menuChoice == 1) { // Goes into a if loop if the users choice is 1
				do { // Goes into a do loop that will execute the code before checking again.
					bookOption();
					userBookChoice = Utils.inputIntegerBetween("\nPlease select an option: ", 1, 4);
					if(userBookChoice == 1) { // Goes into a if loop if the users choice is 1
						books.addBook(); // Adding the books to the original array 
					}
					
					else if(userBookChoice == 2) { // Goes into a if loop if the users choice is 2
						books.removeBook(); // Removing the books to the original array
					}
					
					else if(userBookChoice == 3) { // Goes into a if loop if the users choice is 3
						books.displayBooks(); // Displaying the books from the original array
					}
						
				}while(userBookChoice != 4); // Ends the loop.
			}
			
			else if (menuChoice == 2) { // Goes into a if loop if the users chooses is 2
				do { // Goes into a do loop that will execute the code before checking again.
					userOption();
					userChoice = Utils.inputIntegerBetween("\nPlease select an option: ", 1, 4);
					if(userChoice == 1) { // Goes into a if loop if the users chooses is 1
						users.addUser(); // Adding the user to the original array list
					}
					
					else if(userChoice == 2) { // Goes into a if loop if the users chooses is 2
						users.removeUser(); // Removing the user to the original array list
					}
					
					else if(userChoice == 3) { // Goes into a if loop if the users chooses is 3
						users.displayUser(); // Displaying the users from the original arraylist
					}
				}while(userChoice != 4); // Ends the loop.
			}
			
			else if (menuChoice == 3) { // Goes into a if loop if the users chooses is 3
				do { // Goes into a do loop that will execute the code before checking again.
					checkoutOption();
					checkoutOption = Utils.inputIntegerBetween("\nPlease select an option: ", 1, 4);
					if(checkoutOption == 1) { // Goes into a if loop if the users chooses is 1
						checkout.checkOut(users.getUserList(),books.getBooks()); // checks out a book from the book list
					}
					
					else if(checkoutOption == 2) { // Goes into a if loop if the users chooses is 2
						checkout.returnBooks(books.getBooks()); // returns the book that has been checked out
					}
					
					else if(checkoutOption == 3) {
						checkout.displayCheckoutBooks(); // Displays all the books that have been checked out
					}
					
				}while(checkoutOption != 4); // Ends the loop. 
			}	
		}while(menuChoice != 4); // Ends the loop.
		System.out.println("You have exited the program"); // Prints a end message for the user
	}	
}