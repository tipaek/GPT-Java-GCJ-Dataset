import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            StringBuilder result = new StringBuilder();
            String input = scanner.next();
            Stack<Character> stack = new Stack<>();
            int length = input.length();
            
            for (int i = 0; i < length; i++) {
                int currentDigit = input.charAt(i) - '0';
                int stackSize = stack.size();
                int difference = currentDigit - stackSize;
                
                if (difference > 0) {
                    for (int j = 0; j < difference; j++) {
                        stack.push('(');
                        result.append('(');
                    }
                } else if (difference < 0) {
                    for (int j = 0; j < -difference; j++) {
                        stack.pop();
                        result.append(')');
                    }
                }
                result.append(input.charAt(i));
            }
            
            while (!stack.isEmpty()) {
                stack.pop();
                result.append(')');
            }
            
            System.out.println("Case #" + t + ": " + result);
        }
        
        scanner.close();
    }
}