import java.io.BufferedInputStream;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

    private static final String LEFT_PARENTHESIS = "(";
    private static final String RIGHT_PARENTHESIS = ")";

    private static final Character ZERO = '0';
    private static final Character ONE = '1';

    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(new BufferedInputStream(System.in)
        )) {
            int testNumbers = strToInt(scanner.nextLine());

            for (int testNumber = 0 ; testNumber < testNumbers; testNumber++) {
                String digits = scanner.nextLine();
                System.out.println(String.format("Case #%d: %s", testNumber + 1 , solutionForZeroToTen(digits)));
            }
        }
    }

    private static String solutionForZeroToTen(String digits) {
        StringBuilder result = new StringBuilder(digits.length() * 3);
        int depth = 0;

        for (Character digitCh: digits.toCharArray()) {
            int digit = chrToInt(digitCh);
            if (depth == digit) {
            } else if (depth > digit) {
                int diff = depth - digit;
                result.append(copyNTimes(RIGHT_PARENTHESIS, diff));
            } else if (depth < digit) {
                int diff = digit - depth;
                result.append(copyNTimes(LEFT_PARENTHESIS, diff));
            }
            depth = digit;
            result.append(digitCh);
        }

        if (depth > 0) {
            result.append(copyNTimes(RIGHT_PARENTHESIS, depth));
        }

        return result.toString();
    }



    private static String copyNTimes(String symbol, int nTimes) {
        return String.join("", Collections.nCopies(nTimes, symbol));
    }

    private static String solutionForZeroToOne(String digits) {
        StringBuilder result = new StringBuilder(digits.length() * 2);
        boolean beforeIsOne = false;
        for (Character digit: digits.toCharArray()) {
            if (digit.equals(ONE)) {
                if (beforeIsOne) {
                    result.append(ONE);
                } else {
                    result.append(LEFT_PARENTHESIS).append(ONE);
                }
                beforeIsOne = true;
            } else if (digit.equals(ZERO)) {
                if (beforeIsOne) {
                    result.append(RIGHT_PARENTHESIS);
                }
                result.append(ZERO);
                beforeIsOne = false;
            }
        }

        if (beforeIsOne) {
            result.append(RIGHT_PARENTHESIS);
        }

        return result.toString();
    }

    private static int chrToInt(Character character) {
        return strToInt(character.toString());
    }

    private static int strToInt(String string) {
        return Integer.parseInt(string);
    }
}
