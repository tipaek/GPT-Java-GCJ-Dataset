import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            String input = scanner.next();
            System.out.println("Case #" + caseNum + ": " + addParentheses(input));
        }
    }

    private static String addParentheses(String input) {
        StringBuilder result = new StringBuilder();
        int previousDigit = 0;

        for (int i = 0; i < input.length(); i++) {
            int currentDigit = Character.getNumericValue(input.charAt(i));

            if (currentDigit > previousDigit) {
                for (int j = 0; j < currentDigit - previousDigit; j++) {
                    result.append('(');
                }
            } else if (currentDigit < previousDigit) {
                for (int j = 0; j < previousDigit - currentDigit; j++) {
                    result.append(')');
                }
            }

            result.append(currentDigit);
            previousDigit = currentDigit;
        }

        for (int j = 0; j < previousDigit; j++) {
            result.append(')');
        }

        return result.toString();
    }
}