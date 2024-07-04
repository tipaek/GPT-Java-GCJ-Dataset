import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        scanner.nextLine();
        Solution solution = new Solution();
        
        for (int i = 1; i <= testCaseCount; i++) {
            solution.processTestCase(i, scanner);
        }
    }

    private void processTestCase(int caseNumber, Scanner scanner) {
        String inputLine = scanner.nextLine();
        String result = generateOutput(inputLine);
        System.out.println("Case #" + caseNumber + ": " + result);
    }

    private String generateOutput(String input) {
        StringBuilder outputBuilder = new StringBuilder();
        int openParenthesesCount = 0;

        for (char ch : input.toCharArray()) {
            int digit = ch - '0';

            while (openParenthesesCount < digit) {
                outputBuilder.append('(');
                openParenthesesCount++;
            }
            while (openParenthesesCount > digit) {
                outputBuilder.append(')');
                openParenthesesCount--;
            }
            outputBuilder.append(digit);
        }

        while (openParenthesesCount > 0) {
            outputBuilder.append(')');
            openParenthesesCount--;
        }

        return outputBuilder.toString();
    }
}