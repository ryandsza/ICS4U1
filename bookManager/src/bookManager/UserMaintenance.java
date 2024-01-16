package bookManager;

import java.util.ArrayList;
import java.util.Scanner;

public class UserMaintenance {
    private ArrayList <User> userList;

    /*
	 * Constuctor BookMaintenance
	 * UserMaintenance that will be created to call the class and is also declared
	 * 
	 */
    UserMaintenance (){
    	userList = new ArrayList<>();
    }
    public ArrayList<User> getUserList() {
		return userList;
	}
    
	/* Method addUser
     * The method will add a user to the system
     * 
     * String userName: Variable that will store the name to variable
     * Integer userId: Variable that will add a number to the user
     * 
     */
    public void addUser() {
		String userName;
		int userID;
		User user = new User(); // Object that will be created to use the user class 

		Scanner userInput = new Scanner (System.in);
		
		System.out.println("Please enter the users full name: ");
		userName = userInput.nextLine(); 
		userID = userList.size()+1; // Finds the size of the user to find the user id
		
		user.setUserData(userName, userID); //Sets the user name and id to the user
		userList.add(user); // Adds the user to the list
	}
    
    /* Method removeUser
     * The method will remove a user to the system
     * 
     * Integer userId: Variable that will add a number to the user
     * 
     */
    public void removeUser(){
    	int userID;
		User user = new User(); // Object that will be created to use the user class
    	userID = Utils.inputInteger("Please enter the user ID you would like to remove: ");
    	
    	for(int i = 0; i < userList.size();i++) {
    		if(userList.get(i).getUserID() == userID) { // If loop that will check if the there is a match	
    			userList.remove(i); // Removes the user from the list
    			System.out.println("User removed successfully");
    		}
    		else
    			System.out.println("User not found");
    	}  	
    }
    
    /*
	 * method displayUser
	 * Method to display the user information such as name and userID 
	 * 
	 */
    public void displayUser() { 
    	
    	System.out.println("");
         System.out.println(String.format("%-20s %-10s","Name","userId"));
         for (int i=0; i<userList.size();i++) // For loop to print every element in the array
         	System.out.println(userList.get(i)); // Prints each item from the list seperately
         System.out.println("");
    }
}