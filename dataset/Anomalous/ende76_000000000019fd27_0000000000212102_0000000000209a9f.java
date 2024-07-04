import java.util.Scanner;

public class Solution {

    private static String solve(String input) {
        int currentDepth = 0;
        StringBuilder output = new StringBuilder();

        for (char digitChar : input.toCharArray()) {
            int digit = digitChar - '0';

            while (currentDepth < digit) {
                output.append('(');
                currentDepth++;
            }

            while (currentDepth > digit) {
                output.append(')');
                currentDepth--;
            }

            output.append(digitChar);
        }

        while (currentDepth > 0) {
            output.append(')');
            currentDepth--;
        }

        return output.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= testCases; i++) {
            String input = scanner.nextLine();
            String result = solve(input);
            System.out.printf("Case #%d: %s\n", i, result);
        }
    }
}