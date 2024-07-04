import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();
        StringBuilder result = new StringBuilder();

        for (int i = 1; i <= testCases; i++) {
            String input = scanner.nextLine();
            String formattedOutput = String.format("Case #%d: %s", i, calculate(input));
            result.append(formattedOutput);
            if (i < testCases) {
                result.append("\n");
            }
        }
        System.out.println(result);
    }

    private static String calculate(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        StringBuilder output = new StringBuilder();
        int currentDepth = 0;

        for (char ch : input.toCharArray()) {
            int digit = Character.getNumericValue(ch);

            while (currentDepth < digit) {
                output.append('(');
                currentDepth++;
            }
            while (currentDepth > digit) {
                output.append(')');
                currentDepth--;
            }

            output.append(ch);
        }

        while (currentDepth > 0) {
            output.append(')');
            currentDepth--;
        }

        return output.toString();
    }
}