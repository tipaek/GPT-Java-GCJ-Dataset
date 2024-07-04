import java.util.Scanner;

public class Solution {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        // The number of test cases.
        int t = SCANNER.nextInt();

        for (int i = 0; i < t; i++) {
            solveTest(i + 1);
        }
    }

    private static void solveTest(int testNumber) {
        String s = SCANNER.next();

        System.out.print(String.format("Case #%d: ", testNumber));
        for (char c : s.toCharArray()) {
            System.out.print(wrapWithBrackets(c));
        }
        System.out.println();
    }

    private static StringBuilder wrapWithBrackets(char c) {
        int n = Integer.parseInt("" + c);
        StringBuilder leftBrackets = new StringBuilder();
        StringBuilder rightBrackets = new StringBuilder();
        for (int i = 0; i < n; i++) {
            leftBrackets.append('(');
            rightBrackets.append(')');
        }
        return new StringBuilder().append(leftBrackets).append(n).append(rightBrackets);
    }
}
