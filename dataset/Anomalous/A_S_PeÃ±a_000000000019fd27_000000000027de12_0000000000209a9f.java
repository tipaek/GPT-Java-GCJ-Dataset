import java.util.Scanner;

public class Solution {
    
    private static final Scanner SCANNER = new Scanner(System.in);
    
    private static String generateParentheses(String input) {
        StringBuilder result = new StringBuilder();
        char[] characters = input.toCharArray();
        int length = input.length();
        int openParentheses = 0;
        
        for (int i = 0; i < length; i++) {
            int currentDigit = characters[i] - '0';
            
            while (openParentheses < currentDigit) {
                result.append('(');
                openParentheses++;
            }
            
            while (openParentheses > currentDigit) {
                result.append(')');
                openParentheses--;
            }
            
            result.append(characters[i]);
        }
        
        while (openParentheses > 0) {
            result.append(')');
            openParentheses--;
        }
        
        return result.toString();
    }
    
    public static void main(String[] args) {
        int testCases = SCANNER.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            String input = SCANNER.next();
            String result = generateParentheses(input);
            System.out.printf("Case #%d: %s\n", i, result);
        }
        
        SCANNER.close();
    }
}