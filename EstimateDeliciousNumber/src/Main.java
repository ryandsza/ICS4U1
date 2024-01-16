/******************************************************************************
    π ≈ 4(1/1 - 1/3 + 1/5 - 1/7 + 1/9 - ...)
    
    
    

*******************************************************************************/

public class Main {
    
    public static double estimatePI(int terms) {
        double sum=0; 
        int count=0; 
        
        if (terms <0)
            return sum; 
            
        while (count < terms) {
            sum = sum + Math.pow(-1,count) / (2*count + 1.0);
            count ++; 
        }
        
        return 4 * sum; 
        
    }
    public static double percentDifference(double actual, double estimate) {
        return roundDouble(100 *  (actual - estimate) / actual,4); 
    }
    
    
    public static double roundDouble(double value, int decimalPlaces) {
        if (decimalPlaces <0)
            throw new IllegalArgumentException("Inalid number of decimal places specified!");
        return Math.round(value * Math.pow(10,decimalPlaces)) / Math.pow(10,decimalPlaces); 
    }
    
	public static void main(String[] args) {
	    
	    int x=1; 
	    double estimate; 
	    
	    System.out.println("Terms:\t\tEstimated Value\t\tPercent Difference from Actual");
	    while (x < 200) {
	        estimate = estimatePI(x);
	        System.out.print(x);
	        System.out.print("\t\t");
	        System.out.print(estimate);
	        System.out.print("\t\t");
	        System.out.print(percentDifference(Math.PI,estimate));
	        System.out.print("\n");
	        x++;
	    }
	     
	}
}