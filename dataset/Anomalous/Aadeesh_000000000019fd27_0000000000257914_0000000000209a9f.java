import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;

            for (int i = 0; i < input.length(); i++) {
                int digit = Character.getNumericValue(input.charAt(i));

                if (digit > currentDepth) {
                    for (int j = 0; j < digit - currentDepth; j++) {
                        result.append('(');
                    }
                } else if (digit < currentDepth) {
                    for (int j = 0; j < currentDepth - digit; j++) {
                        result.append(')');
                    }
                }

                result.append(digit);
                currentDepth = digit;
            }

            // Close any remaining open parentheses
            for (int i = 0; i < currentDepth; i++) {
                result.append(')');
            }

            System.out.println("Case #" + caseNumber + ": " + result.toString());
        }
    }
}