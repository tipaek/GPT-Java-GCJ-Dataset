import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int test = 1; test <= t; test++) {
            String str = scanner.next();
            Stack<Character> stack = new Stack<>();
            
            // Push all characters of the string into the stack
            for (char ch : str.toCharArray()) {
                stack.push(ch);
            }
            
            StringBuilder result = new StringBuilder();
            int openBrackets = 0;
            
            // Remove trailing zeros from the stack and append to result
            while (!stack.isEmpty() && stack.peek() == '0') {
                result.insert(0, stack.pop());
            }
            
            char prev = '0';
            while (!stack.isEmpty()) {
                char current = stack.pop();
                
                if (current > prev) {
                    int diff = current - prev;
                    for (int i = 0; i < diff; i++) {
                        result.insert(0, ')');
                        openBrackets++;
                    }
                } else if (current < prev) {
                    int diff = prev - current;
                    for (int i = 0; i < diff; i++) {
                        result.insert(0, '(');
                        openBrackets--;
                    }
                }
                
                result.insert(0, current);
                prev = current;
            }
            
            // Add necessary opening brackets at the beginning
            for (int i = 0; i < openBrackets; i++) {
                result.insert(0, '(');
            }
            
            System.out.println("Case #" + test + ": " + result);
        }
        
        scanner.close();
    }
}