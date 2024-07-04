import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read number of test cases
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            // Read the value
            String value = scanner.next();
            StringBuilder result = new StringBuilder();

            int currentDepth = 0;
            for (char c : value.toCharArray()) {
                int newDepth = c - '0';

                if (newDepth > currentDepth) {
                    result.append("(".repeat(newDepth - currentDepth));
                } else if (newDepth < currentDepth) {
                    result.append(")".repeat(currentDepth - newDepth));
                }

                result.append(c);
                currentDepth = newDepth;
            }

            // Close any remaining open parentheses
            result.append(")".repeat(currentDepth));

            System.out.println("Case #" + i + ": " + result);
        }
    }
}