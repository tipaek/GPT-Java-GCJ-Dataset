import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            StringBuilder result = new StringBuilder();
            String inputString = scanner.next();
            int previousDigit = 0;

            for (int i = 0; i < inputString.length(); i++) {
                int currentDigit = Character.getNumericValue(inputString.charAt(i));
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

            System.out.println("Case #" + t + ": " + result);
        }
    }
}