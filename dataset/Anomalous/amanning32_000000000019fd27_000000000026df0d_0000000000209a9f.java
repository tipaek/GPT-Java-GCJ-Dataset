import java.util.Scanner;

public class Solution {

    private static String calculate(String input) {
        StringBuilder result = new StringBuilder();
        int previousDigit = 0;
        
        for (int i = 0; i < input.length(); i++) {
            int currentDigit = Character.getNumericValue(input.charAt(i));
            int difference = currentDigit - previousDigit;
            
            if (difference > 0) {
                result.append("(".repeat(difference));
            } else if (difference < 0) {
                result.append(")".repeat(-difference));
            }
            
            result.append(currentDigit);
            previousDigit = currentDigit;
        }
        
        result.append(")".repeat(previousDigit));
        
        return result.toString();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine(); // consume the newline character
        
        for (int i = 1; i <= testCases; i++) {
            String input = scanner.nextLine();
            String output = calculate(input);
            System.out.println("Case #" + i + ": " + output);
        }
        
        scanner.close();
    }
}