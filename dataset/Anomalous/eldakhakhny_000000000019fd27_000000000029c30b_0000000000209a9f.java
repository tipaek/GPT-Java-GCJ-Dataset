import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; ++i) {
            String input = scanner.next();
            StringBuilder resultBuilder = new StringBuilder();
            
            for (int j = 0; j < input.length(); j++) {
                char currentChar = input.charAt(j);
                int digit = Character.getNumericValue(currentChar);
                
                resultBuilder.append(generateOpeningBrackets(digit))
                             .append(currentChar)
                             .append(generateClosingBrackets(digit));
            }
            
            String paddedString = resultBuilder.toString();
            String minimizedString = minimizeParentheses(paddedString);
            System.out.println("Case #" + i + ": " + minimizedString);
        }
    }

    private static String generateOpeningBrackets(int count) {
        return "(".repeat(count);
    }

    private static String generateClosingBrackets(int count) {
        return ")".repeat(count);
    }

    private static String minimizeParentheses(String input) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : input.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == ')' && c == '(') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        
        StringBuilder minimizedBuilder = new StringBuilder();
        for (char c : stack) {
            minimizedBuilder.append(c);
        }
        
        return minimizedBuilder.toString();
    }
}