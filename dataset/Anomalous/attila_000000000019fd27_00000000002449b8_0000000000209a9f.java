import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String digits = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int openParentheses = 0;

            for (char digit : digits.toCharArray()) {
                int currentDigit = digit - '0';

                while (openParentheses < currentDigit) {
                    result.append('(');
                    openParentheses++;
                }
                while (openParentheses > currentDigit) {
                    result.append(')');
                    openParentheses--;
                }
                result.append(digit);
            }

            while (openParentheses > 0) {
                result.append(')');
                openParentheses--;
            }

            System.out.println("Case #" + caseNumber + ": " + result);
        }

        scanner.close();
    }
}