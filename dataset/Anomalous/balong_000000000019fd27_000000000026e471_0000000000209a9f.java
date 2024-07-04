import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        processCases(scanner);
    }

    private static void processCases(Scanner scanner) {
        int numberOfCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character after the integer input

        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            String input = scanner.nextLine().trim();
            StringBuilder result = new StringBuilder();

            for (char c : input.toCharArray()) {
                int digit = Character.getNumericValue(c);
                StringBuilder temp = new StringBuilder(String.valueOf(c));
                for (int i = 0; i < digit; i++) {
                    temp.insert(0, '(').append(')');
                }
                result.append(temp);
            }

            // Simplify nested parentheses
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < result.length() - 1; j++) {
                    if (result.charAt(j) == ')' && result.charAt(j + 1) == '(') {
                        result.delete(j, j + 2);
                        j--; // Adjust the index after deletion
                    }
                }
            }

            System.out.println("Case #" + caseNumber + ": " + result.toString());
        }
    }
}