import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            String input = scanner.next();
            int maxDepth = 0;
            char[] characters = input.toCharArray();
            int length = characters.length;
            int currentIndex = 0;
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < length; i++) {
                int currentDigit = characters[i] - '0';
                if (i == 0) {
                    maxDepth = currentDigit;
                    appendParentheses(result, currentDigit, '(');
                    result.append(characters[i]);
                    appendParentheses(result, currentDigit, ')');
                } else {
                    int previousDigit = characters[i - 1] - '0';
                    if (currentDigit >= previousDigit) {
                        int difference = currentDigit - previousDigit;
                        appendParentheses(result, difference, '(');
                        result.append(characters[i]);
                        appendParentheses(result, difference, ')');
                    } else {
                        int difference = previousDigit - currentDigit;
                        appendParentheses(result, difference, ')');
                        result.append(characters[i]);
                    }
                }
            }
            System.out.println("Case #" + caseNumber + ": " + result.toString());
            caseNumber++;
        }
        scanner.close();
        System.exit(0);
    }

    private static void appendParentheses(StringBuilder result, int count, char parenthesis) {
        for (int i = 0; i < count; i++) {
            result.append(parenthesis);
        }
    }
}