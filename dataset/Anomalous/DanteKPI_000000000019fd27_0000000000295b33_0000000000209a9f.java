import java.util.Scanner;

public class Solution {
    private static final String OPEN_PAREN = "(";
    private static final String CLOSE_PAREN = ")";

    public static String solve(char[] digits) {
        StringBuilder result = new StringBuilder();
        int previousDigit = 0;

        for (int i = 0; i < digits.length; i++) {
            int currentDigit = Character.getNumericValue(digits[i]);

            if (i == 0) {
                result.append(OPEN_PAREN.repeat(currentDigit));
                result.append(currentDigit);
                previousDigit = currentDigit;
                continue;
            }

            if (currentDigit == previousDigit) {
                result.append(currentDigit);
            } else if (currentDigit < previousDigit) {
                result.append(CLOSE_PAREN.repeat(previousDigit - currentDigit));
                result.append(currentDigit);
                previousDigit = currentDigit;
            } else {
                result.append(OPEN_PAREN.repeat(currentDigit - previousDigit));
                result.append(currentDigit);
                previousDigit = currentDigit;
            }
        }

        result.append(CLOSE_PAREN.repeat(previousDigit));
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();

        for (int test = 1; test <= numberOfTests; test++) {
            System.out.println("Case #" + test + ": " + solve(scanner.next().toCharArray()));
        }
    }
}