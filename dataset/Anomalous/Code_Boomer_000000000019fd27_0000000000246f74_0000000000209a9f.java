import java.util.Scanner;

public class Solution {

    public static String addParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (char ch : s.toCharArray()) {
            int digit = Character.getNumericValue(ch);
            while (currentDepth < digit) {
                result.append('(');
                currentDepth++;
            }
            while (currentDepth > digit) {
                result.append(')');
                currentDepth--;
            }
            result.append(ch);
        }

        while (currentDepth > 0) {
            result.append(')');
            currentDepth--;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

        for (int i = 0; i < T; i++) {
            String s = scanner.nextLine();
            String result = addParentheses(s);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }

        scanner.close();
    }
}