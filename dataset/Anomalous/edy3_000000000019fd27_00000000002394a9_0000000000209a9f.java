import java.util.Scanner;

public class Solution {

    private static String solve(int[] numbers) {
        StringBuilder result = new StringBuilder();
        int previousDepth = 0;

        for (int currentNumber : numbers) {
            int currentDepth = currentNumber;
            while (currentDepth > previousDepth) {
                result.append("(");
                previousDepth++;
            }
            while (currentDepth < previousDepth) {
                result.append(")");
                previousDepth--;
            }
            result.append(currentNumber);
        }

        while (previousDepth > 0) {
            result.append(")");
            previousDepth--;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            String digits = scanner.next();
            int[] numbers = new int[digits.length()];

            for (int i = 0; i < digits.length(); i++) {
                numbers[i] = digits.charAt(i) - '0';
            }

            System.out.println("Case #" + (t + 1) + ": " + solve(numbers));
        }
    }
}