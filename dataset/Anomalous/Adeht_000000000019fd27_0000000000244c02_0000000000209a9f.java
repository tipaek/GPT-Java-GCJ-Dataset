import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int previousDigit = 0;

            for (char ch : input.toCharArray()) {
                int currentDigit = Character.getNumericValue(ch);
                
                // Add opening brackets if current digit is greater than previous digit
                for (int j = 0; j < currentDigit - previousDigit; j++) {
                    result.append('(');
                }
                
                // Add closing brackets if current digit is less than previous digit
                for (int j = 0; j < previousDigit - currentDigit; j++) {
                    result.append(')');
                }
                
                result.append(currentDigit);
                previousDigit = currentDigit;
            }
            
            // Close any remaining open brackets
            for (int j = 0; j < previousDigit; j++) {
                result.append(')');
            }
            
            System.out.println("Case #" + i + ": " + result.toString());
        }
        
        scanner.close();
    }
}