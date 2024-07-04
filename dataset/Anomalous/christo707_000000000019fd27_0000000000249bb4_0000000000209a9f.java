import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            String input = scanner.next();
            Stack<Character> resultStack = new Stack<>();
            int currentDepth = 0;
            
            for (char ch : input.toCharArray()) {
                int num = Character.getNumericValue(ch);
                
                if (num > currentDepth) {
                    for (int j = 0; j < num - currentDepth; j++) {
                        resultStack.push('(');
                    }
                } else if (num < currentDepth) {
                    for (int j = 0; j < currentDepth - num; j++) {
                        resultStack.push(')');
                    }
                }
                
                resultStack.push(ch);
                currentDepth = num;
            }
            
            while (currentDepth > 0) {
                resultStack.push(')');
                currentDepth--;
            }
            
            StringBuilder output = new StringBuilder("Case #" + i + ": ");
            for (char ch : resultStack) {
                output.append(ch);
            }
            System.out.println(output);
        }
    }
}