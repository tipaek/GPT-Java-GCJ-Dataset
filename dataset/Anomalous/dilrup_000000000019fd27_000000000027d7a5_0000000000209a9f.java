import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            String number = scanner.next();
            StringBuilder result = new StringBuilder();
            int openParentheses = 0;

            for (int i = 0; i < number.length(); i++) {
                int currentDigit = number.charAt(i) - '0';
                int nextDigit = (i + 1 < number.length()) ? number.charAt(i + 1) - '0' : 0;

                while (openParentheses < currentDigit) {
                    result.append("(");
                    openParentheses++;
                }

                result.append(currentDigit);

                while (openParentheses > nextDigit) {
                    result.append(")");
                    openParentheses--;
                }
            }

            while (openParentheses > 0) {
                result.append(")");
                openParentheses--;
            }

            System.out.println("Case #" + caseNum + ": " + result.toString());
        }
    }
}