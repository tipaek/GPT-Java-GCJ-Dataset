import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            String input = scanner.next();
            System.out.println("Case #" + i + ": " + generateParentheses(input));
        }
    }

    public static String generateParentheses(String input) {
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;
        
        for (char ch : input.toCharArray()) {
            int digit = Character.getNumericValue(ch);
            
            while (currentDepth < digit) {
                result.append('(');
                currentDepth++;
            }
            while (currentDepth > digit) {
                result.append(')');
                currentDepth--;
            }
            
            result.append(ch);
        }
        
        while (currentDepth > 0) {
            result.append(')');
            currentDepth--;
        }
        
        return result.toString();
    }
}