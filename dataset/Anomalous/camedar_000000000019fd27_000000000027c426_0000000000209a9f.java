import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    private static final String[] OPENING_PARENS = {"(", "((", "(((", "((((", "(((((", "((((((", "(((((((", "((((((((", "((((((((("};
    private static final String[] CLOSING_PARENS = {")", "))", ")))", "))))", ")))))", "))))))", ")))))))", "))))))))", ")))))))))"};

    private static String addParentheses(String str) {
        StringBuilder result = new StringBuilder();
        int depth = 0;
        for (char c : str.toCharArray()) {
            int num = Character.getNumericValue(c);
            if (depth < num) {
                result.append(OPENING_PARENS[num - depth - 1]);
            } else if (depth > num) {
                result.append(CLOSING_PARENS[depth - num - 1]);
            }
            depth = num;
            result.append(c);
        }
        if (depth > 0) {
            result.append(CLOSING_PARENS[depth - 1]);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= testCases; i++) {
            String input = scanner.nextLine();
            System.out.println(addParentheses(input));
        }
    }
}