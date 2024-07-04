import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        for (int t = 0; t < testCases; t++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int previousDigit = 0;

            for (int i = 0; i < input.length(); i++) {
                int currentDigit = Character.getNumericValue(input.charAt(i));
                
                if (currentDigit > previousDigit) {
                    for (int j = 0; j < currentDigit - previousDigit; j++) {
                        result.append('(');
                    }
                } else if (currentDigit < previousDigit) {
                    for (int j = 0; j < previousDigit - currentDigit; j++) {
                        result.append(')');
                    }
                }
                
                result.append(currentDigit);
                previousDigit = currentDigit;
            }

            // Close any remaining open parentheses
            for (int j = 0; j < previousDigit; j++) {
                result.append(')');
            }

            System.out.println("Case #" + (t + 1) + ": " + result.toString());
        }

        scanner.close();
    }
}