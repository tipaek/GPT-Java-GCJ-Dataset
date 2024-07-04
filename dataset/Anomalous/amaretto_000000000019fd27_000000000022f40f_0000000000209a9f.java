import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        while (testCases-- > 0) {
            String input = scanner.next();
            Stack<Character> stack = new Stack<>();
            StringBuilder result = new StringBuilder();
            
            // Push all characters of the input string into the stack
            for (char ch : input.toCharArray()) {
                stack.push(ch);
            }
            
            // Remove trailing zeros from the stack and append to result
            while (!stack.isEmpty() && stack.peek() == '0') {
                result.insert(0, stack.pop());
            }
            
            char prevChar = '0';
            int openCount = 0;
            
            // Process the remaining characters in the stack
            while (!stack.isEmpty()) {
                char currentChar = stack.pop();
                
                if (currentChar > prevChar) {
                    int diff = currentChar - prevChar;
                    for (int i = 0; i < diff; i++) {
                        result.insert(0, ')');
                        openCount++;
                    }
                    result.insert(0, currentChar);
                } else if (currentChar == prevChar) {
                    result.insert(0, currentChar);
                } else {
                    int diff = prevChar - currentChar;
                    for (int i = 0; i < diff; i++) {
                        result.insert(0, '(');
                        openCount--;
                    }
                    result.insert(0, currentChar);
                }
                
                prevChar = currentChar;
            }
            
            // Add remaining open parentheses to balance
            for (int i = 0; i < openCount; i++) {
                result.insert(0, '(');
            }
            
            System.out.println(result);
        }
        
        scanner.close();
    }
}