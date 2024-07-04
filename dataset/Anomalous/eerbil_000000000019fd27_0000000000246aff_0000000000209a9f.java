import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = Integer.parseInt(scanner.nextLine());
        String[] results = new String[numberOfCases];
        
        for (int i = 0; i < numberOfCases; i++) {
            String input = scanner.nextLine();
            StringBuilder transformedString = new StringBuilder();
            
            for (int j = 0; j < input.length(); j++) {
                int digit = Character.getNumericValue(input.charAt(j));
                StringBuilder segment = new StringBuilder();
                
                for (int k = 0; k < digit; k++) {
                    segment.append("(");
                }
                segment.append(digit);
                for (int k = 0; k < digit; k++) {
                    segment.append(")");
                }
                
                transformedString.append(segment);
            }
            
            results[i] = removeRedundantParentheses(transformedString.toString());
        }
        
        for (int i = 0; i < numberOfCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results[i]);
        }
        
        scanner.close();
    }
    
    public static String removeRedundantParentheses(String str) {
        Stack<Character> stack = new Stack<>();
        stack.push(str.charAt(0));
        
        for (int i = 1; i < str.length(); i++) {
            if (stack.peek() == ')' && str.charAt(i) == '(') {
                stack.pop();
            } else {
                stack.push(str.charAt(i));
            }
        }
        
        StringBuilder finalString = new StringBuilder();
        for (Character ch : stack) {
            finalString.append(ch);
        }
        
        return finalString.toString();
    }
}