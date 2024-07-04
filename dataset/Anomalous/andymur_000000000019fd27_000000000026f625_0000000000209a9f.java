import java.io.BufferedInputStream;
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
                System.out.println(processDigits(digits));
            }
        }
    }

    private static String processDigits(String digits) {
        StringBuilder result = new StringBuilder(digits.length() * 2);
        boolean isPreviousOne = false;

        for (char digit : digits.toCharArray()) {
            if (digit == ONE) {
                if (isPreviousOne) {
                    result.append(ONE);
                } else {
                    result.append(LEFT_PARENTHESIS).append(ONE);
                }
                isPreviousOne = true;
            } else if (digit == ZERO) {
                if (isPreviousOne) {
                    result.append(RIGHT_PARENTHESIS);
                }
                result.append(ZERO);
                isPreviousOne = false;
            }
        }

        if (isPreviousOne) {
            result.append(RIGHT_PARENTHESIS);
        }

        return result.toString();
    }
}