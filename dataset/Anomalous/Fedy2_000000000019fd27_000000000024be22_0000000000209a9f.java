import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            String inputString = scanner.next();
            processTestCase(testCase, inputString);
        }
        scanner.close();
    }

    private static void processTestCase(int testCaseNumber, String inputString) {
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (char character : inputString.toCharArray()) {
            int digit = character - '0';
            int depthDifference = currentDepth - digit;
            char parenthesis = depthDifference > 0 ? ')' : '(';

            for (int i = 0; i < Math.abs(depthDifference); i++) {
                result.append(parenthesis);
            }

            result.append(character);
            currentDepth = digit;
        }

        for (int i = 0; i < currentDepth; i++) {
            result.append(')');
        }

        System.out.println("Case #" + testCaseNumber + ": " + result.toString());
    }
}