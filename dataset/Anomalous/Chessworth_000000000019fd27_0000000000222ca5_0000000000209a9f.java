import java.util.Scanner;

class Solution {
    // Method to count the difference between left and right brackets in a string
    public static int countBracketDifference(String s) {
        int leftCount = 0, rightCount = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') leftCount++;
            else if (c == ')') rightCount++;
        }
        return leftCount - rightCount;
    }

    // Method to generate a string of brackets based on the difference
    public static String generateBrackets(int difference) {
        StringBuilder brackets = new StringBuilder(Math.abs(difference));
        char bracket = (difference < 0) ? ')' : '(';
        for (int i = 0; i < Math.abs(difference); i++) {
            brackets.append(bracket);
        }
        return brackets.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int currentBracketBalance = 0;

            for (char c : input.toCharArray()) {
                int digit = Character.getNumericValue(c);
                int requiredBrackets = digit - currentBracketBalance;
                result.append(generateBrackets(requiredBrackets));
                result.append(digit);
                currentBracketBalance = digit;
            }

            result.append(generateBrackets(-currentBracketBalance));
            System.out.println("Case #" + i + ": " + result);
        }
    }
}