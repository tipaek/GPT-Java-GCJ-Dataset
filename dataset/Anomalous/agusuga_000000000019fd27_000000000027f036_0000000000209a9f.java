import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            String inputString = scanner.nextLine();
            int currentLevel = 0;

            StringBuilder result = new StringBuilder();
            result.append("Case #").append(caseIndex + 1).append(": ");

            for (int charIndex = 0; charIndex < inputString.length(); charIndex++) {
                int currentDigit = Character.getNumericValue(inputString.charAt(charIndex));
                
                // Add opening parentheses if needed
                while (currentLevel < currentDigit) {
                    result.append("(");
                    currentLevel++;
                }
                
                // Add closing parentheses if needed
                while (currentLevel > currentDigit) {
                    result.append(")");
                    currentLevel--;
                }
                
                result.append(currentDigit);
            }
            
            // Close any remaining open parentheses
            while (currentLevel > 0) {
                result.append(")");
                currentLevel--;
            }
            
            System.out.println(result.toString());
        }
    }
}