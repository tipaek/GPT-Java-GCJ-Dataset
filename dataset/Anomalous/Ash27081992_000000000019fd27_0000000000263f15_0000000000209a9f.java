import java.util.Scanner;

public class Solution {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int testCaseCount = sc.nextInt();
        for (int i = 0; i < testCaseCount; i++) {
            String s = sc.next();
            solve(s, i);
        }
    }

    public static void solve(String s, int testCase) {
        StringBuilder result = new StringBuilder();
        int length = s.length();
        int currentDepth = 0;

        for (int i = 0; i < length; i++) {
            int digit = s.charAt(i) - '0';

            while (currentDepth < digit) {
                result.append('(');
                currentDepth++;
            }
            while (currentDepth > digit) {
                result.append(')');
                currentDepth--;
            }

            result.append(digit);
        }

        while (currentDepth > 0) {
            result.append(')');
            currentDepth--;
        }

        System.out.println("Case #" + (testCase + 1) + ": " + result);
    }
}