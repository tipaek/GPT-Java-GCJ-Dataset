import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int number = scanner.nextInt();
            String result = insertParentheses(Integer.toString(number));
            System.out.println("Case #" + t + ": " + result);
        }
        
        scanner.close();
    }

    private static String insertParentheses(String input) {
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (char digitChar : input.toCharArray()) {
            int digit = digitChar - '0';
            
            while (currentDepth < digit) {
                result.append('(');
                currentDepth++;
            }
            
            while (currentDepth > digit) {
                result.append(')');
                currentDepth--;
            }
            
            result.append(digitChar);
        }

        while (currentDepth > 0) {
            result.append(')');
            currentDepth--;
        }

        return result.toString();
    }
}