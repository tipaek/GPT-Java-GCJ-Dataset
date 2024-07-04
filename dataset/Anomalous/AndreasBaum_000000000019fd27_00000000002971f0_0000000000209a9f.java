import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character after the integer input
        
        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;

            for (char character : input.toCharArray()) {
                int digit = Character.getNumericValue(character);

                if (digit > currentDepth) {
                    result.append("(".repeat(digit - currentDepth));
                } else if (digit < currentDepth) {
                    result.append(")".repeat(currentDepth - digit));
                }

                result.append(digit);
                currentDepth = digit;
            }

            if (currentDepth > 0) {
                result.append(")".repeat(currentDepth));
            }

            System.out.println("Case #" + testCase + ": " + result);
        }
        scanner.close();
    }
}