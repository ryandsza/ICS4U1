import java.util.Scanner;

public class Main {

	public static void displayWelcomeScreen() {
		System.out.println("Welcome to the Ultimate Temperature Converter");
		System.out.println("(c) CookieSoft Inc. 2023");
	}
	
	public static int displayMainMenu() {
		Scanner userInput = new Scanner(System.in);
		int menuChoice;
		
		System.out.println("1) Convert from degrees F to degrees C");
		System.out.println("2) Convert from degrees C to degrees F");
		System.out.println("3) Quit Program");
		
		do {
			System.out.println("Please enter an option: ");
			menuChoice = userInput.nextInt();
			
			if (menuChoice < 1 || menuChoice > 3)
				System.out.println("Invalid choice! Try again!");
				else
					break;
			
		} while (true);
		
		return menuChoice;		
	}
	
	public static void performConversion(int menuChoice) {
		Scanner userInput = new Scanner(System.in);
		String displayMessage = "";
		double userEnteredTemperature;
		double convertedValue = 0;
		
		if (menuChoice == 1) {
			System.out.print("Enter the degrees Fahrenheit: ");
			userEnteredTemperature = userInput.nextDouble();
			convertedValue = (5.0/9) * (userEnteredTemperature - 32);
			displayMessage = userEnteredTemperature + " degrees F is equivalent to "+convertedValue+"C.";
		}
		else if (menuChoice == 2) {
			System.out.print("Enter the degrees Celsius: ");
			userEnteredTemperature = userInput.nextDouble();
			convertedValue = 1.8 * userEnteredTemperature + 32;
			displayMessage = userEnteredTemperature + " degrees C is equivalent to "+convertedValue+"F.";
		}
		System.out.println(displayMessage);
	}
	
	public static void main(String[] args) {
		int menuChoice;
		displayWelcomeScreen();
		
		menuChoice = displayMainMenu();
		
		if (menuChoice == 1 || menuChoice == 2)
			performConversion(menuChoice);
	
		System.out.println("Thank you for using another (c) CookieSoft Title.");
	}
}