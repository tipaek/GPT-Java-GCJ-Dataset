import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            String input = scanner.next();
            char[] characters = input.toCharArray();

            StringBuilder result = new StringBuilder();
            int previousDigit = 0;

            for (char character : characters) {
                int currentDigit = character - '0';
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

            System.out.println(String.format("Case #%d: %s", t, result.toString()));
        }
    }
}