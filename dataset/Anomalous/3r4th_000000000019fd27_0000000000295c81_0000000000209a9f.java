import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= testCases; i++) {
            String expression = scanner.nextLine();
            System.out.println("Case #" + i + ": " + solve(expression));
        }
    }

    public static String solve(String expression) {
        StringBuilder result = new StringBuilder();
        int currentNestingLevel = 0;

        for (char ch : expression.toCharArray()) {
            int digit = Character.getNumericValue(ch);

            while (currentNestingLevel < digit) {
                result.append('(');
                currentNestingLevel++;
            }

            while (currentNestingLevel > digit) {
                result.append(')');
                currentNestingLevel--;
            }

            result.append(digit);
        }

        while (currentNestingLevel > 0) {
            result.append(')');
            currentNestingLevel--;
        }

        return result.toString();
    }
}