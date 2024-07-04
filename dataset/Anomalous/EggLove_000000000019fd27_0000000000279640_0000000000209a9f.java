import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            processTestCase(scanner, i);
        }
    }

    private static void processTestCase(Scanner scanner, int caseNumber) {
        String input = scanner.next();
        int previousDigit = 0;
        int currentDigit = Character.getNumericValue(input.charAt(0));

        System.out.print("Case #" + caseNumber + ": ");
        for (int i = 1; i < input.length(); i++) {
            int difference = previousDigit - currentDigit;
            printParentheses(difference);
            System.out.print(currentDigit);
            previousDigit = currentDigit;
            currentDigit = Character.getNumericValue(input.charAt(i));
        }
        int finalDifference = previousDigit - currentDigit;
        printParentheses(finalDifference);
        System.out.print(currentDigit);
        printParentheses(currentDigit);
        System.out.println();
    }

    private static void printParentheses(int count) {
        if (count < 0) {
            for (int i = 0; i < -count; i++) {
                System.out.print("(");
            }
        } else {
            for (int i = 0; i < count; i++) {
                System.out.print(")");
            }
        }
    }
}