import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.nextLine();
            int length = input.length();
            int currentDepth = 0;

            System.out.print("Case #" + caseNumber + ": ");

            for (int i = 0; i < length; i++) {
                int digit = Character.getNumericValue(input.charAt(i));

                if (currentDepth < digit) {
                    printParentheses('(', digit - currentDepth);
                    currentDepth = digit;
                } else if (currentDepth > digit) {
                    printParentheses(')', currentDepth - digit);
                    currentDepth = digit;
                }

                System.out.print(digit);
            }

            printParentheses(')', currentDepth);
            System.out.println();
        }

        scanner.close();
    }

    private static void printParentheses(char parenthesis, int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(parenthesis);
        }
    }
}