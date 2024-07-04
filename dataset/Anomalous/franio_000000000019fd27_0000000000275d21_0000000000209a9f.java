import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        
        for (int i = 0; i < t; i++) {
            String s = scanner.nextLine();
            Stack<Character> stack = new Stack<>();
            StringBuilder result = new StringBuilder();
            
            for (char c : s.toCharArray()) {
                int in = Character.getNumericValue(c);
                
                for (int j = 0; j < in; j++) {
                    if (!stack.isEmpty() && stack.peek() == ')') {
                        stack.pop();
                    } else {
                        stack.push('(');
                    }
                }
                
                stack.push(c);
                
                for (int j = 0; j < in; j++) {
                    stack.push(')');
                }
            }
            
            while (!stack.isEmpty()) {
                result.insert(0, stack.pop());
            }
            
            printResult(i, result.toString());
        }
        
        scanner.close();
    }

    private static void printResult(int caseNumber, String result) {
        System.out.println("Case #" + (caseNumber + 1) + ": " + result);
    }
}