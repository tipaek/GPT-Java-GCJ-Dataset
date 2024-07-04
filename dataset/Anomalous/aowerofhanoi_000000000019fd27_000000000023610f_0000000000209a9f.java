import java.util.Scanner;

public class Solution {

    private static void solveTestCase(int testCaseNumber, Scanner scanner) {
        String input = scanner.next() + "0";
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (int i = 0; i < input.length(); i++) {
            int depth = input.charAt(i) - '0';
            char parenthesis = currentDepth < depth ? '(' : ')';

            for (int j = 0; j < Math.abs(currentDepth - depth); j++) {
                result.append(parenthesis);
            }

            result.append(input.charAt(i));
            currentDepth = depth;
        }

        // Remove the trailing '0' appended initially
        String finalResult = result.substring(0, result.length() - 1);
        System.out.println("Case #" + testCaseNumber + ": " + finalResult);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();

        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            solveTestCase(testCase, scanner);
        }
    }
}