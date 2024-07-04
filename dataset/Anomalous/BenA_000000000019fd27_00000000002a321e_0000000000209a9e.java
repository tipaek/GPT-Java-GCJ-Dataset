import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String input = null;
        
        // Read all inputs until no more inputs are available
        while (scanner.hasNext()) {
            input = scanner.next();
        }
        
        // Exit the program
        System.exit(1);
        
        StringBuilder result = new StringBuilder();
        
        // Loop to print numbers from 1 to 10 and read lines from input
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
            result.append(scanner.nextLine());
            System.out.flush();
        }
        
        // Note: The following lines are commented out as in the original code
        // System.out.println(result.toString());
        // System.exit(1);
    }
}