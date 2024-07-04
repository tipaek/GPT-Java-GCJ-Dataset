import java.util.Scanner;

class Solution {
    static String generateParentheses(int count, char type) {
        StringBuilder parentheses = new StringBuilder();
        for (int i = 0; i < count; i++) {
            parentheses.append(type);
        }
        return parentheses.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.nextLine();
            int balanceCount = 0;
            StringBuilder result = new StringBuilder();

            char firstChar = input.charAt(0);
            int firstDigit = firstChar - '0';
            if (firstDigit != 0) {
                result.append(generateParentheses(firstDigit, '('));
                result.append(firstChar);
                balanceCount = firstDigit;
            } else {
                result.append('0');
            }

            for (int i = 1; i < input.length(); i++) {
                int currentDigit = input.charAt(i) - '0';
                if (balanceCount == currentDigit) {
                    result.append(input.charAt(i));
                } else if (balanceCount > currentDigit) {
                    int difference = balanceCount - currentDigit;
                    result.append(generateParentheses(difference, ')'));
                    balanceCount -= difference;
                    result.append(input.charAt(i));
                } else {
                    int difference = currentDigit - balanceCount;
                    result.append(generateParentheses(difference, '('));
                    balanceCount += difference;
                    result.append(input.charAt(i));
                }
            }

            if (balanceCount != 0) {
                result.append(generateParentheses(balanceCount, ')'));
            }

            System.out.println("Case #" + caseNumber + ": " + result.toString());
        }

        scanner.close();
    }
}