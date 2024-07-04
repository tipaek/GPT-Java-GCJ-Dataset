import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        
        for (int testCaseIndex = 0; testCaseIndex < testCases; testCaseIndex++) {
            String input = reader.readLine();
            Stack<Character> stack = new Stack<>();
            
            for (int i = 0; i < input.length(); i++) {
                int currentDigit = Character.getNumericValue(input.charAt(i));
                
                for (int j = 0; j < currentDigit; j++) {
                    if (!stack.isEmpty() && stack.peek() == ')') {
                        stack.pop();
                    } else {
                        stack.push('(');
                    }
                }
                
                stack.push(input.charAt(i));
                
                for (int j = 0; j < currentDigit; j++) {
                    stack.push(')');
                }
            }
            
            StringBuilder result = new StringBuilder();
            for (char character : stack) {
                result.append(character);
            }
            
            System.out.printf("Case #%d: %s\n", testCaseIndex + 1, result.toString());
        }
    }
}