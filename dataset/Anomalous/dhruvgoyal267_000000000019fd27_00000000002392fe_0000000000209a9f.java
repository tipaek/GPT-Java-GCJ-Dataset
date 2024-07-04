import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int openParenthesesCount = 0;

            for (char ch : input.toCharArray()) {
                int digit = Character.getNumericValue(ch);

                while (openParenthesesCount < digit) {
                    result.append('(');
                    openParenthesesCount++;
                }

                while (openParenthesesCount > digit) {
                    result.append(')');
                    openParenthesesCount--;
                }

                result.append(ch);
            }

            while (openParenthesesCount > 0) {
                result.append(')');
                openParenthesesCount--;
            }

            System.out.println("Case #" + testCase + ": " + result);
        }

        scanner.close();
    }
}