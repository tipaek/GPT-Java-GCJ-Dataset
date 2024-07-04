import java.util.Scanner;

public class Solution {   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 0; i < testCases; i++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            
            int openBrackets = Character.getNumericValue(input.charAt(0));
            int closeBrackets = Character.getNumericValue(input.charAt(input.length() - 1));
            
            appendBrackets(result, openBrackets, '(');
            result.append(input.charAt(0));
            
            for (int j = 0; j < input.length() - 1; j++) {
                int currentDigit = Character.getNumericValue(input.charAt(j));
                int nextDigit = Character.getNumericValue(input.charAt(j + 1));
                
                if (currentDigit < nextDigit) {
                    appendBrackets(result, nextDigit - currentDigit, '(');
                } else if (currentDigit > nextDigit) {
                    appendBrackets(result, currentDigit - nextDigit, ')');
                }
                
                result.append(input.charAt(j + 1));
            }
            
            appendBrackets(result, closeBrackets, ')');
            System.out.println("Case #" + (i + 1) + ": " + result.toString());
        }
        
        scanner.close();
    }
    
    private static void appendBrackets(StringBuilder builder, int count, char bracket) {
        for (int i = 0; i < count; i++) {
            builder.append(bracket);
        }
    }
}