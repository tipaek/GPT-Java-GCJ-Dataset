import java.io.*;
import java.util.*;

public class Solution {

    private static String appendCharacters(int count, String str, char ch) {
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < count; i++) {
            sb.append(ch);
        }
        return sb.toString();
    }

    private static String appendLeft(int count, String str) {
        return appendCharacters(count, str, '(');
    }

    private static String appendRight(int count, String str) {
        return appendCharacters(count, str, ')');
    }

    private static String generateParentheses(String input) {
        int[] digits = new int[input.length()];
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            digits[i] = input.charAt(i) - '0';
        }

        result.append(appendLeft(digits[0], ""));
        result.append(input.charAt(0));

        for (int i = 1; i < input.length(); i++) {
            if (digits[i] > digits[i - 1]) {
                result.append(appendLeft(digits[i] - digits[i - 1], ""));
            } else if (digits[i] < digits[i - 1]) {
                result.append(appendRight(digits[i - 1] - digits[i], ""));
            }
            result.append(input.charAt(i));
        }

        result.append(appendRight(digits[input.length() - 1], ""));
        return result.toString();
    }

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int cases = input.nextInt();

        for (int i = 0; i < cases; i++) {
            String x = input.next();
            System.out.println("Case #" + (i + 1) + ": " + generateParentheses(x));
        }

        input.close();
    }
}