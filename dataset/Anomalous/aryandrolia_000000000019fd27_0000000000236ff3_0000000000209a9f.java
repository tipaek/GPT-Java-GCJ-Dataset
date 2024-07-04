import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            String input = scanner.next();
            processCase(input, i);
        }
        scanner.close();
    }

    private static void processCase(String input, int caseNumber) {
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (char digit : input.toCharArray()) {
            int number = Character.getNumericValue(digit);

            while (currentDepth < number) {
                result.append('(');
                currentDepth++;
            }

            while (currentDepth > number) {
                result.append(')');
                currentDepth--;
            }

            result.append(digit);
        }

        while (currentDepth > 0) {
            result.append(')');
            currentDepth--;
        }

        System.out.printf("Case #%d: %s%n", caseNumber, result.toString());
    }
}