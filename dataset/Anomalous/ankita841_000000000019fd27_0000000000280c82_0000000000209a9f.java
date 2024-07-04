import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int q = 1; q <= testCases; q++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            Stack<Character> stack = new Stack<>();
            
            for (char ch : input.toCharArray()) {
                int digit = Character.getNumericValue(ch);
                
                for (int j = 0; j < digit; j++) {
                    stack.push('(');
                }
                
                stack.push(ch);
                
                for (int j = 0; j < digit; j++) {
                    stack.push(')');
                }
            }
            
            while (!stack.isEmpty()) {
                result.insert(0, stack.pop());
            }
            
            System.out.println(result);
        }
        
        scanner.close();
    }
}