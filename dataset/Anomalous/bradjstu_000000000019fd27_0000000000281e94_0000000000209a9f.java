import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= testCases; i++) {
            processTestCase(i, scanner);
        }
    }

    private static void processTestCase(int testCaseNumber, Scanner scanner) {
        String input = scanner.nextLine();
        StringBuilder result = new StringBuilder();
        int currentLevel = 0;

        for (char c : input.toCharArray()) {
            int digit = Character.getNumericValue(c);

            while (currentLevel < digit) {
                result.append('(');
                currentLevel++;
            }
            while (currentLevel > digit) {
                result.append(')');
                currentLevel--;
            }
            result.append(digit);
        }

        while (currentLevel > 0) {
            result.append(')');
            currentLevel--;
        }

        printResult(testCaseNumber, result.toString());
    }

    private static void printResult(int testCaseNumber, String result) {
        System.out.println("Case #" + testCaseNumber + ": " + result);
    }
}