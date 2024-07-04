import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        String[] results = new String[T];

        for (int i = 0; i < T; i++) {
            String input = in.next();
            results[i] = processInput(input);
        }

        for (int i = 0; i < results.length; i++) {
            System.out.printf("Case #%d: %s%n", i + 1, results[i]);
        }
    }

    private static String processInput(String input) {
        StringBuilder result = new StringBuilder();
        int openCount = 0;

        for (int j = 0; j < input.length();) {
            int currentDigit = charToDigit(input.charAt(j));
            int openRequired = currentDigit - openCount;

            appendChars(result, '(', openRequired);
            result.append(currentDigit);

            int nextIndex = findNextDifferent(input, j + 1, currentDigit);
            int closeRequired = calculateCloseRequired(input, nextIndex, currentDigit, openCount + openRequired);

            appendChars(result, ')', closeRequired);
            openCount = openCount + openRequired - closeRequired;
            j = nextIndex;
        }

        return result.toString();
    }

    private static int charToDigit(char character) {
        return character - '0';
    }

    private static int findNextDifferent(String input, int startIndex, int currentDigit) {
        for (int i = startIndex; i < input.length(); i++) {
            if (charToDigit(input.charAt(i)) != currentDigit) {
                return i;
            }
        }
        return input.length();
    }

    private static int calculateCloseRequired(String input, int nextIndex, int currentDigit, int openCount) {
        if (nextIndex >= input.length()) {
            return openCount;
        }

        int nextDigit = charToDigit(input.charAt(nextIndex));
        return Math.max(0, currentDigit - nextDigit);
    }

    private static void appendChars(StringBuilder sb, char ch, int count) {
        for (int i = 0; i < count; i++) {
            sb.append(ch);
        }
    }
}