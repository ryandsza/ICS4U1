import java.util.Scanner; 

public class Main {

	
	public static void displayMenu() {
		System.out.println("Welcome to the guessing game!");
		System.out.println("A CookieSoft Title.");
	}
	public static String obtainRanking(int guessCount) {
		if (guessCount <3)
			return "Expert";
		else if (guessCount < 8)
			return "Amateur";
		else
			return "Rookie";
	}
	
	public static void displayEndOfGame(int guessCount) {
		String temp = "It took you " + guessCount; 
		if (guessCount == 1)
			temp += " guess!";
		else
			temp += " guesses!";
		
		System.out.println(temp);
		System.out.println(obtainRanking(guessCount)+ " ranking.");
		System.out.println("Thank you for using the guessing game. "
				+ "Send $1.99 for a fully functional version");
	}
	
	
	public static boolean loginRequired(int PIN) {
		
		int invalidAttempts=0;
		int userEnteredPIN; 
		
		do {
			userEnteredPIN = Utils.inputInteger("Please enter PIN to proceed: ");		
			if (userEnteredPIN != PIN) {
				System.out.println("Invalid PIN entered!");
				invalidAttempts++;
			}
				
		} while (userEnteredPIN != PIN && invalidAttempts != 3);
		return userEnteredPIN == PIN;
 
	}
	
	public static void gameMechanics(int lowBound, int highBound) {
		int guessCount = 0; 
		
		int secretNumber = Utils.obtainRandom(lowBound,highBound); 
		System.out.println("Cheat code ... "+secretNumber);
		int userValue; 
		do {
			userValue = Utils.inputIntegerBetween("What is your guess (between "+lowBound+" and "+highBound+"): ", 
												  lowBound, 
												  highBound);
			guessCount ++; 
			if (userValue > secretNumber)
				System.out.println("Your guess is too high!");
			else if (userValue < secretNumber)
				System.out.println("Your guess is too low!");
			else
				break; 
			
		} while (true);
		displayEndOfGame(guessCount); 
	}
	
	public static void main(String[] args) {
		int lowBound; 
		int highBound; 
		
		displayMenu(); 
		if (!loginRequired(1))
			System.out.println("Too many invalid attempts!");
		else {
			System.out.println("Access Granted!");
			lowBound = Utils.inputInteger("Enter lowest value possible: ");  
			highBound = Utils.inputIntegerLowBound("Enter highest value possible: ", 
												    lowBound+1);
			
			gameMechanics(lowBound,
						  highBound); 
		}
	}
}