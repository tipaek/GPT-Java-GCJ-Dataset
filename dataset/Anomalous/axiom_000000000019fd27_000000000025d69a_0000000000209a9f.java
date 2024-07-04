import java.util.*;
import java.io.*;

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

    private static String processString(String input, int additionalDepth) {
        StringBuilder resultBuilder = new StringBuilder();
        int startIndex = 0;

        for (int currentIndex = 0; currentIndex < input.length(); currentIndex++) {
            char currentChar = input.charAt(currentIndex);

            if (currentChar == '0') {
                String substring = input.substring(startIndex, currentIndex);
                String processedSubstring = insertParentheses(substring, additionalDepth);
                resultBuilder.append(processedSubstring);

                while (currentIndex < input.length() && input.charAt(currentIndex) == '0') {
                    resultBuilder.append('0');
                    currentIndex++;
                }

                startIndex = currentIndex;
            }
        }

        if (startIndex != input.length()) {
            String remainingSubstring = input.substring(startIndex);
            String processedRemaining = insertParentheses(remainingSubstring, additionalDepth);
            resultBuilder.append(processedRemaining);
        }

        return resultBuilder.toString();
    }

    private static String insertParentheses(String input, int additionalDepth) {
        if (input.isEmpty()) {
            return "";
        }

        int maxDigitIndex = 0;
        int maxDigit = 0;

        for (int i = 0; i < input.length(); i++) {
            int currentDigit = input.charAt(i) - '0';
            if (currentDigit > maxDigit) {
                maxDigit = currentDigit;
                maxDigitIndex = i;
            }
        }

        StringBuilder resultBuilder = new StringBuilder();
        resultBuilder.append((char) (maxDigit + additionalDepth + '0'));

        // Process left part
        int leftDepth = maxDigit;
        int minIndex = maxDigitIndex;

        for (int i = maxDigitIndex - 1; i >= 0; i--) {
            char currentChar = input.charAt(i);
            char previousChar = input.charAt(minIndex);

            if (currentChar <= previousChar) {
                for (int j = 0; j < previousChar - currentChar; j++) {
                    resultBuilder.insert(0, '(');
                }
                resultBuilder.insert(0, (char) (currentChar + additionalDepth));
                leftDepth = currentChar - '0';
                minIndex = i;
            } else {
                StringBuilder subBuilder = new StringBuilder();
                int j = i;
                while (j >= 0 && input.charAt(j) > previousChar) {
                    subBuilder.insert(0, (char) (input.charAt(j) - previousChar + '0'));
                    j--;
                }
                String subResult = processString(subBuilder.toString(), previousChar - '0' + additionalDepth);
                resultBuilder.insert(0, subResult);
                i = j + 1;
            }
        }

        while (leftDepth > 0) {
            resultBuilder.insert(0, '(');
            leftDepth--;
        }

        // Process right part
        int rightDepth = maxDigit;
        minIndex = maxDigitIndex;

        for (int i = maxDigitIndex + 1; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            char previousChar = input.charAt(minIndex);

            if (currentChar <= previousChar) {
                for (int j = 0; j < previousChar - currentChar; j++) {
                    resultBuilder.append(')');
                }
                resultBuilder.append((char) (currentChar + additionalDepth));
                rightDepth = currentChar - '0';
                minIndex = i;
            } else {
                StringBuilder subBuilder = new StringBuilder();
                int j = i;
                while (j < input.length() && input.charAt(j) > previousChar) {
                    subBuilder.append((char) (input.charAt(j) - previousChar + '0'));
                    j++;
                }
                String subResult = processString(subBuilder.toString(), previousChar - '0' + additionalDepth);
                resultBuilder.append(subResult);
                i = j - 1;
            }
        }

        while (rightDepth > 0) {
            resultBuilder.append(')');
            rightDepth--;
        }

        return resultBuilder.toString();
    }
}