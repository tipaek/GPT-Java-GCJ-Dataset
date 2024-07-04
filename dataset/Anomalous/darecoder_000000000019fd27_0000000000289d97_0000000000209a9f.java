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
        int openCount = 0;
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            int currentDigit = input.charAt(i) - '0';

            while (openCount < currentDigit) {
                output.append('(');
                openCount++;
            }

            while (openCount > currentDigit) {
                output.append(')');
                openCount--;
            }

            output.append(currentDigit);
        }

        while (openCount > 0) {
            output.append(')');
            openCount--;
        }

        return output.toString();
    }
}