import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String inputLine;
        
        // Read all the input lines until no more lines are available
        while (scanner.hasNext()) {
            inputLine = scanner.nextLine();
        }
        
        StringBuilder result = new StringBuilder();
        
        // Loop from 1 to 10, print the number and read a line from input
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
            result.append(scanner.nextLine());
            System.out.flush();
        }
        
        // Print the concatenated result
        System.out.println(result.toString());
        System.out.flush();
        
        // Read one more line and print it
        inputLine = scanner.nextLine();
        System.out.println(inputLine);
        
        // Exit the program
        System.exit(0);
    }
}