import java.util.Scanner;

public class Utils {
	
	public static boolean isInteger(String string) {
	    try {
		    Integer.parseInt(string);
		    return true;
	    }
	
	    catch (NumberFormatException e) {
	    	return false; 
	    }
	}
	
	public static int inputInteger(String message) {
	    Scanner userInput = new Scanner(System.in);
	    String result; 
	    int temp=0; 
	
	    do {
	    	System.out.print(message); 
	    	result = userInput.nextLine(); 
	
	    	if (isInteger(result)) {
	    		temp = Integer.parseInt(result);
	    		break;
	    	}
	    	else
	    		System.out.println("Please enter a valid integer!");
	    } while (true); 
	    
	    return temp; 
	}
}
