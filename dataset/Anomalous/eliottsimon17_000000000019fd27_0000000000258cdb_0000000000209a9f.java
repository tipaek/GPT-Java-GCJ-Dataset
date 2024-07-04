import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCount = Integer.parseInt(scanner.next());
        scanner.nextLine(); // Consume the remaining newline
        
        for (int i = 0; i < testCount; i++) {
            String input = scanner.nextLine();
            String result = processBrackets(input);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }

    public static String processBrackets(String input) {
        StringBuilder result = new StringBuilder();
        boolean insideBrackets = false;

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            int digit = Character.getNumericValue(currentChar);

            if (digit == 1 && !insideBrackets) {
                result.append('(').append(currentChar);
                insideBrackets = true;
            } else if (digit == 1 && insideBrackets) {
                result.append(currentChar);
            } else if (digit == 0 && insideBrackets) {
                result.append(')').append(currentChar);
                insideBrackets = false;
            } else {
                result.append(currentChar);
            }
        }

        // Close any remaining open bracket
        if (insideBrackets) {
            result.append(')');
        }

        return result.toString();
    }
}