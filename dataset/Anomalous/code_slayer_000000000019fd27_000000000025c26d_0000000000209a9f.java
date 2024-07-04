import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases > 0) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            char currentChar = input.charAt(0);
            char bracket = '(';

            if (currentChar == '0') {
                result.append(currentChar);
            } else {
                result.append('(').append(currentChar);
                bracket = ')';
            }

            for (int i = 1; i < input.length(); i++) {
                char nextChar = input.charAt(i);
                if (nextChar == currentChar) {
                    result.append(nextChar);
                } else {
                    result.append(bracket).append(nextChar);
                    currentChar = nextChar;
                    bracket = (bracket == ')') ? '(' : ')';
                }
            }

            if (currentChar == '1') {
                result.append(')');
            }

            System.out.println("Case #" + caseNumber + ": " + result.toString());
            testCases--;
            caseNumber++;
        }
    }
}