import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; ++i) {
            String input = scanner.next();
            String result = processInput(input, 0);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String processInput(String input, int depth) {
        StringBuilder result = new StringBuilder();
        int start = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '0') {
                result.append(addParentheses(input.substring(start, i), depth));
                while (i < input.length() && input.charAt(i) == '0') {
                    result.append('0');
                    i++;
                }
                start = i;
            }
        }
        if (start != input.length()) {
            result.append(addParentheses(input.substring(start), depth));
        }
        return result.toString();
    }

    private static String addParentheses(String segment, int depth) {
        if (segment.isEmpty()) {
            return "";
        }

        int maxDigitIndex = 0;
        int maxDigit = 0;
        for (int i = 0; i < segment.length(); i++) {
            int digit = segment.charAt(i) - '0';
            if (digit > maxDigit) {
                maxDigit = digit;
                maxDigitIndex = i;
            }
        }

        StringBuilder result = new StringBuilder();
        result.append((char) (maxDigit + depth + '0'));

        int leftDepth = maxDigit;
        int minIndex = maxDigitIndex;
        for (int i = maxDigitIndex - 1; i >= 0; i--) {
            char currentChar = segment.charAt(i);
            char previousChar = segment.charAt(minIndex);
            if (currentChar <= previousChar) {
                for (int j = 0; j < previousChar - currentChar; j++) {
                    result.insert(0, '(');
                }
                result.insert(0, (char) (currentChar + depth));
                leftDepth = currentChar - '0';
                minIndex = i;
            } else {
                StringBuilder subSegment = new StringBuilder();
                int j = i;
                while (j >= 0 && segment.charAt(j) > previousChar) {
                    subSegment.insert(0, (char) (segment.charAt(j) - previousChar + '0'));
                    j--;
                }
                result.insert(0, processInput(subSegment.toString(), previousChar - '0' + depth));
                i = j + 1;
            }
        }
        for (int i = 0; i < leftDepth; i++) {
            result.insert(0, '(');
        }

        int rightDepth = maxDigit;
        minIndex = maxDigitIndex;
        for (int i = maxDigitIndex + 1; i < segment.length(); i++) {
            char currentChar = segment.charAt(i);
            char previousChar = segment.charAt(minIndex);
            if (currentChar <= previousChar) {
                for (int j = 0; j < previousChar - currentChar; j++) {
                    result.append(')');
                }
                result.append((char) (currentChar + depth));
                rightDepth = currentChar - '0';
                minIndex = i;
            } else {
                StringBuilder subSegment = new StringBuilder();
                int j = i;
                while (j < segment.length() && segment.charAt(j) > previousChar) {
                    subSegment.append((char) (segment.charAt(j) - previousChar + '0'));
                    j++;
                }
                result.append(processInput(subSegment.toString(), previousChar - '0' + depth));
                i = j - 1;
            }
        }
        for (int i = 0; i < rightDepth; i++) {
            result.append(')');
        }

        return result.toString();
    }
}