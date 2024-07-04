import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 0; i < testCases; i++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            
            int previousDigit = 0;
            for (char ch : input.toCharArray()) {
                int currentDigit = Character.getNumericValue(ch);
                
                // Add opening parentheses if current digit is greater than previous
                for (int j = 0; j < currentDigit - previousDigit; j++) {
                    result.append('(');
                }
                
                // Add closing parentheses if current digit is less than previous
                for (int j = 0; j < previousDigit - currentDigit; j++) {
                    result.append(')');
                }
                
                // Append the current digit
                result.append(currentDigit);
                previousDigit = currentDigit;
            }
            
            // Close any remaining open parentheses
            for (int j = 0; j < previousDigit; j++) {
                result.append(')');
            }
            
            System.out.println("Case #" + (i + 1) + ": " + result.toString());
        }
        
        scanner.close();
    }
}