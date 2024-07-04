import java.util.Scanner;

public class Solution {

    private static void appendBrackets(StringBuilder builder, int count, char bracket) {
        for (int i = 0; i < count; i++) {
            builder.append(bracket);
        }
    }

    private static void appendOpeningBrackets(StringBuilder builder, int count) {
        appendBrackets(builder, count, '(');
    }

    private static void appendClosingBrackets(StringBuilder builder, int count) {
        appendBrackets(builder, count, ')');
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte totalTestCases = scanner.nextByte();
        scanner.nextLine();

        for (byte i = 0; i < totalTestCases; i++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int openBracketsCount = 0;

            for (int j = 0; j < input.length(); j++) {
                int currentDigit = input.charAt(j) - '0';

                appendOpeningBrackets(result, currentDigit - openBracketsCount);
                result.append(input.charAt(j));

                int closingBracketsCount;
                if (j + 1 >= input.length()) {
                    closingBracketsCount = currentDigit;
                } else {
                    int nextDigit = input.charAt(j + 1) - '0';
                    closingBracketsCount = Math.max(0, currentDigit - nextDigit);
                }

                openBracketsCount = currentDigit - closingBracketsCount;
                appendClosingBrackets(result, closingBracketsCount);
            }

            System.out.printf("Case #%d: %s%n", i + 1, result);
        }
    }
}