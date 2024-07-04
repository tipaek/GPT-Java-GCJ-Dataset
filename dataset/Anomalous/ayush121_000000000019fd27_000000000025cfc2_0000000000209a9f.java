import java.util.Scanner;

public class Solution {
    private static Scanner sc = new Scanner(System.in);
    private static int caseNumber = 1;

    public static void main(String[] args) {
        int testCases = sc.nextInt();
        sc.nextLine();
        while (testCases-- > 0) {
            solve();
        }
    }

    private static void solve() {
        String input = sc.nextLine();
        StringBuilder result = new StringBuilder();
        char[] chars = input.toCharArray();
        int currentDepth = 0;

        for (char c : chars) {
            int digit = Character.getNumericValue(c);
            if (digit > currentDepth) {
                for (int j = 0; j < digit - currentDepth; j++) {
                    result.append('(');
                }
            } else if (digit < currentDepth) {
                for (int j = 0; j < currentDepth - digit; j++) {
                    result.append(')');
                }
            }
            result.append(digit);
            currentDepth = digit;
        }

        while (currentDepth-- > 0) {
            result.append(')');
        }

        System.out.println("Case #" + (caseNumber++) + ": " + result.toString());
    }
}