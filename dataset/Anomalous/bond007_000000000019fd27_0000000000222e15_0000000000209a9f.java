import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            String input = scanner.next();

            StringBuilder result = new StringBuilder();
            int openParentheses = 0;

            for (char digitChar : input.toCharArray()) {
                int digit = digitChar - '0';

                while (openParentheses < digit) {
                    result.append("(");
                    openParentheses++;
                }

                while (openParentheses > digit) {
                    result.append(")");
                    openParentheses--;
                }

                result.append(digit);
            }

            while (openParentheses > 0) {
                result.append(")");
                openParentheses--;
            }

            System.out.println("Case #" + t + ": " + result.toString());
        }

        scanner.close();
    }
}