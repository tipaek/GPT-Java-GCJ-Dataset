import java.io.BufferedInputStream;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedInputStream(System.in))) {
            int testCases = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
                String input = scanner.nextLine();
                StringBuilder result = new StringBuilder();
                int currentDepth = 0;

                for (char character : input.toCharArray()) {
                    int digit = character - '0';

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

                printResult(caseNumber, result.toString());
            }
        }
    }

    private static void printResult(int caseNumber, String result) {
        System.out.printf("Case #%d: %s%n", caseNumber, result);
    }
}