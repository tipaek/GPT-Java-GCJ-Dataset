import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();
        scanner.nextLine();
        
        for (int i = 1; i <= numCases; i++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int prevDigit = Character.getNumericValue(input.charAt(0));
            
            appendParentheses(result, '(', prevDigit);
            
            for (int j = 0; j < input.length(); j++) {
                int currentDigit = Character.getNumericValue(input.charAt(j));
                result.append(currentDigit);
                
                if (j < input.length() - 1) {
                    int nextDigit = Character.getNumericValue(input.charAt(j + 1));
                    if (currentDigit < nextDigit) {
                        appendParentheses(result, '(', nextDigit - currentDigit);
                    } else if (currentDigit > nextDigit) {
                        appendParentheses(result, ')', currentDigit - nextDigit);
                    }
                }
            }
            
            appendParentheses(result, ')', prevDigit);
            
            System.out.println("Case #" + i + ": " + result.toString());
        }
    }

    private static void appendParentheses(StringBuilder builder, char parenthesis, int count) {
        for (int i = 0; i < count; i++) {
            builder.append(parenthesis);
        }
    }
}