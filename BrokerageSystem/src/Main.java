import java.util.Scanner;

public class Main {
	public static void menuOption() {
		System.out.println("\n\tProgram Execution Main Menu:");
		System.out.println("\n\t1) Customer Management");
        System.out.println("\t2) Stock Management & Transactions");
        System.out.println("\t3) Generate Reports");
        System.out.println("\t4) Random Market Movement");
        System.out.println("\t5) Cookie Random Catastrophe");
        System.out.println("\t6) Quit");
	}

	public static void customerOption() {
		System.out.println("\n\tCustomer Account Management Submenu:");
		System.out.println("\t1) Add Account Holder");
		System.out.println("\t2) Remove Account Holder");
		System.out.println("\t3) Fund Account");
		System.out.println("\t4) Withdraw Funds");
		System.out.println("\t5) Display Account Current Stock Positions");
		System.out.println("\t6) Return to Main Menu");
	}
	
	public static void stockOption() {
		System.out.println("\n\tStock Management & Transactions Submenu:");
		System.out.println("\t1) Add new stock to available stocks");
		System.out.println("\t2) Customer purchase of Stock");
		System.out.println("\t3) Customer sale of Stock");
		System.out.println("\t4) Stock Split 2 for 1");
		System.out.println("\t5) Reverse Stock Split 1 for 2");
		System.out.println("\t6) Return to Main Menu");
	}
	
	public static void reportOption() {
		System.out.println("\n\tGenerate Reports Submenu:");
		System.out.println("\t1) View all current holders of a particular stock");
		System.out.println("\t2) Generate all positions for all accounts");
		System.out.println("\t3) Return to Main Menu");
	}


	public static void main(String[] args) {
		System.out.println("Welcome to the Sesame Street Brokerage System"); // Welcome the user to the program
		int menuChoice = 0; 
		int customerChoice = 0; 
		int stockChoice = 0; 
		int reportChoice = 0;
		
		BookMaintenance books = new BookMaintenance(10);  // Object created so that the  book Maintenance class can be called and used in the Main class
		UserMaintenance users = new UserMaintenance();	// Object created so that the user Maintenance class can be called and used in the Main class
		CheckoutMaintenance checkout = new CheckoutMaintenance(); // Object created for the checkoutMaintence class can be called and used in the Main class

		do { // Goes into a do loop that will execute the code before checking again.
			menuOption();
			menuChoice = Utils.inputIntegerBetween("Please select and option: ", 1, 6);
			
			if(menuChoice == 1) { // Goes into a if loop if the users choice is 1
				do { // Goes into a do loop that will execute the code before checking again.
					bookOption();
					userBookChoice = Utils.inputIntegerBetween("\nPlease select an option: ", 1, 6);
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
					userChoice = Utils.inputIntegerBetween("\nPlease select an option: ", 1, 6);
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
					checkoutOption = Utils.inputIntegerBetween("\nPlease select an option: ", 1, 6);
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