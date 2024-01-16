package bookManager;

import java.util.ArrayList;

public class CheckoutMaintenance {
	private ArrayList<Checkout>checkoutList;
	private Books[] bookList;
	
	/*
	 * Constuctor BookMaintenance
	 * Checkout that will be created to call the class checkout and is also declared
	 */
	CheckoutMaintenance(){
		checkoutList = new ArrayList<>();
	}
	
	/* Method checkout
	 * The Methods main purpose is to chechkout books from the array  
	 * 
	 * Local Variables:
	 * int userID: Variable that will prompt the user to put a enter the title for a book
	 * int userBookCount: Variable that will Store how many books the user has
	 * int ISBN: Variable that will prompt the user to put a enter the ISBN for the book	 
	 */
	public void checkOut(ArrayList<User>userList, Books [] bookList) {
		int ISBN;
		int userID;
		int userBookCount;
		Checkout checkoutBook = null;
		char userAnswer; // Char variable that will check if you want to add more books
		boolean userFound = false;
		
		userID = Utils.inputInteger("Please enter the user ID: "); // asks the user for the userID
		
		for(int i = 0; i < userList.size(); i++) { // for loop that will interate the userlist size
    		if(userList.get(i).getUserID() == userID) { // finds the userID from the array list
    			userFound = true;
    			userBookCount = getBookCount( userID); //get count of issued books
    			while(userBookCount < 3 ) { //While loop that checks if the user has checked out more than one book
	    			ISBN = Utils.inputInteger("Please enter the ISBN of the book: ");
	    			if (isBookAvailable(bookList, ISBN)){ // Checks if the book is availible
		    			checkoutBook = new Checkout();		
		    			checkoutBook.setISBN(ISBN);
		    			checkoutBook.setUserID(userID);
		    			checkoutList.add(checkoutBook);
		    			updateBookAvailibity(bookList,ISBN,false);
		    			userAnswer = Utils.obtainYesNo("Do you want to checkout more books(y/n): "); // Asks if the user wants to add more books
		    			if(userAnswer == 'n') { // If the answer is no
		    				break; // the loop will stop and it will break
		    			}
	    			userBookCount++; // Adds the book count
	    			}
	    			else
	    				System.out.println("This book not available");	// Print message that shows the book is not availible
    			}
    			if (userBookCount == 3){ // If the book count of 3 
    				System.out.println("You have reached maximium limit"); // Print message indicating you have reached max limit
    				break; // breaks the code
    			}
    			break; //  Breaks the code 
    		}
		}
		if (userFound == false) { // If the user is false
    		System.out.println("This user does not exist."); // Print message if the user doesn't exist		
    	}
	}
	
	/*
	 * Method getBookCount
	 * 
	 * This method will count the books that a user checked out
	 * 
	 */
	private int getBookCount( int userId){
		int count = 0;
		Checkout checkout = null;
		for (int i = 0; i<checkoutList.size(); i++){
			checkout = checkoutList.get(i);
			if (checkout.getUserID() == userId){
				count++;
			}
		}
		return count;	
	}
	
	/*
	 * Method isBookAvalible
	 * 
	 * This method will check if the book is avalible
	 * 
	 * Parameters:
	 * Booklist: Book class that will check the books
	 * ISBN: isbn number of a book that will try to match the book
	 * 
	 */
	private boolean isBookAvailable(Books [] bookList, int ISBN) {
		boolean available= false; // boolean variable that will check if the book is avalible
		for(int i = 0; i < bookList.length; i++) { // 
			if(bookList[i].getISBN() == ISBN && bookList[i].isAvailable()) { // Checks if availible
				available = true; // Makes it true
				break;// Stops the code
			}				
		}
		return available;
	}
	
	/*
	 * Method updateBookAvailibility
	 * 
	 * This method will update the avaliblity of the book
	 * 
	 * Parameters:
	 * Booklist: Book class that will check the books
	 * ISBN: isbn number of a book that will try to match the book
	 * availibe: boolean variable to show to set the availiblity
	 * 
	 */
	private void updateBookAvailibity(Books [] bookList,int ISBN, boolean availible) {
		for(int i = 0; i < bookList.length; i++) {
			if(bookList[i].getISBN() == ISBN) {   
				bookList[i].setAvailable(availible); // Makes it avalible
			}		
		}
	}
	
	/*
	 * Method returnBooks
	 * 
	 * This method will return the books
	 * 
	 * Parameters:
	 * Booklist: Book class that will check the books
	 */
	public void returnBooks(Books [] bookList) {
		int ISBN;
		int userID;
		boolean userFound = false;
		char userAnswer; // Char variable that will check if you want to add more books

		
		userID = Utils.inputInteger("Please enter the user ID: ");
		
		for(int i = 0; i < checkoutList.size(); i++) {
    		if(checkoutList.get(i).getUserID() == userID) { // Checks if the userID from the checkout list is also part of the actual id
    			userFound = true;
    			ISBN = Utils.inputInteger("Please enter the ISBN of the book: "); // Asks for the ISBN number
    				remove(userID, ISBN); // Method that will remove the code from the list
	    			updateBookAvailibity(bookList,ISBN,true); // changes the availibility to true and back to the list
	    			System.out.println("Book has been returned"); // The book will be returned
    				break; // The code breaks
    		}
		}
    	if (userFound == false) // If the user is not found
    	    System.out.println("This user does not exist."); // Print message if the user doesn't exist			
		
	}
	
	/*
	 * private void remove(userID, ISBN)
	 * Method that will remove and return the book from the from the checkout list 
	 * 
	 */
	
	private void remove(int userId, int ISBN){
		Checkout  checkout = null; // Initializing the variable
		for (int i = 0; i<checkoutList.size(); i++){ // For loop that will iterate the size of the checkedout book
			checkout = checkoutList.get(i); // Gets the book from the list 
			if (checkout.getISBN() == ISBN && checkout.getUserID() == userId){ // If they both equal each other
				checkoutList.remove(i); // The book wil be removed from the list
				break; // Breaks the code
			}
		}
	}
	

    /*
	 * method displayCheckoutBooks
	 * Method to display the books that have been checkedout by the user
	 * 
	 */
	public void displayCheckoutBooks(){
		String temp;
    	System.out.println(String.format("%-40s %-40s %n","User ID","Book ISBN"));
    	for (int i=0; i<checkoutList.size();i++) // For loop to print every element in the array
         	System.out.println(checkoutList.get(i)); // Prints each item from the list seperately
         System.out.println("");
		}
}