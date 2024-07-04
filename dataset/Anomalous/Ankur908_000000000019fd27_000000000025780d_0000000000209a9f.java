import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTests = scanner.nextInt();

        for (int testIndex = 0; testIndex < numberOfTests; testIndex++) {
            String input = scanner.next();
            StringBuffer result = new StringBuffer(input);
            int length = result.length();

            for (int i = 0; i < length; i++) {
                int previousDigit = (i == 0) ? 0 : Character.getNumericValue(result.charAt(i - 1));
                int currentDigit = Character.getNumericValue(result.charAt(i));
                int nextDigit = (i + 1 == length) ? 0 : Character.getNumericValue(result.charAt(i + 1));

                int openParenthesesToAdd = currentDigit - previousDigit;
                int closeParenthesesToAdd = currentDigit - nextDigit;

                // Add open parentheses if needed
                if (openParenthesesToAdd > 0) {
                    for (int j = 0; j < openParenthesesToAdd; j++) {
                        result.insert(i, '(');
                        i++;
                        length++;
                    }
                }

                // Add close parentheses if needed
                if (closeParenthesesToAdd > 0) {
                    for (int j = 0; j < closeParenthesesToAdd; j++) {
                        result.insert(i + 1, ')');
                        i++;
                        length++;
                    }
                }
            }

            System.out.println("Case #" + (testIndex + 1) + ": " + result);
        }

        scanner.close();
    }
}