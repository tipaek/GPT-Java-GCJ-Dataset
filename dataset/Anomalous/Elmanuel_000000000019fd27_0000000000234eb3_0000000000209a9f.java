import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCaseCount; caseNumber++) {
            String input = scanner.next();
            System.out.println("Case #" + caseNumber + ": " + solve(input));
        }
    }

    public static String solve(String input) {
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (int i = 0; i < input.length(); i++) {
            int digit = input.charAt(i) - '0';

            while (currentDepth < digit) {
                result.append("(");
                currentDepth++;
            }

            while (currentDepth > digit) {
                result.append(")");
                currentDepth--;
            }

            result.append(digit);
        }

        while (currentDepth > 0) {
            result.append(")");
            currentDepth--;
        }

        return result.toString();
    }
}