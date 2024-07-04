import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int numberOfTests = scanner.nextInt();
            for (int testIndex = 1; testIndex <= numberOfTests; testIndex++) {
                processTestCase(testIndex, scanner.next());
            }
        }
    }

    private static void processTestCase(int testIndex, String input) {
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (char character : input.toCharArray()) {
            int digit = Character.getNumericValue(character);
            while (digit > currentDepth) {
                result.append('(');
                currentDepth++;
            }
            while (digit < currentDepth) {
                result.append(')');
                currentDepth--;
            }
            result.append(character);
        }

        while (currentDepth > 0) {
            result.append(')');
            currentDepth--;
        }

        System.out.printf("Case #%d: %s%n", testIndex, result.toString());
    }
}