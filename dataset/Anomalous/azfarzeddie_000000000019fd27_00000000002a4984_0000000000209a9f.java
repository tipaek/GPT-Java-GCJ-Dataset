import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for (int i = 1; i <= T; i++) {
            String S = sc.nextLine();
            System.out.println(nestingDepth(i, S));
        }
    }

    private static String nestingDepth(int T, String S) {
        StringBuilder result = new StringBuilder("Case #" + T + ": ");
        int currentDepth = 0;

        for (char c : S.toCharArray()) {
            int digit = Character.getNumericValue(c);
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

        return result.toString();
    }
}