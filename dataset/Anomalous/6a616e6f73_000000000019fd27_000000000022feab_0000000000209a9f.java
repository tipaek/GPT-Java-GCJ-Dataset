import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            String inputString = scanner.next();
            String result = processString(inputString);
            displayResult(i, result);
        }
    }

    private static String processString(String input) {
        StringBuilder resultBuilder = new StringBuilder();
        int currentDepth = 0;
        for (char ch : (input + '0').toCharArray()) {
            int targetDepth = ch - '0';
            while (currentDepth < targetDepth) {
                resultBuilder.append('(');
                currentDepth++;
            }
            while (currentDepth > targetDepth) {
                resultBuilder.append(')');
                currentDepth--;
            }
            resultBuilder.append(ch);
        }
        return resultBuilder.substring(0, resultBuilder.length() - 1);
    }

    private static void displayResult(int caseNumber, String result) {
        System.out.printf("Case #%d: %s%n", caseNumber + 1, result);
    }
}