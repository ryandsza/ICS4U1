import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the length of the array: ");
        int length = input.nextInt();
        
        int[] array = new int[length];
        int highest = -2147483648;
        int lowest = 2147483647;
        
        
        for (int i = 0; i < length; i++) {
            array[i] = (int) (Math.random() * 100);
            System.out.print(array[i] + " ");
            
            if (array[i] > highest) {
                highest = array[i];
            }
            if (array[i] < lowest) {
                lowest = array[i];
            }
        }
        
        System.out.println("\nHighest number in the array: " + highest);
        System.out.println("Lowest number in the array: " + lowest);
    }

}
