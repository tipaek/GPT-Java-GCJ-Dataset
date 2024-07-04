import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        scanner.skip("\n");

        for(int caseNum = 1; caseNum <= t; caseNum++) {
            String res = solve(scanner.nextLine());
            System.out.println(String.format("Case #%d: %s", caseNum, res));
        }

        scanner.close();
    }

    private static void appendChar(char c, int count, StringBuilder builder) {
        while (count-- > 0) {
            builder.append(c);
        }
    }

    private static String solve(String s) {
        StringBuilder builder = new StringBuilder();

        int openedParenthesis = 0;
        for (int i = 0; i < s.length(); i++) {
            int currentDigit = s.charAt(i) - '0';

            appendChar('(', currentDigit - openedParenthesis, builder);
            openedParenthesis = currentDigit;

            builder.append(currentDigit);

            if (i == s.length() - 1) {
                appendChar(')', openedParenthesis, builder);
            } else {
                int nextDigit = s.charAt(i + 1) - '0';
                if (nextDigit < currentDigit) {
                    appendChar(')', currentDigit - nextDigit, builder);
                    openedParenthesis -= (currentDigit - nextDigit);
                }
            }
        }

        return builder.toString();
    }
}
