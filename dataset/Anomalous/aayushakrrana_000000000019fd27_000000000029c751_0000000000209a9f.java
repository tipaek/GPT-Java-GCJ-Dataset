import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; ++i) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int previousDigit = 0;

            for (char ch : input.toCharArray()) {
                int currentDigit = Character.getNumericValue(ch);
                int difference = currentDigit - previousDigit;

                if (difference > 0) {
                    result.append("(".repeat(difference));
                } else if (difference < 0) {
                    result.append(")".repeat(-difference));
                }

                result.append(currentDigit);
                previousDigit = currentDigit;
            }

            result.append(")".repeat(previousDigit));

            System.out.println("Case #" + i + ": " + result.toString());
        }

        scanner.close();
    }
}