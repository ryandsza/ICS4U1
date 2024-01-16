package bookManager;

public class Checkout {
	private int userID;
	private int ISBN; 
	
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
	 * method getISBN
	 * Method to get ISBN
	 * Return Values: int
	 */
	public int getISBN() {
		return ISBN;
	}

	/*
	 * method setISBN
	 * parameter: int ISBN
	 * Method set the ISBN
	 * Return Values: non
	 */
	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}
	
	/* Method: toString
	 * Method to userID and ISBN 
	 * Return Values: the user ID and ISBN
	 */
	public String toString() {
   	 return String.format("%-40s %-40s %n",this.getUserID(),this.getISBN());
   }
	
	
}