import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int numberOfTestCases = scanner.nextInt();
            for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
                String inputString = scanner.next();
                String balancedString = generateBalancedString(inputString);
                System.out.println("Case #" + testCase + ": " + balancedString);
            }
        }
    }

    private static String generateBalancedString(String input) {
        StringBuilder result = new StringBuilder();
        int currentBalance = 0;

        for (char character : input.toCharArray()) {
            int requiredBalance = character - '0';

            while (currentBalance < requiredBalance) {
                result.append('(');
                currentBalance++;
            }

            while (currentBalance > requiredBalance) {
                result.append(')');
                currentBalance--;
            }

            result.append(character);
        }

        while (currentBalance > 0) {
            result.append(')');
            currentBalance--;
        }

        return result.toString();
    }
}