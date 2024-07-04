import java.util.Scanner;

public class Solution {

    static void calculateNestingDepth(String input) {
        if (input == null || input.isEmpty()) {
            return;
        }

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

        System.out.println(result.toString());
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            for (int i = 0; i < testCases; i++) {
                String input = scanner.nextLine();
                System.out.print("Case #" + (i + 1) + ": ");
                calculateNestingDepth(input);
            }
        }
    }
}