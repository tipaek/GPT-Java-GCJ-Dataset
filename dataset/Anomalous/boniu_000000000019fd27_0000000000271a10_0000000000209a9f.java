import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int openParentheses = 0;
            
            for (int i = 0; i < input.length(); i++) {
                char currentChar = input.charAt(i);
                int currentDigit = currentChar - '0';
                
                if (currentDigit == 0) {
                    while (openParentheses > 0) {
                        result.append(')');
                        openParentheses--;
                    }
                } else {
                    while (openParentheses > currentDigit) {
                        result.append(')');
                        openParentheses--;
                    }
                    while (openParentheses < currentDigit) {
                        result.append('(');
                        openParentheses++;
                    }
                }
                result.append(currentChar);
            }
            
            while (openParentheses-- > 0) {
                result.append(')');
            }
            
            System.out.println(String.format("Case #%d: %s", t, result.toString()));
        }
        
        scanner.close();
    }
}