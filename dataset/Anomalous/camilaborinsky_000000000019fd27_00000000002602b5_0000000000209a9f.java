import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        String[] results = new String[testCases];

        for (int i = 0; i < testCases; i++) {
            String input = scanner.next();
            results[i] = generateBalancedString(input);
            System.out.println("Case #" + (i + 1) + ": " + results[i]);
        }
    }

    public static String generateBalancedString(String input) {
        StringBuilder result = new StringBuilder();
        int balance = 0;

        for (int i = 0; i < input.length(); i++) {
            int currentDigit = Character.getNumericValue(input.charAt(i));
            int nextDigit = (i < input.length() - 1) ? Character.getNumericValue(input.charAt(i + 1)) : 0;

            // Add opening brackets if needed
            while (balance < currentDigit) {
                result.append("(");
                balance++;
            }

            // Add closing brackets if needed
            while (balance > currentDigit) {
                result.append(")");
                balance--;
            }

            // Append the current digit
            result.append(currentDigit);

            // Adjust balance for the next digit
            if (i == input.length() - 1) {
                while (balance > 0) {
                    result.append(")");
                    balance--;
                }
            }
        }

        return result.toString();
    }
}