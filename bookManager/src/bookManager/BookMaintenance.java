package bookManager;

import java.util.Scanner;

public class BookMaintenance {
	private Books [] booksArray;
	private int currentLast = 0;
	private int size;
	
	/*
	 * Method get Books
	 * Method to get books in books class
	 * Return Values: items
	 */
	public Books[] getBooks() {
		return this.booksArray;
	}
	
	/*
	 * Method to get current last
	 * Return Values: currentLast
	 */
	public int getCurrentLast() {
		return this.currentLast;
	}
	
	/*
	 * Method to get the size of the array
	 * Return Values: int
	 */
	public int getSize() {
		return this.size;
	}
	
	/*
	 * Method to set current last
	 * Return Values: int
	 */
	public void setCurrentLast(int currentLast) {
		this.currentLast = currentLast;
	}
	
	/*
	 * Constuctor BookMaintenance
	 * 
	 * BookMaintenance that will be created to call the class
	 * 
	 */
	BookMaintenance(int size) {
		this.booksArray = new Books[size];

		for (int i=0;i<size;i++)
			this.booksArray[i] = new Books();	 
		
		this.size = size; // Resets the size
		this.currentLast = 0; // Resets the currentLast
		addDefaultBooks();
	}
	
	/* Method: reInitialize
	 * 
	 * The method will just throw a illegal argument exception that are there to reinitialize the code
	 */
	private void reInitialize(int size) {
	if (size < 0)
		throw new IllegalArgumentException("Cannot sell items with negative items for sale. ");
	
	this.booksArray = new Books[size];

	for (int i=0;i<size;i++)
		this.booksArray[i] = new Books();	
	
	this.size = size; // Resets the size
	this.currentLast = 0; // Resets the currentLast
	}
	
	
	/* Method: isFull
	 * 
	 * The method will reset the the currentLast variable to the size variable 
	 */
	private boolean isFull() {
		return this.currentLast == size;
	}
	
	/* Method Search Item
	 * The Methods main purpose is to be able to search for an Imte 
	 * 
	 * Local Variables:
	 * found: Boolean varuable that will find the if the item code is found 
	 * position: int variable that will help the postion the item code
	 * 
	 * Parameters: 
	 * ISBN: int variable that will use the to find the book ISBN
	 */
	private int searchItem(int ISBN) {
		boolean found =  false;
		int position = 0;
		
		
		for(int i = 0; i <currentLast;i++) 
			if(booksArray[i].getISBN() == ISBN) { // Finding the home
				found = true;
				position = i;
				break;
			}
			if (found)
				return position;
			else
				return -1;
	}
	
	/* Method resizeArray
	 * The Method will resize array and mutliply it twice
	 * Sets the items into the item variable
	 */
	private void resizeArray () {
		size = size *2;
		Books [] tempItems = new Books[size];
		
		for(int i = 0; i < size; i++) {
			tempItems[i] = new Books();
		}
		for(int i = 0; i < currentLast; i++) {
			tempItems[i].copyBookData(booksArray[i]); // Copys the data and puts into the new array
		}		
		booksArray = tempItems;
	}
	
	/* Method addBook
	 * The Methods main purpose is to be able to remove an items 
	 * 
	 * Local Variables:
	 * int foundPosition: Variable that will find the position of the item code
	 * String bookTitle: Variable that will prompt the user to put a enter the title for a book
	 * String bookAuthor: Variable that will prompt the user to put a enter the author for the book Title
	 * int bookISBN: Variable that will prompt the user to put a enter the ISBN for the book	 
	 * Scanner userInput: Prompts the user for a input
	 */
	
