import java.util.*;
import java.io.*;

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

    private static String processInput(String input, int additionalDepth) {
        StringBuilder resultBuilder = new StringBuilder();
        int startIndex = 0;

        for (int currentIndex = 0; currentIndex < input.length(); currentIndex++) {
            char currentChar = input.charAt(currentIndex);
            if (currentChar == '0') {
                String segment = input.substring(startIndex, currentIndex);
                String processedSegment = addParentheses(segment, additionalDepth);
                resultBuilder.append(processedSegment);

                while (currentIndex < input.length() && input.charAt(currentIndex) == '0') {
                    resultBuilder.append('0');
                    currentIndex++;
                }
                startIndex = currentIndex;
            }
        }

        if (startIndex != input.length()) {
            String segment = input.substring(startIndex);
            String processedSegment = addParentheses(segment, additionalDepth);
            resultBuilder.append(processedSegment);
        }

        return resultBuilder.toString();
    }

    private static String addParentheses(String segment, int additionalDepth) {
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

        StringBuilder resultBuilder = new StringBuilder();
        resultBuilder.append((char) (maxDigit + additionalDepth + '0'));

        addLeftParentheses(segment, additionalDepth, maxDigitIndex, resultBuilder);
        addRightParentheses(segment, additionalDepth, maxDigitIndex, resultBuilder);

        return resultBuilder.toString();
    }

    private static void addLeftParentheses(String segment, int additionalDepth, int maxDigitIndex, StringBuilder resultBuilder) {
        int leftDepth = maxDigitIndex;
        int minIndex = maxDigitIndex;

        for (int i = maxDigitIndex - 1; i >= 0; i--) {
            char currentChar = segment.charAt(i);
            char previousChar = segment.charAt(minIndex);

            if (currentChar <= previousChar) {
                while (previousChar - currentChar > 0) {
                    resultBuilder.insert(0, '(');
                    previousChar--;
                }
                resultBuilder.insert(0, (char) (currentChar + additionalDepth));
                minIndex = i;
            } else {
                StringBuilder subSegment = new StringBuilder();
                int j = i;
                while (j >= 0 && segment.charAt(j) > previousChar) {
                    subSegment.insert(0, (char) (segment.charAt(j) - previousChar + '0'));
                    j--;
                }
                String processedSubSegment = processInput(subSegment.toString(), previousChar - '0' + additionalDepth);
                resultBuilder.insert(0, processedSubSegment);
                i = j + 1;
            }
        }

        while (leftDepth > 0) {
            resultBuilder.insert(0, '(');
            leftDepth--;
        }
    }

    private static void addRightParentheses(String segment, int additionalDepth, int maxDigitIndex, StringBuilder resultBuilder) {
        int rightDepth = maxDigitIndex;
        int minIndex = maxDigitIndex;

        for (int i = maxDigitIndex + 1; i < segment.length(); i++) {
            char currentChar = segment.charAt(i);
            char previousChar = segment.charAt(minIndex);

            if (currentChar <= previousChar) {
                while (previousChar - currentChar > 0) {
                    resultBuilder.append(')');
                    previousChar--;
                }
                resultBuilder.append((char) (currentChar + additionalDepth));
                minIndex = i;
            } else {
                StringBuilder subSegment = new StringBuilder();
                int j = i;
                while (j < segment.length() && segment.charAt(j) > previousChar) {
                    subSegment.append((char) (segment.charAt(j) - previousChar + '0'));
                    j++;
                }
                String processedSubSegment = processInput(subSegment.toString(), previousChar - '0' + additionalDepth);
                resultBuilder.append(processedSubSegment);
                i = j - 1;
            }
        }

        while (rightDepth > 0) {
            resultBuilder.append(')');
            rightDepth--;
        }
    }
}