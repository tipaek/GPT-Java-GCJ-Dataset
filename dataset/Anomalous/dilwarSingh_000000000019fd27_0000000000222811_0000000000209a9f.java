import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        scanner.nextLine();
        
        for (int i = 1; i <= testCaseCount; i++) {
            String inputString = scanner.nextLine();
            int[] digits = convertStringToDigits(inputString);
            String result = processDigits(digits);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static int[] convertStringToDigits(String input) {
        char[] charArray = input.toCharArray();
        int[] digits = new int[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            digits[i] = charArray[i] - '0';
        }
        return digits;
    }

    private static int pendingBraces = 0;

    private static String processDigits(int[] digits) {
        StringBuilder resultBuilder = new StringBuilder();
        pendingBraces = 0;
        int previousValue = 0;

        for (int i = 0; i < digits.length; i++) {
            int currentValue = digits[i];
            int braceDifference = previousValue - currentValue;

            if (i > 0 && braceDifference > 0) {
                closeBraces(resultBuilder, braceDifference);
            }

            if (braceDifference < 0) {
                openBraces(resultBuilder, -braceDifference);
            }

            resultBuilder.append(currentValue);
            previousValue = currentValue;
        }

        closeBraces(resultBuilder, pendingBraces);
        return resultBuilder.toString();
    }

    private static void openBraces(StringBuilder builder, int count) {
        for (int i = 0; i < count; i++) {
            builder.append("(");
            pendingBraces++;
        }
    }

    private static void closeBraces(StringBuilder builder, int count) {
        for (int i = 0; i < count; i++) {
            builder.append(")");
            pendingBraces--;
        }
    }
}