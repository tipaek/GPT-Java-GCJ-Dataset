import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        int testCaseNumber = 1;

        while (t-- > 0) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int[] digits = input.chars().map(c -> c - '0').toArray();
            int openParentheses = 0;

            for (int digit : digits) {
                while (openParentheses < digit) {
                    result.append('(');
                    openParentheses++;
                }
                while (openParentheses > digit) {
                    result.append(')');
                    openParentheses--;
                }
                result.append(digit);
            }

            while (openParentheses > 0) {
                result.append(')');
                openParentheses--;
            }

            System.out.println("Case #" + testCaseNumber++ + ": " + result);
        }
    }
}