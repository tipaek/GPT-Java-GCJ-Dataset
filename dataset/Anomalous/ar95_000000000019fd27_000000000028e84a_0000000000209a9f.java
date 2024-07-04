import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String inputString = scanner.next();
            StringBuilder result = new StringBuilder();
            int openParentheses = 0;

            for (char character : inputString.toCharArray()) {
                int digit = character - '0';

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

            System.out.println("Case #" + caseNumber + ": " + result.toString());
        }
    }
}