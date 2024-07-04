import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    private static void printParentheses(int count, char parenType) {
        for (int i = 0; i < count; i++) {
            System.out.print(parenType);
        }
    }

    private static void nestingDepth(int caseNum, Scanner scanner) {
        System.out.print("Case #" + caseNum + ": ");

        String digits = scanner.nextLine();
        int currentDepth = 0;

        for (char ch : digits.toCharArray()) {
            int digit = ch - '0';

            if (digit > currentDepth) {
                printParentheses(digit - currentDepth, '(');
            } else {
                printParentheses(currentDepth - digit, ')');
            }

            currentDepth = digit;
            System.out.print(digit);
        }

        printParentheses(currentDepth, ')');
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= numberOfCases; i++) {
            nestingDepth(i, scanner);
        }

        scanner.close();
    }
}