import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    private static final String[] OPENING_PARENTHESES = {"(", "((", "(((", "((((", "(((((", "((((((", "(((((((", "((((((((", "((((((((("};
    private static final String[] CLOSING_PARENTHESES = {")", "))", ")))", "))))", ")))))", "))))))", ")))))))", "))))))))", ")))))))))"};

    private static String includeParentheses(String str) {
        StringBuilder resultingStr = new StringBuilder();
        int depth = 0;
        String[] strArr = str.split("");

        for (String c : strArr) {
            int n = Integer.parseInt(c);
            if (depth < n) {
                resultingStr.append(OPENING_PARENTHESES[n - depth - 1]);
            } else if (depth > n) {
                resultingStr.append(CLOSING_PARENTHESES[depth - n - 1]);
            }
            depth = n;
            resultingStr.append(c);
        }

        if (depth > 0) {
            resultingStr.append(CLOSING_PARENTHESES[depth - 1]);
        }
        return resultingStr.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine());

        for (int i = 1; i <= t; i++) {
            String S = in.nextLine();
            System.out.printf("Case #%d: %s%n", i, includeParentheses(S));
        }
    }
}