import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            String number = scanner.next();
            StringBuilder result = new StringBuilder();
            int currentDigit = Character.getNumericValue(number.charAt(0));

            // Add opening brackets for the first digit
            result.append("(".repeat(currentDigit));
            result.append(currentDigit);

            // Process the rest of the digits
            for (int j = 1; j < number.length(); j++) {
                int nextDigit = Character.getNumericValue(number.charAt(j));

                if (nextDigit > currentDigit) {
                    result.append("(".repeat(nextDigit - currentDigit));
                } else if (nextDigit < currentDigit) {
                    result.append(")".repeat(currentDigit - nextDigit));
                }

                result.append(nextDigit);
                currentDigit = nextDigit;
            }

            // Add closing brackets for the last digit
            result.append(")".repeat(currentDigit));

            System.out.println("Case #" + (i + 1) + ": " + result);
        }

        scanner.close();
    }
}