import java.io.BufferedInputStream;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

    private static final String LEFT_PARENTHESIS = "(";
    private static final String RIGHT_PARENTHESIS = ")";
    private static final char ZERO = '0';
    private static final char ONE = '1';

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedInputStream(System.in))) {
            int testCases = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < testCases; i++) {
                String digits = scanner.nextLine();
                System.out.println(String.format("Case #%d: %s", i + 1, processDigits(digits)));
            }
        }
    }

    private static String processDigits(String digits) {
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (char digitChar : digits.toCharArray()) {
            int digit = Character.getNumericValue(digitChar);
            if (currentDepth < digit) {
                result.append(repeatString(LEFT_PARENTHESIS, digit - currentDepth));
            } else if (currentDepth > digit) {
                result.append(repeatString(RIGHT_PARENTHESIS, currentDepth - digit));
            }
            currentDepth = digit;
            result.append(digitChar);
        }

        if (currentDepth > 0) {
            result.append(repeatString(RIGHT_PARENTHESIS, currentDepth));
        }

        return result.toString();
    }

    private static String repeatString(String str, int times) {
        return String.join("", Collections.nCopies(times, str));
    }

    private static String processBinaryDigits(String digits) {
        StringBuilder result = new StringBuilder();
        boolean isOne = false;

        for (char digit : digits.toCharArray()) {
            if (digit == ONE) {
                if (isOne) {
                    result.append(ONE);
                } else {
                    result.append(LEFT_PARENTHESIS).append(ONE);
                }
                isOne = true;
            } else if (digit == ZERO) {
                if (isOne) {
                    result.append(RIGHT_PARENTHESIS);
                }
                result.append(ZERO);
                isOne = false;
            }
        }

        if (isOne) {
            result.append(RIGHT_PARENTHESIS);
        }

        return result.toString();
    }
}