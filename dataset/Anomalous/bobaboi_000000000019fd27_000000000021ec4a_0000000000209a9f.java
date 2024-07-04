import java.util.Scanner;

public class Solution {
    private static int caseCount = 1;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int numberOfCases = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            for (int i = 0; i < numberOfCases; i++) {
                processCase(scanner);
            }
        }
    }

    private static void processCase(Scanner scanner) {
        String input = scanner.nextLine();
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (char digitChar : input.toCharArray()) {
            int digit = digitChar - '0';

            while (currentDepth < digit) {
                result.append('(');
                currentDepth++;
            }
            while (currentDepth > digit) {
                result.append(')');
                currentDepth--;
            }
            result.append(digitChar);
        }

        while (currentDepth > 0) {
            result.append(')');
            currentDepth--;
        }

        System.out.println("Case #" + caseCount + ": " + result.toString());
        caseCount++;
    }
}