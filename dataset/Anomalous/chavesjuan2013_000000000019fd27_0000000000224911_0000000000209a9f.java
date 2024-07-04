import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] inputChars = br.readLine().toCharArray();
        StringBuilder result = new StringBuilder();
        int openBrackets = charToDigit(inputChars[0]);

        appendBrackets(result, openBrackets, '(');

        for (int i = 0; i < inputChars.length - 1; i++) {
            int currentDigit = charToDigit(inputChars[i]);
            int nextDigit = charToDigit(inputChars[i + 1]);

            result.append(currentDigit);

            int difference = Math.abs(currentDigit - nextDigit);

            if (nextDigit > currentDigit) {
                appendBrackets(result, difference, '(');
            } else if (nextDigit < currentDigit) {
                appendBrackets(result, difference, ')');
            }
        }

        result.append(charToDigit(inputChars[inputChars.length - 1]));

        int closeBrackets = charToDigit(inputChars[inputChars.length - 1]);
        appendBrackets(result, closeBrackets, ')');

        System.out.println(result.toString());
    }

    private static int charToDigit(char c) {
        return c - '0';
    }

    private static void appendBrackets(StringBuilder sb, int count, char bracket) {
        for (int i = 0; i < count; i++) {
            sb.append(bracket);
        }
    }
}