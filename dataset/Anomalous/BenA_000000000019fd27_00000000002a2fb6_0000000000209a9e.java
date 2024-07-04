import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String inputLine;
        
        // Read all input lines until no more lines are available
        while (scanner.hasNext()) {
            inputLine = scanner.nextLine();
        }
        
        StringBuilder result = new StringBuilder();
        
        // Loop from 1 to 10
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
            result.append(scanner.nextLine());
            System.out.flush();
            System.exit(1);  // Exiting the program after the first iteration
        }
        
        // The following lines are commented out and will not execute
        // System.out.println(result.toString());
        // System.exit(1);
    }
}