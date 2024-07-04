import java.util.Scanner;

public class Solution {

    public static void nestingDepth(int caseNumber, String input) {
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (char ch : input.toCharArray()) {
            int digit = ch - '0';
            while (currentDepth < digit) {
                result.append('(');
                currentDepth++;
            }
            while (currentDepth > digit) {
                result.append(')');
                currentDepth--;
            }
            result.append(digit);
        }

        while (currentDepth > 0) {
            result.append(')');
            currentDepth--;
        }

        System.out.println("Case #" + caseNumber + ": " + result.toString());
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int numberOfCases = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        for (int i = 0; i < numberOfCases; i++) {
            String input = scanner.nextLine();
            nestingDepth(i + 1, input);
        }

        scanner.close();
    }
}