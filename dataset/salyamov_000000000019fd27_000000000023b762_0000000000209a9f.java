import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        try (BufferedReader stream = new BufferedReader(new InputStreamReader(System.in))) {
            int testCases = Integer.parseInt(stream.readLine());

            for (int i = 1; i <= testCases; i++) {
                String result = solution.test(i, stream.readLine());
                outputResult(result);
            }
        }
    }

    private static void outputResult(String result) {
        System.out.println(result);
    }

    String test(final int testCaseNumber, final String numbers) {
        return String.format("Case #%s: %s", testCaseNumber, test(numbers));
    }

    private String test(final String numbers) {
        StringBuilder result = new StringBuilder();

        char[] chars = numbers.toCharArray();

        int opened = 0;
        for (int i = 0; i < chars.length; ++i) {
            int number = (chars[i] - '0');

            int needToOpen = number - opened;
            if (needToOpen >= 0) {
                addParentheses(result, needToOpen, '(');
            } else {
                int needToClose = Math.abs(needToOpen);
                addParentheses(result, needToClose, ')');
            }
            opened = number;
            result.append(number);
        }
        if (opened != 0) {
            addParentheses(result, opened, ')');
        }
        return result.toString();
    }

    private void addParentheses(StringBuilder result, int count, char symbol) {
        for (int i = 0; i < count; i++) {
            result.append(symbol);
        }
    }
}
