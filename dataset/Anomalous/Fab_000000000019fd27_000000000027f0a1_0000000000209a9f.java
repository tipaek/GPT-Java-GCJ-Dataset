import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    private static final String OPEN_PAR = "(";
    private static final String CLOSE_PAR = ")";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= testCases; ++i) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int previousDigit = 0;

            for (int j = 0; j < input.length(); j++) {
                int currentDigit = Character.getNumericValue(input.charAt(j));

                if (j == 0) {
                    result.append(generateOpenParentheses(currentDigit));
                } else {
                    if (currentDigit > previousDigit) {
                        result.append(generateOpenParentheses(currentDigit - previousDigit));
                    } else if (currentDigit < previousDigit) {
                        result.append(generateCloseParentheses(previousDigit - currentDigit));
                    }
                }
                result.append(currentDigit);
                previousDigit = currentDigit;
            }

            result.append(generateCloseParentheses(previousDigit));
            System.out.println("Case #" + i + ": " + result.toString());
        }
    }

    private static String generateOpenParentheses(int count) {
        return OPEN_PAR.repeat(Math.max(0, count));
    }

    private static String generateCloseParentheses(int count) {
        return CLOSE_PAR.repeat(Math.max(0, count));
    }
}