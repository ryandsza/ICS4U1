import java.util.Random;
import java.util.Scanner;

public class Main {
	public static int rollDie() { //method used to roll six sided die
		return obtainRandom(1,6); // here is where you can change the number of sides on the die
	}
	
	public static int obtainRandom(int low, int high) { //1 is the low value and 6 is the high value
		Random rand = new Random(); //returns a value 0 <= value < x
		return rand.nextInt(high-low+1)+low; //obtained a random number between low and high inclusive so that 1 and 6 can be included
	}
	
	public static int rollDice(int numberOfDice) {
		int sum=0; 
		int count = 0; 
		
		// need to code this ....
		while (count < numberOfDice) {
			sum += rollDie();
			count++;
		}
		return sum; 
	}

	public static int displayMenu(int playerHealth,int computerHealth) {
		Scanner userInput = new Scanner(System.in);
		int menuChoice; 
		while (true) {
			
			System.out.print("\tLuke Skywalker's Health = "+playerHealth+" Darth Sidious' Health = "+computerHealth);
			System.out.println("\nMain Menu: ");
			System.out.println("1) Attack");
			System.out.println("2) Defend");
			System.out.println("3) Run away");
			
			System.out.print("\tWhat does Luke do:  ");
			menuChoice = userInput.nextInt(); 
			
			if (menuChoice >=1 && menuChoice <=3)
				break; 
			else
				System.out.println("Error. Please specify a valid menu choice.");
		}
		return menuChoice; 
	}
	
	public static int computeDamage(int playerRoll,int computerRoll) {
		return Math.abs(computerRoll - playerRoll); //Absolute value makes any number that was negative turn into positive
	}
	
	public static boolean isGameOver(int playerHealth, int computerHealth) {
		return !(playerHealth <= 0 || computerHealth <=0); //	if (playerHealth <= 0 || computerHealth <=0) return true; else return false;
	
	}
	
	public static String decideWinner(int lukeHealth,int sidiousHealth) {
		String result = "Luke Skywalker defeats Darth Sidious!";
		
		if (lukeHealth < sidiousHealth)
			result = "Darth Sidious defeats Luke Skywalker!";
		
		return result;	
	}

	public static void main(String[] args) {
		
		boolean gameOver = false; 
		
		int skywalkerRoll=0; 
		int sidiousRoll=0; 
		int choice; 
		
		int skywalkerHealth = obtainRandom(70,100); //between 10 and 60
		int sidiousHealth = obtainRandom(60,80);   // between 10 and 50 
		
		System.out.println("Welcome to Star Wars Battle Version 0.00000001 \n(before graphics were invented).");
		System.out.println("Luke confronts Darth Sidious ... a battle ensues.");
		System.out.println("");
		
		do {
			choice = displayMenu(skywalkerHealth,sidiousHealth); 
			
			if (choice == 3) 
				break; 
			
			else if (choice == 1) {
				// player attacks
				skywalkerRoll = rollDice(2);
				sidiousRoll = rollDice(3);
			}
			
			else if (choice == 2) {
				// player defends
				skywalkerRoll = rollDice(3);
				sidiousRoll = rollDice(2);
			}
			
			System.out.println("Luke rolls: "+skywalkerRoll+" Darth Sidious rolls: "+sidiousRoll);
			if (skywalkerRoll > sidiousRoll) {
				System.out.println("Luke strikes with the light side of the force ...");
				sidiousHealth -=  computeDamage(skywalkerRoll,sidiousRoll);
			}
			else {
				System.out.println("Darth Sidious strikes with the dark side of the force ...");
				skywalkerHealth  -= computeDamage(skywalkerRoll,sidiousRoll);
			}
			gameOver = isGameOver(skywalkerHealth,sidiousHealth);
		} while (!gameOver);
		
		System.out.println("The winner of the game is: "+decideWinner(skywalkerHealth,sidiousHealth));
	}

}