	public void addBook() {
		String bookTitle;
		String bookAuthor;
		int bookISBN;
		int foundPosition;
		
		Scanner userInput = new Scanner (System.in);
		
		System.out.println("Please enter the Book name: ");
		bookTitle = userInput.nextLine();
		System.out.println("Please enter the book Author: ");
		bookAuthor = userInput.nextLine();
		bookISBN = Utils.inputInteger("Please enter the book ISBN: ");
		
		if (isFull()) // Checks if the array is full
			resizeArray(); // The array is then reset 
		
		foundPosition = searchItem(bookISBN); // Checks if the item is already available
		
		if(foundPosition !=-1) // If loop that checks if it already there
			System.out.println("This book already exists");
		else { // Else loop that will set the new data
			booksArray[currentLast].setBookData(bookTitle,bookAuthor,bookISBN,true); // Sets the new item into a new array
			currentLast++; // Adds the current last varirable
		}
	}
	
	/* method display Books
	 * All the books that will be displayed to the user
	 */
	public void displayBooks() {
		String temp;
    	System.out.println(String.format("%-40s %-40s %-20s %n","Book Name","Book Author","Book ISBN"));
		for(int i = 0; i < booksArray.length; i++) {
			if(booksArray[i].getTitle() != null) {
				temp = booksArray[i].toString();
				System.out.println(temp);
			}
			else
				break;
		}
	}
	
	/* Method remmoveBook
	 * The Methods main purpose is to be able to remove an book 
	 * 
	 * Local Variables:
	 * int ISBN: Variable that will prompt the user to put a enter the ISBN they wish to remove
	 * int foundPosition: Variable that will find the position of the item code
	 * Scanner userInput: Prompts the user for a input
	 * int updatedQuantity: Variable that will store the new quanitity
	 */
	
	public void removeBook() {
		int bookISBN;
		bookISBN = Utils.inputInteger("Please enter the book ISBN: ");
		int foundPosition = searchItem(bookISBN); // Goes to the method to find the item code
		
		if(foundPosition == -1) // If loop that will find whether the code is found
			System.out.println(bookISBN+ " not found"); // The user will be given a response if the item is not found.
		else { // Else loop that will prompt the user to enter the new quantity
			Books [] tempItems = new Books[currentLast-1]; 
			int j = 0; // Initializing the variable
			for(int i = 0; i < currentLast; i++) { // For loop that will cause the user to remove everthing. 
				if( i != foundPosition) {
					Books item = new Books();
					item.copyBookData(booksArray[i]); // Copys the data into the new array
					tempItems[j] = item;
					j++;
				}	
			}	
			if (j == 0) { // last  item removed
				reInitialize(10); // The array is reinitialized
			}
			else {
				booksArray = new Books[j];
				for(int i = 0; i < j; i++) {
					booksArray[i] = new Books();
				}	
				for(int i = 0; i < j; i++) {
					booksArray[i].copyBookData(tempItems[i]);
				}
				this.currentLast = j;
				this.size = this.currentLast;
			}			
			System.out.println( "Item removed successfully."); // Print message to show the item is removed from the array 
		}
	}
	
	

	/* Method addDefaultBooks
	 * The Methods main purpose is to be able to add books so the user can start with a few books
	 * 
	 */
	private void addDefaultBooks() {		
		booksArray[0].setBookData("Harry Potter and the Sorcerer's Stone", "JK Rowling" , 1, true);
		currentLast++;
		
		booksArray[1].setBookData("The Book Theif" , "Markus Zusak" ,2, true);
		currentLast++;

		booksArray[2].setBookData("To Kill a MockingBird" , "Harper Lee" ,3, true);
		currentLast++;

		booksArray[3].setBookData("The Giver" , "Lois Lowry" ,4, true);
		currentLast++;

		booksArray[4].setBookData("The Hobbit" , "J.R.R Tolkien" ,5, true);
		currentLast++;

		booksArray[5].setBookData("The Hunger Games" , "Suzane Collins" ,6, true);
		currentLast++;

		booksArray[6].setBookData("The Fault in Our Stars" , "John Green" ,7, true);
		currentLast++;

		booksArray[7].setBookData("The Maze Runner" , "James Dashner" ,8, true);
		currentLast++;

		booksArray[8].setBookData("The Cat in the Hat" , "Dr. Suess" ,9, true);
		currentLast++;

		booksArray[9].setBookData("Diary of a Wimpy Kid" , "Jeff Kinney" ,10, true);
		currentLast++;
	}
}
