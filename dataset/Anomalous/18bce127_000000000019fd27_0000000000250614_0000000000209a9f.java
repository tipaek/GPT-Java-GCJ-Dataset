import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character after the integer input

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String inputString = scanner.nextLine();
            StringBuilder output = new StringBuilder();

            char[] characters = inputString.toCharArray();
            int currentDepth = 0;

            for (char c : characters) {
                int digit = c - '0';

                while (currentDepth < digit) {
                    output.append('(');
                    currentDepth++;
                }
                while (currentDepth > digit) {
                    output.append(')');
                    currentDepth--;
                }

                output.append(c);
            }

            while (currentDepth > 0) {
                output.append(')');
                currentDepth--;
            }

            System.out.println("Case #" + caseNumber + ": " + output);
        }

        scanner.close();
    }
}