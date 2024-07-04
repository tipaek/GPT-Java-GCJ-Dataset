import java.util.Scanner;
import java.util.Stack;

class Solution {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int c = 1; c <= t; c++) {
            String str = sc.next();
            Stack<Character> stack = new Stack<>();
            int currentNumber = Character.getNumericValue(str.charAt(0));
            int openBrackets = currentNumber;
            
            // Push initial open brackets and first character
            for (int i = 0; i < currentNumber; i++) {
                stack.push('(');
            }
            stack.push(str.charAt(0));
            
            // Process the rest of the string
            for (int i = 1; i < str.length(); i++) {
                int previousNumber = Character.getNumericValue(str.charAt(i - 1));
                int currentDigit = Character.getNumericValue(str.charAt(i));
                
                if (currentDigit > previousNumber) {
                    int diff = currentDigit - previousNumber;
                    openBrackets += diff;
                    for (int j = 0; j < diff; j++) {
                        stack.push('(');
                    }
                } else if (currentDigit < previousNumber) {
                    int diff = previousNumber - currentDigit;
                    openBrackets -= diff;
                    for (int j = 0; j < diff; j++) {
                        stack.push(')');
                    }
                }
                stack.push(str.charAt(i));
            }
            
            // Close remaining open brackets
            for (int i = 0; i < openBrackets; i++) {
                stack.push(')');
            }
            
            // Build the final output string
            StringBuilder output = new StringBuilder();
            while (!stack.isEmpty()) {
                output.insert(0, stack.pop());
            }
            
            System.out.println("Case #" + c + ": " + output.toString());
        }
        
        sc.close();
    }
}