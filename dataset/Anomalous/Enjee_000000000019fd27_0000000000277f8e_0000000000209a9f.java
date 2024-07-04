import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();

            int currentOpenParens = 0;
            for (int i = 0; i < input.length(); i++) {
                int digit = input.charAt(i) - '0';
                if (currentOpenParens == digit) {
                    result.append(digit);
                } else {
                    if (currentOpenParens < digit) {
                        appendParentheses(result, '(', digit - currentOpenParens);
                    } else {
                        appendParentheses(result, ')', currentOpenParens - digit);
                    }
                    currentOpenParens = digit;
                    result.append(digit);
                }
            }

            if (currentOpenParens > 0) {
                appendParentheses(result, ')', currentOpenParens);
            }

            System.out.println("Case #" + caseNumber + ": " + result.toString());
        }
        
        scanner.close();
    }

    private static void appendParentheses(StringBuilder builder, char paren, int count) {
        for (int i = 0; i < count; i++) {
            builder.append(paren);
        }
    }
}