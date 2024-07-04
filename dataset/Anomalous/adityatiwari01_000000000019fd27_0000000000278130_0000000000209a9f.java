import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (scanner.hasNext()) {
            int testCases = scanner.nextInt();
            
            for (int t = 0; t < testCases; t++) {
                String input = scanner.next();
                StringBuilder result = new StringBuilder();
                
                int previousDigit = Character.getNumericValue(input.charAt(0));
                appendParentheses(result, previousDigit, '(');
                result.append(previousDigit);
                
                for (int i = 1; i < input.length(); i++) {
                    int currentDigit = Character.getNumericValue(input.charAt(i));
                    
                    if (currentDigit > previousDigit) {
                        appendParentheses(result, currentDigit - previousDigit, '(');
                    } else if (currentDigit < previousDigit) {
                        appendParentheses(result, previousDigit - currentDigit, ')');
                    }
                    
                    result.append(currentDigit);
                    previousDigit = currentDigit;
                }
                
                appendParentheses(result, previousDigit, ')');
                
                System.out.println(result.toString());
            }
        }
    }
    
    private static void appendParentheses(StringBuilder builder, int count, char parenthesis) {
        for (int i = 0; i < count; i++) {
            builder.append(parenthesis);
        }
    }
}