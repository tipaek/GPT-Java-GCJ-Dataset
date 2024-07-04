import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    private static String transformString(String input) {
        input += "0";  // Append '0' to the input string
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (int i = 0; i < input.length(); i++) {
            int targetDepth = Character.getNumericValue(input.charAt(i));
            int depthDifference = currentDepth - targetDepth;

            // Append the necessary number of '(' or ')' to balance the depth
            for (int j = 0; j < Math.abs(depthDifference); j++) {
                result.append(depthDifference < 0 ? '(' : ')');
            }

            result.append(targetDepth);
            currentDepth = targetDepth;
        }

        return result.substring(0, result.length() - 1);  // Remove the last appended '0'
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();  // Consume the remaining newline

        for (int i = 1; i <= testCases; ++i) {
            String input = scanner.nextLine();
            System.out.println("Case #" + i + ": " + transformString(input));
        }
    }
}