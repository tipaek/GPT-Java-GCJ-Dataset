import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int testCases = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            for (int caseIndex = 0; caseIndex < testCases; caseIndex++) {
                String input = scanner.nextLine();
                StringBuilder result = new StringBuilder();
                Stack<Character> parenthesesStack = new Stack<>();
                
                for (char digitChar : input.toCharArray()) {
                    int digit = digitChar - '0';
                    
                    while (parenthesesStack.size() > digit) {
                        parenthesesStack.pop();
                        result.append(')');
                    }
                    
                    while (parenthesesStack.size() < digit) {
                        parenthesesStack.push('(');
                        result.append('(');
                    }
                    
                    result.append(digitChar);
                }
                
                while (!parenthesesStack.isEmpty()) {
                    parenthesesStack.pop();
                    result.append(')');
                }
                
                System.out.println("Case #" + (caseIndex + 1) + ": " + result.toString());
            }
        }
        scanner.close();
    }
}