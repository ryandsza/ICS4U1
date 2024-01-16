import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		
		/*
		 int userAge;
		 
		 System.out.print("how old are you? ");
		 userAge = userInput.nextInt();
		 System.out.println('You are " + userAge + "years old.");
		 
		 if (userAge < 18
		 	System.out.println("You are too young to vote.");
		 else if (userAge == 18)
		 	System.out.println("You are just old enough to vote.");
		 else
		 	System.out.println("You can vote.");
		 */
		
		boolean raining = true;
		boolean umbrella = false;
		
		System.out.println("Is it raining? (true/false) ");
		raining = userInput.nextBoolean();
		System.out.println("Do you have an umbrella? (true/false) ");
		umbrella = userInput.nextBoolean();
		
		if (!raining)
			System.out.println("Umbrella not required.");
		else {
			System.out.println("I hope I don't get wet");
			if (umbrella)
				System.out.println("You have a 'brella ... Yay!");
			else
				System.out.println("Run Forrest run ...");
		}	
	}
}