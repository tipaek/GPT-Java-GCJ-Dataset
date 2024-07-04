import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTests = Integer.parseInt(scanner.nextLine());

        for (int test = 1; test <= numberOfTests; test++) {
            String inputLine = scanner.nextLine();
            processTestCase(test, inputLine);
        }
        
        scanner.close();
    }

    private static void processTestCase(int testNumber, String inputLine) {
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (char character : inputLine.toCharArray()) {
            int digit = Character.getNumericValue(character);

            if (digit > currentDepth) {
                result.append("(".repeat(digit - currentDepth));
            } else if (digit < currentDepth) {
                result.append(")".repeat(currentDepth - digit));
            }

            result.append(character);
            currentDepth = digit;
        }

        result.append(")".repeat(currentDepth));
        System.out.printf("Case #%d: %s%n", testNumber, result.toString());
    }
}