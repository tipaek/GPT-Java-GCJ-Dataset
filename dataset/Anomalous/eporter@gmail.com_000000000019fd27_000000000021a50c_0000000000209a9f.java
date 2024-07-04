import java.io.IOException;
import java.util.Scanner;

public class Solution {
    private final Scanner scanner;

    public Solution(Scanner scanner) {
        this.scanner = scanner;
    }

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            run(scanner);
        }
    }

    private static void run(Scanner scanner) {
        int numberOfCases = scanner.nextInt();
        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            new Solution(scanner).processCase(caseNumber);
        }
    }

    private void processCase(int caseNumber) {
        String input = scanner.next();
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (char character : input.toCharArray()) {
            int targetDepth = Character.getNumericValue(character);

            while (currentDepth < targetDepth) {
                result.append('(');
                currentDepth++;
            }
            while (currentDepth > targetDepth) {
                result.append(')');
                currentDepth--;
            }
            result.append(character);
        }

        while (currentDepth > 0) {
            result.append(')');
            currentDepth--;
        }

        printFormattedResult(caseNumber, result.toString());
    }

    private static void printFormattedResult(int caseNumber, String result) {
        System.out.printf("Case #%d: %s%n", caseNumber, result);
    }
}