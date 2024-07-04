import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < input.length(); i++) {
                int prev = (i > 0) ? Character.getNumericValue(input.charAt(i - 1)) : 0;
                int next = (i < input.length() - 1) ? Character.getNumericValue(input.charAt(i + 1)) : 0;
                int current = Character.getNumericValue(input.charAt(i));

                result.append(generateBrackets(Math.max(current - prev, 0), current, Math.max(current - next, 0)));
            }

            System.out.printf("Case #%d: %s%n", t, result.toString());
        }
    }

    private static String generateBrackets(int openCount, int number, int closeCount) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < openCount; i++) {
            result.append('(');
        }

        result.append(number);

        for (int i = 0; i < closeCount; i++) {
            result.append(')');
        }

        return result.toString();
    }
}