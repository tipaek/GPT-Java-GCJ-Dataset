import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; testCase++) {
            String input = scanner.next();
            String result = balanceParentheses(input);
            System.out.println("Case #" + testCase + ": " + result);
        }
    }

    public static String balanceParentheses(String str) {
        StringBuilder result = new StringBuilder();
        int openBracesCount = 0;

        for (char ch : str.toCharArray()) {
            int digit = ch - '0';

            while (openBracesCount < digit) {
                result.append('(');
                openBracesCount++;
            }
            while (openBracesCount > digit) {
                result.append(')');
                openBracesCount--;
            }

            result.append(ch);
        }

        while (openBracesCount > 0) {
            result.append(')');
            openBracesCount--;
        }

        return result.toString();
    }
}