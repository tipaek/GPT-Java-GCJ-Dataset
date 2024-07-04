import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String openBrackets = "(((((((((((";
        String closeBrackets = ")))))))))))";

        int numberOfTestCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            String input = scanner.nextLine();
            StringBuilder output = new StringBuilder();
            int previousDepth = 0;

            for (int i = 0; i < input.length(); i++) {
                int currentDepth = Character.getNumericValue(input.charAt(i));

                if (currentDepth > previousDepth) {
                    output.append(openBrackets, 0, currentDepth - previousDepth);
                } else if (currentDepth < previousDepth) {
                    output.append(closeBrackets, 0, previousDepth - currentDepth);
                }

                output.append(currentDepth);
                previousDepth = currentDepth;
            }

            output.append(closeBrackets, 0, previousDepth);
            System.out.println("Case #" + testCase + ": " + output);
        }
    }
}