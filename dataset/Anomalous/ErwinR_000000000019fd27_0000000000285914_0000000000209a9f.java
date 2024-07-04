import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCases = sc.nextInt();
        // Loop through each test case
        for (int i = 0; i < testCases; i++) {
            int testCaseNumber = i + 1;
            String input = sc.next();
            StringBuilder result = new StringBuilder();

            int openBrackets = input.charAt(0) - '0';
            result.append("(".repeat(openBrackets));

            // Process each character in the input string
            for (int j = 0; j < input.length(); j++) {
                if (j > 0) {
                    int diff = input.charAt(j) - input.charAt(j - 1);
                    if (diff > 0) {
                        result.append("(".repeat(diff));
                    } else if (diff < 0) {
                        result.append(")".repeat(-diff));
                    }
                }
                result.append(input.charAt(j));
            }

            // Close remaining open brackets
            int closeBrackets = input.charAt(input.length() - 1) - '0';
            result.append(")".repeat(closeBrackets));

            // Print the result for the current test case
            System.out.println("Case #" + testCaseNumber + ": " + result);
        }
    }
}