// Utils Version 2.0

import java.util.Random;
import java.util.Scanner; 
public class Utils {
	
	public static int obtainRandom(int lowBound,int highBound) {
		Random rand = new Random(); 
		return rand.nextInt(highBound - lowBound+1)+lowBound; 
	}

		
	

    public static float inputFloat(String message) {
	    Scanner userInput = new Scanner(System.in);
	    String result; 
	    float temp=0; 
	    boolean invalidInput=true; 
	
	    while (invalidInput) {
	    	System.out.print(message);
		    result = userInput.nextLine(); 
		
		    if (isFloat(result)) {
			    invalidInput = false; 
			    temp = Float.parseFloat(result);
		    } 
		    else
			    System.out.println("Please enter a valid decimal number!");
	    }
	    	return temp; 
    }    

    
    public static double inputDouble(String message) {
	    Scanner userInput = new Scanner(System.in);
	    String result; 
	    double temp=0; 
	
	    do {
	    	System.out.print(message);
		    result = userInput.nextLine(); 
		
		    if (isDouble(result)) {
			    temp = Double.parseDouble(result);
			    break; 
		    } 
		    else
			    System.out.println("Please enter a valid decimal number!");
	    } while (true); 
	    return temp; 
    }    
  

    
    
    public static double inputDoubleLowBound(String message,
			  								 double lowBound) {
		double result = 0; 
		
		do {
			result = inputDouble(message);
			if (result < lowBound) 
				System.out.println("Please enter a value larger than or equal to "+lowBound);
			else
				break;
		} while(true); 
		return result; 
	} 
    
    public static double inputDoubleBetween(String message,
    										double lowBound,
    										double highBound) {

		double result = 0; 
		do  {
			result = inputDouble(message);
			if (result < lowBound) 
				System.out.println("Please enter a value larger than or equal to "+lowBound);
			else if (result > highBound) 
				System.out.println("Please enter a value smaller than or equal to "+highBound);
			else
				break;
		} while (true); 
		
		return result; 
	} // end inputIntegerBetween
    
    public static int inputIntegerLowBound(String message,
    									   int lowBound) {
		
		int result = 0; 
		
		do {
			result = inputInteger(message);
			if (result < lowBound) 
				System.out.println("Please enter a value larger than or equal to "+lowBound);
			else
				break; 
		} while (true); 
		return result; 
	} 
    
	public static int inputIntegerBetween(String message,
										  int lowBound,
										  int highBound) {
		int result = 0; 
		do  {
			result = inputInteger(message);
			if (result < lowBound) 
				System.out.println("Please enter a value larger than or equal to "+lowBound);
			else if (result > highBound) 
				System.out.println("Please enter a value smaller than or equal to "+highBound);
			else
				break;
		} while(true);
		return result; 
	} // end inputIntegerBetween
	
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

	public static boolean isInteger(String string) {
	    try {
		    Integer.parseInt(string);
		    return true;
	    }
	
	    catch (NumberFormatException e) {
	    	return false; 
	    }
	}

	public static boolean isFloat(String string) {
		try {
			Float.parseFloat(string);
			return true; 
		}
		
		catch (NumberFormatException e) {
			return false; 
		}
	}

	public static boolean isDouble(String string) {
		try {
			Double.parseDouble(string);
			return true; 
		}
		
		catch (NumberFormatException e) {
			return false; 
		}
	}
	
	public static double roundDouble(double value,int decimalPlaces) {			
		if (decimalPlaces <0)
			throw new IllegalArgumentException(); 
		return Math.round(value* Math.pow(10, decimalPlaces)) / Math.pow(10, decimalPlaces);
	}
}