import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 0; i < testCases; i++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            boolean inParenthesis = false;
            
            for (int j = 0; j < input.length(); j++) {
                char currentChar = input.charAt(j);
                
                if (currentChar == '1') {
                    if (!inParenthesis) {
                        result.append('(');
                        inParenthesis = true;
                    }
                    result.append('1');
                    
                    if (j == input.length() - 1) {
                        result.append(')');
                    }
                } else {
                    if (inParenthesis) {
                        result.append(')');
                        inParenthesis = false;
                    }
                    result.append('0');
                }
            }
            
            System.out.println("Case #" + (i + 1) + ": " + result.toString());
        }
        
        scanner.close();
    }
}