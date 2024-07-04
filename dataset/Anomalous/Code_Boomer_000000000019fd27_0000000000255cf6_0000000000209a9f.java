import java.util.Scanner;

public class Solution {
    public static String addParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int previousDigit = 0;

        for (char c : s.toCharArray()) {
            int currentDigit = Character.getNumericValue(c);

            while (previousDigit < currentDigit) {
                result.append('(');
                previousDigit++;
            }
            while (previousDigit > currentDigit) {
                result.append(')');
                previousDigit--;
            }

            result.append(c);
        }

        while (previousDigit > 0) {
            result.append(')');
            previousDigit--;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int i = 1; i <= T; i++) {
            String s = scanner.next();
            String result = addParentheses(s);
            System.out.println("Case #" + i + ": " + result);
        }
    }
}