import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            String input = scanner.next();
            String result = processString(input, 0);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String processString(String str, int addon) {
        StringBuilder result = new StringBuilder();
        int start = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                String segment = str.substring(start, i);
                result.append(encloseWithParentheses(segment, addon));
                while (i < str.length() && str.charAt(i) == '0') {
                    result.append('0');
                    i++;
                }
                start = i;
            }
        }
        if (start != str.length()) {
            String segment = str.substring(start);
            result.append(encloseWithParentheses(segment, addon));
        }
        return result.toString();
    }

    private static String encloseWithParentheses(String str, int addon) {
        if (str.isEmpty()) {
            return "";
        }

        int maxCharIndex = 0;
        int maxCharValue = 0;
        for (int i = 0; i < str.length(); i++) {
            int value = str.charAt(i) - '0';
            if (value > maxCharValue) {
                maxCharValue = value;
                maxCharIndex = i;
            }
        }

        StringBuilder result = new StringBuilder();
        result.append((char) (maxCharValue + addon + '0'));

        // Process left part
        int leftValue = maxCharValue;
        for (int i = maxCharIndex - 1; i >= 0; i--) {
            char currentChar = str.charAt(i);
            char previousChar = str.charAt(i + 1);
            if (currentChar <= previousChar) {
                int diff = previousChar - currentChar;
                while (diff-- > 0) {
                    result.insert(0, '(');
                }
                result.insert(0, (char) (currentChar + addon));
                leftValue = currentChar - '0';
            } else {
                StringBuilder subSegment = new StringBuilder();
                while (i >= 0 && str.charAt(i) > previousChar) {
                    subSegment.insert(0, (char) (str.charAt(i) - previousChar + '0'));
                    i--;
                }
                result.insert(0, processString(subSegment.toString(), previousChar - '0'));
            }
        }
        while (leftValue-- > 0) {
            result.insert(0, '(');
        }

        // Process right part
        int rightValue = maxCharValue;
        for (int i = maxCharIndex + 1; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            char previousChar = str.charAt(i - 1);
            if (currentChar <= previousChar) {
                int diff = previousChar - currentChar;
                while (diff-- > 0) {
                    result.append(')');
                }
                result.append((char) (currentChar + addon));
                rightValue = currentChar - '0';
            } else {
                StringBuilder subSegment = new StringBuilder();
                while (i < str.length() && str.charAt(i) > previousChar) {
                    subSegment.append((char) (str.charAt(i) - previousChar + '0'));
                    i++;
                }
                result.append(processString(subSegment.toString(), previousChar - '0'));
            }
        }
        while (rightValue-- > 0) {
            result.append(')');
        }

        return result.toString();
    }
}