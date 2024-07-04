import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        // Read the first line of input
        String initialInput = scanner.nextLine();
        
        // Initialize an empty string to accumulate answers
        StringBuilder accumulatedAnswers = new StringBuilder();
        
        // Loop from 1 to 10
        for (int i = 1; i <= 10; i++) {
            // Print the current number
            System.out.println(i);
            
            // Read the next line of input and append it to accumulatedAnswers
            accumulatedAnswers.append(scanner.nextLine());
            
            // Ensure the output is flushed
            System.out.flush();
        }
        
        // Print the accumulated answers
        System.out.println(accumulatedAnswers.toString());
        System.out.flush();
        
        // Read another line of input
        String finalInput = scanner.nextLine();
        
        // Print the final input
        System.out.println(finalInput);
    }
}