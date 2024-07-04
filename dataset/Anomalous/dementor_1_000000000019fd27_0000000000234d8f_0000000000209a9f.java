import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

    // Method to append 'num' number of opening parentheses to the StringBuilder
    static void appendOpenParentheses(StringBuilder builder, int num) {
        for (int i = 0; i < num; i++) {
            builder.append('(');
        }
    }

    // Method to append 'num' number of closing parentheses to the StringBuilder
    static void appendCloseParentheses(StringBuilder builder, int num) {
        for (int i = 0; i < num; i++) {
            builder.append(')');
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int i = 1; i <= testCases; i++) {
            StringBuilder result = new StringBuilder();
            char[] digits = reader.readLine().toCharArray();
            int length = digits.length;
            int openParentheses = 0;
            int currentCount = 0;
            int previousDigit = 0;
            int currentDigit;

            if (digits[0] == '0') {
                result.append(0);
            } else {
                currentCount = digits[0] - '0';
                appendOpenParentheses(result, currentCount);
                openParentheses = currentCount;
                result.append(currentCount);
            }
            previousDigit = currentCount;

            for (int j = 1; j < length; j++) {
                currentDigit = digits[j] - '0';
                if (previousDigit < currentDigit) {
                    currentCount = currentDigit - openParentheses;
                    appendOpenParentheses(result, currentCount);
                    openParentheses += currentCount;
                } else if (previousDigit > currentDigit) {
                    currentCount = openParentheses - currentDigit;
                    appendCloseParentheses(result, currentCount);
                    openParentheses -= currentCount;
                }
                result.append(currentDigit);
                previousDigit = currentDigit;
            }
            appendCloseParentheses(result, openParentheses);
            System.out.printf("Case #%d: %s\n", i, result.toString());
        }
    }
}