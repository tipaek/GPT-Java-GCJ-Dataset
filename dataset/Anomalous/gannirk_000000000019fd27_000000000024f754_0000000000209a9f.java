import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int previousDigit = input.charAt(0) - '0';

            // Add opening brackets for the first digit
            result.append("(".repeat(previousDigit)).append(previousDigit);

            for (int i = 1; i < input.length(); i++) {
                int currentDigit = input.charAt(i) - '0';

                if (currentDigit > previousDigit) {
                    // Add opening brackets
                    result.append("(".repeat(currentDigit - previousDigit));
                } else if (currentDigit < previousDigit) {
                    // Add closing brackets
                    result.append(")".repeat(previousDigit - currentDigit));
                }

                result.append(currentDigit);
                previousDigit = currentDigit;
            }

            // Add closing brackets for the last digit
            result.append(")".repeat(previousDigit));

            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }
}