import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;
        
        while (testCases-- > 0) {
            String input = scanner.next();
            String result = balanceParentheses(input);
            System.out.println("Case #" + caseNumber++ + ": " + result);
        }
    }

    public static String balanceParentheses(String input) {
        int openBraces = 0;
        StringBuilder balancedString = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            int currentDigit = input.charAt(i) - '0';

            while (openBraces < currentDigit) {
                balancedString.append('(');
                openBraces++;
            }
            while (openBraces > currentDigit) {
                balancedString.append(')');
                openBraces--;
            }

            balancedString.append(currentDigit);
        }

        while (openBraces > 0) {
            balancedString.append(')');
            openBraces--;
        }

        return balancedString.toString();
    }
}