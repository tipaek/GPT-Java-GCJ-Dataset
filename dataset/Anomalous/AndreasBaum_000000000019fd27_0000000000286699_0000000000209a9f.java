import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();
        scanner.nextLine();  // Consume newline left-over

        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            String inputString = scanner.nextLine();
            char[] characters = inputString.toCharArray();
            StringBuilder outputBuilder = new StringBuilder();
            int currentDepth = 0;

            for (char character : characters) {
                int digit = Character.getNumericValue(character);

                if (digit < currentDepth) {
                    outputBuilder.append(")".repeat(currentDepth - digit));
                } else if (digit > currentDepth) {
                    outputBuilder.append("(".repeat(digit - currentDepth));
                }
                outputBuilder.append(digit);
                currentDepth = digit;
            }

            if (currentDepth > 0) {
                outputBuilder.append(")".repeat(currentDepth));
            }

            System.out.println("Case #" + testCase + ": " + outputBuilder);
        }

        scanner.close();
    }
}