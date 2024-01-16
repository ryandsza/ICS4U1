/* public class: Main
* Student Name: Ryan D'Souza
* Course Code: ICS 4U1
* Project Start Date: March 21, 2023
* Project Completion Date: March 28, 2023
*/
import java.util.Scanner; //Allows the program to use the Scanner class, which provides methods for getting input from the user through the console
//This class contains the main method where the program execution begins.
//In this project, the purpose is to prompt the user to enter a specific answer for a username and password to proceed, then the user is presented with a menu either parsing Canadian or American dates or quiting the program
public class Main {
/*
* Method: userLogin
* This method validates the user's login credentials checking if they typed the specific information
* Parameters:
* 		userName: String variable that stores what the user enters
* 		userPassword: String variable that stores what the user enters
* Return Values:
* 		userInput: Returns the value of the variable
* Local Variables used:
* 		none
*/
public static String userLogin() {
String userName; //Declares the variable as a string named userName
String userPassword; //Declares the variable as a string named userPassword
Scanner userInput = new Scanner(System.in); //Creates a new Scanner object called userInput that reads input from what the user types
while (true) { //A while loop which loops infinite that will continue to execute the code block within it until the loop is finished
System.out.println("Enter username: "); //Asks the user to enter an username
userName = userInput.nextLine(); //Waits for the user to input text and stores it in the variable userName
System.out.println("Enter password: "); //Asks the user to enter a password
userPassword = userInput.nextLine(); //Waits for the user to input text and stores it in the variable userPassword
if (userName.equals("Cookie Monster") && userPassword.equals("Me Love Cookies")) { //An if statement that checks if the variable userName is equal to the string "Cookie Monster" and the variable userPassword is equal to the string "Me Love Cookies"
System.out.println("Access Granted. Welcome Cookie Monster!"); //Upon logging in, the user is greeted with a message
break; //terminates the while loop
} else { //if the user gets either the username and password or both wrong, they are presented with a message
System.out.println("Username or password incorrect!");
}
}
return userName; // Returns the value of the variable userName
}
/*
* Method: displayMenu
* A method which displays the menu and handles user input
* Parameters:
* 		userInput: Boolean variable that stores what the user enters
* Return Values:
* 		userChoice: Returns the value of the variable
* Local Variables used:
* 		userChoice: Integer variable that stores what the user enters
*/
public static int displayMenu() { //A method which displays the menu and handles user input
Scanner userInput = new Scanner(System.in); //Creates a new Scanner object called userInput that reads input from what the user types
int userChoice = 0; //Setting the variable userChoice to 0
do { //do-while loop so until the user types 1, 2 or 3 the loop will end
//print statement to show the user the main menu with the options
	System.out.println("Main Menu:");
System.out.println("1) Parse Canadian Date");
System.out.println("2) Parse US Date");
System.out.println("3) Quit Program");
System.out.println("Enter your choice: "); //prints a string to the user
userChoice = userInput.nextInt(); //reads an integer input from the user and assigns it to the userChoice variable
if (userChoice == 1) { //if statement executes if the value of userChoice is equal to 1
	System.out.println("Enter a Canadian Date to analyze (DD/MM/YYYY): "); //prints a string to the user
	parseDate(userChoice); //calls the parseDate method with userChoice as an argument
}
else if (userChoice == 2) { //if statement executes if the value of userChoice is equal to 2
System.out.print("Enter an American Date to analyze (MM/DD/YYYY): "); //prints a string to the user
parseDate(userChoice); //calls the parseDate method with userChoice as an argument
}
else if (userChoice == 3) { //if statement executes if the value of userChoice is equal to 3
	System.out.println("Thank you for using The Text Analyzer another Cookie Soft Title, send $1.99 by mail to 123 Sesame Street, Children’s Television Workshop, Ontario, Canada."); //prints a string to the user
}
else //executes if none of the above conditions are true
	System.out.println("Please enter valid choice!"); //prints a string to the user
} while (userChoice != 3); //checks if the value of userChoice is not equal to 3 and continues the loop if true
return userChoice; //returns the value of userChoice
}
/*
* Method: convertStringToInt
* /A method which which converts a string to an integer
* Parameters:
* 		placeValue: Boolean variable that stores what the user enters
* Return Values:
* 		total: Returns the value of the variable
* Local Variables used:
* 		total: Integer variable that stores what the user enters
* 		value: Integer variable that stores what the user enters
*/
public static int convertStringToInt(String number) { //A method which which converts a string to an integer
	 int total = 0; //creates a variable named total and sets its value to 0
	 int value; //declares a variable named value without any number/string
	 int placeValue = 1; //creates a variable named placeValue and sets its value to 1
	 for (int i = number.length()-1; i>=0; i--) {
		 value = (char)number.charAt(i) - (char)'0';
		 total += value * placeValue;
		 placeValue = placeValue *10;
	 }
	 return total;
}
/*
* Method: displayMenu
* A method which displays the menu and handles user input
* Parameters:
* 		userEntered: String variable that stores what the user enters
* 		userInput: String variable that stores what the user enters
* Return Values:
* 		none
* Local Variables used:
* 		formateDate: String variable that stores what the user enters
* 		day: String variable that stores what the user enters
* 		month: String variable that stores what the user enters
* 		year: String variable that stores what the user enters
*/
public static String parseDate(int userChoice) { //A method which takes user input and validates it as a valid date in the specified format
	 //String lines below declare and initialize some string variables that are used later 
	 String userEntered; 
	 String formatDate = "";
	 String day = "";
	 String month = "";
	 String year = "";
	
	 Scanner userInput = new Scanner(System.in); ////Creates a new Scanner object called userInput that reads input from what the user types
	
	 userEntered = userInput.nextLine(); //Waits for the user to input text and stores it in the variable userEntered
	 userChoice = convertStringToInt(userInput.nextLine()); //using the Scanner object userInput, assigning the first line to the userEntered variable and the second line to the userChoice parameter after converting it to an integer
// Parse Canadian date
if (userChoice == 1) { //check the value of userChoice to determine whether the user entered a Canadian or US date
System.out.println("Enter a Canadian Date to analyze (DD/MM/YYYY): "); //Asks the user to enter a canadian date to convert
String date = userInput.nextLine(); //reads the user's input and stores it as a string in the date variable
int day = convertStringToInt(date.substring(0, 2)); //extracts the first two characters of the date string, which represent the day of the month
int month = convertStringToInt(date.substring(3, 5)); //extract the 3rd and 5th characters of the month string, which represent the month
int year = convertStringToInt(date.substring(6)); //starting from the seventh character until the end of the string the substring is then converted to an integer and stored in the year variable

if (validDate(day, month, year)) { //checks if date is valid
String monthName = monthName(month); //assigning the string of the month to the monthName variable.
System.out.println("The date " + date + " is " + monthName + " " + day + ordinalNumbers(day) + ", " + year + "."); //prints string by concatenating variables and strings together
} else {
	System.out.println(String.format("The date %s is Not a valid DD/MM/YYYY format.", date)); //prints string by concatenating variables and strings together
}
}
// Parse US date
else if (userChoice == 2) { //check the value of userChoice to determine whether the user entered a Canadian or US date
System.out.println("Enter a US Date to analyze (MM/DD/YYYY): "); //Asks the user to enter an american date to convert
String date = userInput.nextLine(); //reads the user's input and stores it as a string in the date variable
int day = convertStringToInt(date.substring(3, 5)); //extracts the 3rd and 5th of the date string, which represent the day of the month
int month = convertStringToInt(date.substring(0, 2)); //extract first two characters of the month string, which represent the month
int year = convertStringToInt(date.substring(6)); //starting from the seventh character until the end of the string the substring is then converted to an integer and stored in the year variable


if (validDate(day, month, year)) { //checks if date is valid
String monthName = monthName(month); //assigning the string of the month to the monthName variable
System.out.println("The date " + date + " is " + monthName + " " + day + ordinalNumbers(day) + ", " + year + "."); //prints string by concatenating variables and strings together
} else {
	System.out.println("The date " + date + " is Not a valid MM/DD/YYYY format."); //prints string by concatenating variables and strings together
}
}
} 	
/*
* Method: validDate
* A method which displays the menu and handles user input
* Parameters:
* 		isLeapYear: Boolean variable that stores what the user enters
* Return Values:
* 		none
* Local Variables used:
* 		day: String variable that stores what the user enters
* 		month: String variable that stores what the user enters
* 		year: String variable that stores what the user enters
*/			
public static boolean validDate(int day, int month, int year) {
	 if (month < 1 || month > 12) {
		 return false;
	 } else if (month == 2) {
		 if (isLeapYear(year)) {
			 return (day >= 1 && day <= 29);
		 } else {
			 return (day >= 1 && day <= 28);
		 }
	 } else if (month == 4 || month == 6 || month == 9 || month == 11) {
		 return (day >= 1 && day <= 30);
	 } else {
		 return (day >= 1 && day <= 31);
	 }	
}
/*
* Method: isLeapYear
* A method which check whether the date the user entered is a leap year or not
* Parameters:
* 		none
* Return Values:
* 		none
* Local Variables used:
* 		year: String variable that stores what the user enters
*/
	public static boolean isLeapYear(int year) {
		return (year % 4 == 0) && (!(year % 100 == 0) || year % 400 == 0);
		}
	/*
	* Method: monthName
	* A method which displays the menu and handles user input
	* Parameters:
	* 		none
	* Return Values:
	* 		Returns the strings of all the months and if the users enters a wrong number an error message will pop up
	* Local Variables used:
	* 		month: String variable that stores what the user enters
	*/
public static String monthName(int month) {
	 if (month == 1) {
	 return "January"; //this string is executed if the condition in line above is true
	 } else if (month == 2) {
	 return "February"; //this string is executed if the condition in line above is true
	 } else if (month == 3) {
	 return "March"; //this string is executed if the condition in line above is true
	 } else if (month == 4) {
	 return "April"; //this string is executed if the condition in line above is true
	 } else if (month == 5) {
	 return "May"; //this string is executed if the condition in line above is true
	 } else if (month == 6) {
	 return "June"; //this string is executed if the condition in line above is true
	 } else if (month == 7) {
	 return "July"; //this string is executed if the condition in line above is true
	 } else if (month == 8) {
	 return "August"; //this string is executed if the condition in line above is true
	 } else if (month == 9) {
	 return "September"; //this string is executed if the condition in line above is true
	 } else if (month == 10) {
	 return "October"; //this string is executed if the condition in line above is true
	 } else if (month == 11) {
	 return "November"; //this string is executed if the condition in line above is true
	 } else if (month == 12) { 
	 return "December"; //this string is executed if the condition in line above is true
	 } else {
	 	return "Invalid month, please try again."; //executes when invalid month is entered
	 }
}
/*
* Method: displayMenu
* A method which displays the menu and handles user input
* Parameters:
* 		userInput: Boolean variable that stores what the user enters
* Return Values:
* 		userChoice: Returns the value of the variable
* Local Variables used:
* 		userChoice: Integer variable that stores what the user enters
*/
	public static String ordinalNumbers(int day) { //a method named ordinalNumbers put the suffixes at the end of a number after the user enters the
	 if (day < 1 || day > 31) { //if statement that checks if day is less than 1 or greater than 31
	 return "Invalid day, please try again."; //this string is executed if the condition in line above is true
	 }
	 else if (day == 1 || day == 21 || day == 31) { //an else if statement that checks if day is equal to 1, 21, or 31
	 return "st"; //this string is executed if the condition in line above is true
	 }
	 else if (day == 2 || day == 22) {
	 return "nd"; //this string is executed if the condition in line above is true
	 }
	 else if (day == 3 || day == 23) {
	 return "rd"; //this string is executed if the condition in line above is true
	 }
	 return "th"; //this string is executed if the condition in line above is true
	}
	/*
	* Main Method
	* A method which displays the menu and handles user input
	* Methods used:
	* 		userLogin: Method that validates the user's login credentials checking if they typed the specific information
	* 		displayMenu: Method that validates the user's login credentials checking if they typed the specific information
	*/
public static void main(String[] args) {
	userLogin();
	displayMenu();
} //end main
} //end class
