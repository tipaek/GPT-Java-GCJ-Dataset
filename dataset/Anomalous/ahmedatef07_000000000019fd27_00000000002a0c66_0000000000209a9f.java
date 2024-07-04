import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int testCases = Integer.parseInt(scanner.nextLine());
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.nextLine();
            String sanitizedInput = sanitize(input);
            
            StringBuilder result = new StringBuilder();
            int openParentheses = 0;
            
            for (char ch : sanitizedInput.toCharArray()) {
                int digit = ch - '0';
                
                while (openParentheses < digit) {
                    result.append('(');
                    openParentheses++;
                }
                
                while (openParentheses > digit) {
                    result.append(')');
                    openParentheses--;
                }
                
                result.append(ch);
            }
            
            while (openParentheses > 0) {
                result.append(')');
                openParentheses--;
            }
            
            System.out.printf("Case #%d: %s%n", caseNumber, result.toString());
        }
        
        scanner.close();
    }

    private static String sanitize(String input) {
        StringBuilder sanitized = new StringBuilder();
        
        for (char ch : input.toCharArray()) {
            if (Character.isDigit(ch)) {
                sanitized.append(ch);
            }
        }
        
        return sanitized.toString();
    }
}