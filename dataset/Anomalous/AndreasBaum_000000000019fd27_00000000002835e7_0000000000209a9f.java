import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            String input = scanner.nextLine();
            char[] digits = input.toCharArray();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;

            for (char digit : digits) {
                int value = Character.getNumericValue(digit);

                if (value > currentDepth) {
                    result.append("(".repeat(value - currentDepth));
                } else if (value < currentDepth) {
                    result.append(")".repeat(currentDepth - value));
                }

                result.append(value);
                currentDepth = value;
            }

            if (currentDepth > 0) {
                result.append(")".repeat(currentDepth));
            }

            System.out.println("Case #" + testCase + ": " + result);
        }
    }
}