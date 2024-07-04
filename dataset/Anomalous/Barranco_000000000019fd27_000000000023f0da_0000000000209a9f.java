import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalCases = Integer.parseInt(scanner.next());
        
        for (int currentCase = 1; currentCase <= totalCases; currentCase++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int previousDigit = 0;
            
            for (char ch : input.toCharArray()) {
                int currentDigit = Character.getNumericValue(ch);
                
                // Add opening parentheses if needed
                while (previousDigit < currentDigit) {
                    result.append('(');
                    previousDigit++;
                }
                
                // Add closing parentheses if needed
                while (previousDigit > currentDigit) {
                    result.append(')');
                    previousDigit--;
                }
                
                // Append the current digit
                result.append(currentDigit);
            }
            
            // Close any remaining open parentheses
            while (previousDigit > 0) {
                result.append(')');
                previousDigit--;
            }
            
            System.out.println("Case #" + currentCase + ": " + result.toString());
        }
        
        scanner.close();
    }
}