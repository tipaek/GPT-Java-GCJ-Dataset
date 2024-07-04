import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTests = Integer.parseInt(scanner.nextLine());

        for (int currentTest = 1; currentTest <= numberOfTests; currentTest++) {
            String inputLine = scanner.nextLine();
            processTestCase(currentTest, inputLine);
        }

        scanner.close();
    }

    private static void processTestCase(int testCaseNumber, String inputLine) {
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (char character : inputLine.toCharArray()) {
            int digit = character - '0';

            if (digit > currentDepth) {
                for (int i = 0; i < digit - currentDepth; i++) {
                    result.append('(');
                }
                result.append(character);
                currentDepth = digit;
            } else if (digit < currentDepth) {
                for (int i = 0; i < currentDepth - digit; i++) {
                    result.append(')');
                }
                result.append(character);
                currentDepth = digit;
            } else {
                result.append(character);
            }
        }

        for (int i = 0; i < currentDepth; i++) {
            result.append(')');
        }

        System.out.printf("Case #%d: %s\n", testCaseNumber, result.toString());
    }
}