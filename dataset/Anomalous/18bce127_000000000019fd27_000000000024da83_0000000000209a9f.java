package codejam;

import java.util.Scanner;

public class NestedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            String input = scanner.nextLine();
            StringBuilder output = new StringBuilder();

            char[] digits = input.toCharArray();
            int currentDepth = 0;

            for (char digit : digits) {
                int value = digit - '0';
                while (currentDepth < value) {
                    output.append('(');
                    currentDepth++;
                }
                while (currentDepth > value) {
                    output.append(')');
                    currentDepth--;
                }
                output.append(digit);
            }

            while (currentDepth > 0) {
                output.append(')');
                currentDepth--;
            }

            System.out.println("Case #" + testCase + ": " + output);
        }
    }
}