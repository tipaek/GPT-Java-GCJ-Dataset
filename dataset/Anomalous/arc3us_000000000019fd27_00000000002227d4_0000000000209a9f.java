import java.util.Scanner;

public class Solution {

    public static String generateParentheses(int count) {
        StringBuilder parentheses = new StringBuilder();
        char parenthesis = count < 0 ? ')' : '(';
        count = Math.abs(count);
        for (int i = 0; i < count; i++) {
            parentheses.append(parenthesis);
        }
        return parentheses.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseNumber = 1;
        int testCases = scanner.nextInt();
        
        while (testCases-- > 0) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int openCount = 0;
            int closeCount = 0;
            int previousDigit = 0;
            
            for (int i = 0; i < input.length(); i++) {
                char currentChar = input.charAt(i);
                if (Character.isDigit(currentChar)) {
                    int currentDigit = Character.getNumericValue(currentChar);
                    int difference = currentDigit - previousDigit;
                    
                    if (difference != 0) {
                        result.append(generateParentheses(difference));
                        openCount += Math.max(difference, 0);
                        closeCount += Math.max(-difference, 0);
                    }
                    
                    result.append(currentChar);
                    previousDigit = currentDigit;
                }
            }
            
            while (openCount > closeCount) {
                result.append(')');
                closeCount++;
            }

            System.out.println("Case #" + caseNumber + ": " + result.toString());
            caseNumber++;
        }
        
        scanner.close();
    }
}