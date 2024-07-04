import java.util.*;
import java.io.*;

public class Solution {
    private static final String OUTPUT_FORMAT = "Case #%d: %s";
    private static final String LEFT_PARENTHESIS = "(";
    private static final String RIGHT_PARENTHESIS = ")";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int testCaseNumber = 1; testCaseNumber <= testCases; testCaseNumber++) {
            String input = scanner.nextLine().trim();
            int[] digits = new int[input.length()];

            for (int i = 0; i < input.length(); i++) {
                digits[i] = Character.getNumericValue(input.charAt(i));
            }

            StringBuilder result = new StringBuilder();

            for (int i = 0; i < digits.length; i++) {
                int currentDigit = digits[i];

                if (currentDigit == 0) {
                    result.append(currentDigit);
                } else {
                    if (i == 0) {
                        result.append(createSurroundedDigit(currentDigit, currentDigit));
                    } else {
                        int previousDigit = digits[i - 1];
                        if (previousDigit == currentDigit) {
                            int position = result.lastIndexOf(String.valueOf(previousDigit));
                            result.insert(position + 1, currentDigit);
                        } else if (previousDigit < currentDigit) {
                            int difference = currentDigit - previousDigit;
                            int position = result.lastIndexOf(String.valueOf(previousDigit));
                            result.insert(position + 1, createSurroundedDigit(difference, currentDigit));
                        } else {
                            int difference = previousDigit - currentDigit;
                            result.insert(result.length() - difference, currentDigit);
                        }
                    }
                }
            }

            System.out.println(String.format(OUTPUT_FORMAT, testCaseNumber, result.toString()));
        }
    }

    private static String createSurroundedDigit(int count, int digit) {
        StringBuilder sb = new StringBuilder();
        sb.append(repeatString(count, LEFT_PARENTHESIS));
        sb.append(digit);
        sb.append(repeatString(count, RIGHT_PARENTHESIS));
        return sb.toString();
    }

    private static String repeatString(int count, String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}