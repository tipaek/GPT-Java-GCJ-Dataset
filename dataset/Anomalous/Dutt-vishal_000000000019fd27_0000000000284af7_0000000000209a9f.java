import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            String s = scanner.next();
            solve(s, i);
        }
    }

    private static void solve(String s, int caseNumber) {
        System.out.print("Case #" + caseNumber + ": ");
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (char c : s.toCharArray()) {
            int digit = c - '0';
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

        System.out.println(result);
    }
}