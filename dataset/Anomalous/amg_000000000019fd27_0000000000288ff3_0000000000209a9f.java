import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            String input = scanner.next();
            solve(input, i);
        }
    }

    public static void solve(String input, int testCaseNumber) {
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (char ch : input.toCharArray()) {
            int digit = ch - '0';

            while (currentDepth < digit) {
                result.append("(");
                currentDepth++;
            }

            while (currentDepth > digit) {
                result.append(")");
                currentDepth--;
            }

            result.append(ch);
        }

        while (currentDepth > 0) {
            result.append(")");
            currentDepth--;
        }

        System.out.println("Case #" + testCaseNumber + ": " + result.toString());
    }
}