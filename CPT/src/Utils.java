import java.util.Scanner;
import java.util.Random; 
public class Utils {
	public static char obtainYesNo(String message) {
	    Scanner userInput = new Scanner(System.in);
	    String result; 
	     
	    do {
	    	System.out.print(message);
	    	result = userInput.nextLine().toLowerCase(); 
	    
	    	if (result.equals("y") || result.equals("n"))
	    		break; 
	    	else
	    		System.out.println("Be sure to enter either y or n only.");	
	    } while (true); 
	    return result.charAt(0);
	}
	
    public static double inputDoubleLow(String message,double lowBound) {
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
    public static double inputDoubleHigh(String message,double highBound) {
		double result = 0; 
		do {
			result = inputDouble(message);
			if (result > highBound) 
				System.out.println("Please enter a value less than or equal to "+highBound);
			else
				break; 
		} while(true); 
		return result; 
	} 
    public static double inputDoubleBetween(String message,
											double lowBound,
											double highBound) {
		double result = 0; 
		do {
			result = inputDouble(message);
			if (result < lowBound || result > highBound) 
				System.out.println("Please enter a value between "+lowBound+ " and "+highBound+" inclusive.");
			else
				break;
		} while (true); 
		return result; 
	} 

    public static int inputIntegerLow(String message,int lowBound) {
		int result = 0; 
		do {
			result = inputInteger(message);
			if (result < lowBound) 
				System.out.println("Please enter a value larger than or equal to "+lowBound);
			else
				break; 
		} while(true); 
		return result; 
	} 
    public static int inputIntegerHigh(String message,int highBound) {
		int result = 0; 
		do {
			result = inputInteger(message);
			if (result > highBound) 
				System.out.println("Please enter a value less than or equal to "+highBound);
			else
				break; 
		} while(true); 
		return result; 
	} 
    public static int inputIntegerBetween(String message,
										  int lowBound,
										  int highBound) {
		int result = 0; 
	    
		do {
			result = inputInteger(message);
			if (result < lowBound || result > highBound) 
				System.out.println("Please enter a value between "+lowBound+ " and "+highBound+" inclusive.");
			else
				break;
		} while (true); 
		return result; 
	} 
	
    
	public static double inputDouble(String message) {
	    Scanner userInput = new Scanner(System.in);
	    String result=""; 
	     
	    do {
	    	System.out.print(message);
		    result = userInput.nextLine(); 
		
		    if (isDouble(result))
			    break; 
		    else
			    System.out.println("Please enter a valid decimal number!");
	    } while (true); 
	    
	    return Double.parseDouble(result); 
    }    
	public static int inputInteger(String message) {
	    Scanner userInput = new Scanner(System.in);
	    String result; 
	
	    System.out.print(message); 
	    do {
	    	result = userInput.nextLine(); 
	
	    	if (isInteger(result)) 
	    		break;
	    	
	    	else
	    		System.out.println("Please enter a valid integer!");
	    } while(true); 
	    return Integer.parseInt(result); 
	}

	public static boolean isInteger(String stringToCheck) {
	    try {
		    Integer.parseInt(stringToCheck);
		    return true;
	    }
	
	    catch (NumberFormatException e) {
	    	return false; 
	    }
	}
	public static boolean isDouble(String stringToCheck) {
		try {
			Double.parseDouble(stringToCheck);
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
	public static int randomIntBetween(int low, int high) {
		Random rand = new Random(); 
		return rand.nextInt(high - low + 1) + low; 
	}
	
	public static double randomTwoDecimalDoubleBetween(double low, double high) { 
		return randomIntBetween((int)low*100,(int)high*100)/100.0;  
	}
}