import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.next();
            String result = processString(input, 0);
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    private static String processString(String input, int additionalDepth) {
        StringBuilder resultBuilder = new StringBuilder();
        int startIndex = 0;

        for (int currentIndex = 0; currentIndex < input.length(); currentIndex++) {
            char currentChar = input.charAt(currentIndex);

            if (currentChar == '0') {
                String substring = input.substring(startIndex, currentIndex);
                String processedSubstring = addParentheses(substring, additionalDepth);
                resultBuilder.append(processedSubstring);

                while (currentIndex < input.length() && input.charAt(currentIndex) == '0') {
                    resultBuilder.append('0');
                    currentIndex++;
                }
                startIndex = currentIndex;
            }
        }

        if (startIndex != input.length()) {
            String substring = input.substring(startIndex);
            String processedSubstring = addParentheses(substring, additionalDepth);
            resultBuilder.append(processedSubstring);
        }

        return resultBuilder.toString();
    }

    private static String addParentheses(String input, int additionalDepth) {
        if (input.isEmpty()) {
            return "";
        }

        int maxDigitIndex = 0;
        int maxDigit = 0;

        for (int i = 0; i < input.length(); i++) {
            int digit = input.charAt(i) - '0';
            if (digit > maxDigit) {
                maxDigit = digit;
                maxDigitIndex = i;
            }
        }

        StringBuilder resultBuilder = new StringBuilder();
        resultBuilder.append((char) (maxDigit + additionalDepth + '0'));

        // Process left side
        int leftDepth = maxDigit;
        int minIndex = maxDigitIndex;

        for (int i = maxDigitIndex - 1; i >= 0; i--) {
            char currentChar = input.charAt(i);
            char previousChar = input.charAt(minIndex);

            if (currentChar <= previousChar) {
                int depthDifference = previousChar - currentChar;
                for (int j = 0; j < depthDifference; j++) {
                    resultBuilder.insert(0, '(');
                }
                resultBuilder.insert(0, (char) (currentChar + additionalDepth));
                leftDepth = currentChar - '0';
                minIndex = i;
            } else {
                StringBuilder subStringBuilder = new StringBuilder();
                int j = i;
                while (j >= 0 && input.charAt(j) > previousChar) {
                    subStringBuilder.insert(0, (char) (input.charAt(j) - previousChar + '0'));
                    j--;
                }
                String subString = subStringBuilder.toString();
                String processedSubString = processString(subString, previousChar - '0' + additionalDepth);
                resultBuilder.insert(0, processedSubString);
                i = j + 1;
            }
        }

        while (leftDepth > 0) {
            resultBuilder.insert(0, '(');
            leftDepth--;
        }

        // Process right side
        int rightDepth = maxDigit;
        minIndex = maxDigitIndex;

        for (int i = maxDigitIndex + 1; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            char previousChar = input.charAt(minIndex);

            if (currentChar <= previousChar) {
                int depthDifference = previousChar - currentChar;
                for (int j = 0; j < depthDifference; j++) {
                    resultBuilder.append(')');
                }
                resultBuilder.append((char) (currentChar + additionalDepth));
                rightDepth = currentChar - '0';
                minIndex = i;
            } else {
                StringBuilder subStringBuilder = new StringBuilder();
                int j = i;
                while (j < input.length() && input.charAt(j) > previousChar) {
                    subStringBuilder.append((char) (input.charAt(j) - previousChar + '0'));
                    j++;
                }
                String subString = subStringBuilder.toString();
                String processedSubString = processString(subString, previousChar - '0' + additionalDepth);
                resultBuilder.append(processedSubString);
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