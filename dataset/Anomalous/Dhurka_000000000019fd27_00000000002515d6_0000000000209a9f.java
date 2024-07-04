import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            String inputString = scanner.next();
            int number = Integer.parseInt(inputString);
            char[] characters = inputString.toCharArray();
            int length = characters.length;
            int currentDepth = 0;
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < length; i++) {
                int currentDigit = characters[i] - '0';

                if (i == 0) {
                    appendParentheses(result, currentDigit, 0);
                    result.append(currentDigit);
                    currentDepth = currentDigit;
                } else {
                    int previousDigit = characters[i - 1] - '0';
                    if (currentDigit > previousDigit) {
                        appendParentheses(result, currentDigit - previousDigit, 0);
                        result.append(currentDigit);
                        currentDepth = currentDigit;
                    } else if (currentDigit < previousDigit) {
                        appendParentheses(result, previousDigit - currentDigit, 1);
                        result.append(currentDigit);
                        currentDepth = currentDigit;
                    } else {
                        result.append(currentDigit);
                    }
                }
            }

            appendParentheses(result, currentDepth, 1);

            System.out.println("Case #" + caseNumber + ": " + result.toString());
            caseNumber++;
        }
    }

    private static void appendParentheses(StringBuilder result, int count, int type) {
        for (int i = 0; i < count; i++) {
            if (type == 0) {
                result.append('(');
            } else {
                result.append(')');
            }
        }
    }
}