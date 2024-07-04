import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character after the integer input

        for (int caseID = 1; caseID <= testCases; caseID++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();

            int openParentheses = 0;

            for (char ch : input.toCharArray()) {
                int digit = ch - '0';

                while (openParentheses < digit) {
                    result.append('(');
                    openParentheses++;
                }

                while (openParentheses > digit) {
                    result.append(')');
                    openParentheses--;
                }

                result.append(ch);
            }

            while (openParentheses > 0) {
                result.append(')');
                openParentheses--;
            }

            System.out.println("Case #" + caseID + ": " + result);
        }

        scanner.close();
    }
}