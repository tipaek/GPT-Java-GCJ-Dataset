import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < testCases; i++) {
            String inputString = scanner.nextLine();
            int[] digits = convertStringToDigits(inputString);
            String result = generateNestedParentheses(digits);
            System.out.println(result);
        }

        scanner.close();
    }

    private static int[] convertStringToDigits(String input) {
        char[] charArray = input.toCharArray();
        int[] digits = new int[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            digits[i] = charArray[i] - '0';
        }
        return digits;
    }

    private static String generateNestedParentheses(int[] digits) {
        StringBuilder resultBuilder = new StringBuilder();
        int pendingBraces = 0;
        int previousValue = 0;

        for (int digit : digits) {
            int braceDifference = previousValue - digit;

            if (braceDifference > 0) {
                closeBraces(resultBuilder, braceDifference);
            }

            if (braceDifference < 0) {
                openBraces(resultBuilder, -braceDifference);
            }

            resultBuilder.append(digit);
            previousValue = digit;
        }

        closeBraces(resultBuilder, pendingBraces);
        return resultBuilder.toString();
    }

    private static void openBraces(StringBuilder builder, int count) {
        for (int i = 0; i < count; i++) {
            builder.append("(");
        }
    }

    private static void closeBraces(StringBuilder builder, int count) {
        for (int i = 0; i < count; i++) {
            builder.append(")");
        }
    }
}