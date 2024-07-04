import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();
        
        for (int t = 0; t < testCases; t++) {
            String input = scanner.nextLine();
            int[] digits = new int[input.length()];
            Stack<Character> stack = new Stack<>();
            
            for (int j = 0; j < input.length(); j++) {
                digits[j] = Character.getNumericValue(input.charAt(j));
            }
            
            for (int j = 0; j < input.length(); j++) {
                int currentDigit = digits[j];
                int openBrackets = 0;
                
                if (!stack.isEmpty() && stack.peek() == ')') {
                    while (!stack.isEmpty() && stack.peek() == ')' && openBrackets < currentDigit) {
                        stack.pop();
                        openBrackets++;
                    }
                }
                
                int remainingBrackets = currentDigit - openBrackets;
                for (int n = 0; n < remainingBrackets; n++) {
                    stack.push('(');
                }
                stack.push((char) (currentDigit + '0'));
                for (int n = 0; n < currentDigit; n++) {
                    stack.push(')');
                }
            }
            
            System.out.print("Case #" + (t + 1) + ": ");
            for (Character ch : stack) {
                System.out.print(ch);
            }
            System.out.println();
        }
        
        scanner.close();
    }
}