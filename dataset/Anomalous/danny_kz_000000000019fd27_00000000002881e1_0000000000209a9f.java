import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= testCases; caseIndex++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int openParentheses = 0;

            for (int index = 0; index < input.length(); index++) {
                int currentDigit = input.charAt(index) - '0';

                if (index == 0) {
                    if (currentDigit > 0) {
                        result.append(generateParentheses('(', currentDigit));
                        openParentheses += currentDigit;
                    }
                } else {
                    int previousDigit = input.charAt(index - 1) - '0';
                    int difference = currentDigit - previousDigit;

                    if (difference > 0) {
                        result.append(generateParentheses('(', difference));
                        openParentheses += difference;
                    } else if (difference < 0) {
                        result.append(generateParentheses(')', -difference));
                        openParentheses += difference;
                    }
                }

                result.append(currentDigit);
            }

            if (openParentheses > 0) {
                result.append(generateParentheses(')', openParentheses));
            }

            System.out.println("Case #" + caseIndex + ": " + result);
        }

        scanner.close();
    }

    private static String generateParentheses(char parenthesis, int count) {
        StringBuilder parentheses = new StringBuilder();
        for (int i = 0; i < count; i++) {
            parentheses.append(parenthesis);
        }
        return parentheses.toString();
    }
}