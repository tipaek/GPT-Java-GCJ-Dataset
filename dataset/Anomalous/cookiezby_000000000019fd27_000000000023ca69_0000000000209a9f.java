import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < caseCount; i++) {
            System.out.println(formatResult(scanner.nextLine(), i + 1));
        }
        scanner.close();
    }

    private static String formatResult(String input, int caseIndex) {
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (char ch : input.toCharArray()) {
            if (Character.isDigit(ch)) {
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
        }

        while (currentDepth > 0) {
            result.append(")");
            currentDepth--;
        }

        return String.format("Case #%d: %s", caseIndex, result.toString());
    }
}