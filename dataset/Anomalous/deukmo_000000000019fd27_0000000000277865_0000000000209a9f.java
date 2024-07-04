import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCases = scanner.nextInt();
            for (int testCase = 1; testCase <= testCases; testCase++) {
                String numberString = scanner.next();
                int[] digits = numberString.chars().map(c -> c - '0').toArray();

                System.out.print("Case #" + testCase + ": ");
                int previousDigit = 0;
                for (int digit : digits) {
                    printParentheses(previousDigit, digit);
                    System.out.print(digit);
                    previousDigit = digit;
                }
                printParentheses(previousDigit, 0);
                System.out.println();
            }
        }
    }

    private static void printParentheses(int from, int to) {
        int difference = to - from;
        char parenthesis = difference > 0 ? '(' : ')';
        for (int i = 0; i < Math.abs(difference); i++) {
            System.out.print(parenthesis);
        }
    }
}