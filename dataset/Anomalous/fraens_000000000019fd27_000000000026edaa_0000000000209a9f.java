import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    /**
     * Reads test cases from the input.
     * @param scanner Scanner object to read input
     * @return List of test cases, each test case is a list of integers
     */
    public static List<List<Integer>> readTestCases(Scanner scanner) {
        List<List<Integer>> testCases = new ArrayList<>();
        int numberOfTestCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numberOfTestCases; i++) {
            String line = scanner.nextLine();
            List<Integer> digits = new ArrayList<>();
            for (char ch : line.toCharArray()) {
                digits.add(Character.getNumericValue(ch));
            }
            testCases.add(digits);
        }

        return testCases;
    }

    /**
     * Generates the output string for a single test case.
     * @param digits List of integers representing a test case
     * @return Formatted string for the test case
     */
    public static String formatTestCase(List<Integer> digits) {
        StringBuilder result = new StringBuilder();
        int previousDigit = 0;

        for (int digit : digits) {
            if (digit > previousDigit) {
                result.append("(".repeat(digit - previousDigit));
            } else if (digit < previousDigit) {
                result.append(")".repeat(previousDigit - digit));
            }
            result.append(digit);
            previousDigit = digit;
        }

        result.append(")".repeat(digits.get(digits.size() - 1)));

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        List<List<Integer>> testCases = readTestCases(scanner);

        int caseNumber = 1;
        for (List<Integer> testCase : testCases) {
            System.out.println("Case #" + caseNumber + ": " + formatTestCase(testCase));
            caseNumber++;
        }
    }
}