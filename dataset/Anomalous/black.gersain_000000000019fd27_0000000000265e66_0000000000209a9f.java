import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            
            for (int i = 0; i < testCases; i++) {
                String input = scanner.nextLine();
                System.out.println("Case #" + (i + 1) + ": " + calculateNestingDepth(input));
            }
        }
    }

    private static String calculateNestingDepth(String input) {
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (char ch : input.toCharArray()) {
            int digit = Character.getNumericValue(ch);

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