import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    private static final String[] OPENING_PARENTHESIS = {"(", "((", "(((", "((((", "(((((", "((((((", "(((((((", "((((((((", "((((((((("};
    private static final String[] CLOSING_PARENTHESIS = {")", "))", ")))", "))))", ")))))", "))))))", ")))))))", "))))))))", ")))))))))"};

    private static String includeParentheses(String str) {
        StringBuilder resultingStr = new StringBuilder();
        int depth = 0;

        for (char c : str.toCharArray()) {
            int n = Character.getNumericValue(c);
            if (depth < n) {
                resultingStr.append(OPENING_PARENTHESIS[n - depth - 1]);
            } else if (depth > n) {
                resultingStr.append(CLOSING_PARENTHESIS[depth - n - 1]);
            }
            depth = n;
            resultingStr.append(c);
        }

        if (depth > 0) {
            resultingStr.append(CLOSING_PARENTHESIS[depth - 1]);
        }
        return resultingStr.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine(); // Consume the newline character

        for (int i = 1; i <= t; i++) {
            String str = in.nextLine();
            System.out.println(includeParentheses(str));
        }
    }
}