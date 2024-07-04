import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            String input = scanner.next();
            String result = processInput(input, 0);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String processInput(String input, int addon) {
        StringBuilder result = new StringBuilder();
        int startIndex = 0;
        
        for (int currentIndex = 0; currentIndex < input.length(); currentIndex++) {
            char currentChar = input.charAt(currentIndex);
            if (currentChar == '0') {
                String substring = input.substring(startIndex, currentIndex);
                String processedSubstring = addParentheses(substring, addon);
                result.append(processedSubstring);
                while (currentIndex < input.length() && input.charAt(currentIndex) == '0') {
                    result.append('0');
                    currentIndex++;
                }
                startIndex = currentIndex;
            }
        }
        
        if (startIndex != input.length()) {
            String remainingSubstring = input.substring(startIndex);
            String processedRemainingSubstring = addParentheses(remainingSubstring, addon);
            result.append(processedRemainingSubstring);
        }
        
        return result.toString();
    }

    private static String addParentheses(String input, int addon) {
        if (input.isEmpty()) {
            return "";
        }
        
        int maxIndex = 0;
        int maxValue = 0;
        for (int i = 0; i < input.length(); i++) {
            int value = input.charAt(i) - '0';
            if (value > maxValue) {
                maxValue = value;
                maxIndex = i;
            }
        }
        
        StringBuilder result = new StringBuilder();
        result.append((char) (maxValue + addon + '0'));
        
        int leftValue = maxValue;
        for (int i = maxIndex - 1; i >= 0; i--) {
            char currentChar = input.charAt(i);
            char nextChar = input.charAt(i + 1);
            if (currentChar <= nextChar) {
                for (int j = 0; j < nextChar - currentChar; j++) {
                    result.insert(0, '(');
                }
                result.insert(0, currentChar);
                leftValue = currentChar - '0';
            } else {
                StringBuilder subResult = new StringBuilder();
                int j = i;
                while (j >= 0 && input.charAt(j) > nextChar) {
                    subResult.insert(0, (char) (input.charAt(j) - nextChar + '0'));
                    j--;
                }
                String subProcessed = processInput(subResult.toString(), nextChar - '0');
                result.insert(0, subProcessed);
            }
        }
        
        for (int i = 0; i < leftValue; i++) {
            result.insert(0, '(');
        }
        
        int rightValue = maxValue;
        for (int i = maxIndex + 1; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            char previousChar = input.charAt(i - 1);
            if (currentChar <= previousChar) {
                for (int j = 0; j < previousChar - currentChar; j++) {
                    result.append(')');
                }
                result.append(currentChar);
                rightValue = currentChar - '0';
            } else {
                StringBuilder subResult = new StringBuilder();
                int j = i;
                while (j < input.length() && input.charAt(j) > previousChar) {
                    subResult.append((char) (input.charAt(j) - previousChar + '0'));
                    j++;
                }
                String subProcessed = processInput(subResult.toString(), previousChar - '0');
                result.append(subProcessed);
            }
        }
        
        for (int i = 0; i < rightValue; i++) {
            result.append(')');
        }
        
        return result.toString();
    }
}