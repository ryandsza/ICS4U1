package bookManager;

import java.util.Scanner;

public class User {
	private String userName;
    private int userID;
    
    /*
	 * method getUserName
	 * Method to get the user name
	 * Return Values: string
	 */
    public String getUserName() {
		return userName;
	}

    /*
	 * method setTitle
	 * parameter: string userName
	 * Method set the userName
	 * Return Values: non
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/*
	 * method getUserID
	 * Method to get the user ID
	 * Return Values: int
	 */
	public int getUserID() {
		return userID;
	}
	
	/*
	 * method setUserID
	 * parameter: int userID
	 * Method set the userID
	 * Return Values: non
	 */
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	/*
	 * method setUserData
	 * parameter:
	 * String userName: the user name
	 * int userId: the userID
	 *
	 * Method use to set book Data
	 * Return Values: non
	 */
	public void setUserData(String userName, int userId) {
		this.userName = userName;
		this.userID = userId;	
	}
	
	
	/*
	 * method copyUserData
	 * parameter:
	 * Books source
	 * Method use to copy data
	 * Return Values: non
	 */
	public void copyUserData(User source) {

		setUserData(
				source.getUserName(),
				source.getUserID()
				);
	}	
	
	/* Method: toString
	 * Method to five the name and id. 
	 * Return Values: the user name and ID
	 */
	public String toString() {
		return String.format("%-20s %-10d",userName,userID); 
	}


}