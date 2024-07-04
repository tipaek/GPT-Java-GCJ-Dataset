import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            String inputString = scanner.next();
            String result = processString(inputString, 0);
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
                resultBuilder.append(processedSubstring).append('0');
                startIndex = currentIndex + 1;
            }
        }
        
        if (startIndex != input.length()) {
            String remainingSubstring = input.substring(startIndex);
            String processedSubstring = addParentheses(remainingSubstring, additionalDepth);
            resultBuilder.append(processedSubstring);
        }
        
        return resultBuilder.toString();
    }

    private static String addParentheses(String input, int additionalDepth) {
        StringBuilder resultBuilder = new StringBuilder();
        
        for (int i = 0; i < input.length(); i++) {
            resultBuilder.append("(");
        }
        
        resultBuilder.append(input);
        
        for (int i = 0; i < input.length(); i++) {
            resultBuilder.append(")");
        }
        
        return resultBuilder.toString();
    }
}