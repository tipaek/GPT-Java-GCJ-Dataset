import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    private static final String[] OPENING_PARENTHESES = {"(", "((", "(((", "((((", "(((((", "((((((", "(((((((", "((((((((", "((((((((("};
    private static final String[] CLOSING_PARENTHESES = {")", "))", ")))", "))))", ")))))", "))))))", ")))))))", "))))))))", ")))))))))"};

    private static String addParentheses(String str) {
        StringBuilder result = new StringBuilder();
        int depth = 0;

        for (char c : str.toCharArray()) {
            int n = Character.getNumericValue(c);

            if (depth < n) {
                result.append(OPENING_PARENTHESES[n - depth - 1]);
            } else if (depth > n) {
                result.append(CLOSING_PARENTHESES[depth - n - 1]);
            }

            depth = n;
            result.append(c);
        }

        if (depth > 0) {
            result.append(CLOSING_PARENTHESES[depth - 1]);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= t; i++) {
            String inputStr = scanner.nextLine();
            System.out.printf("%s\n", addParentheses(inputStr));
        }
    }
}