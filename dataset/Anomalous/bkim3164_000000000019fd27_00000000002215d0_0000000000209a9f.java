import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            for (int i = 0; i < testCases; i++) {
                System.out.print("Case #" + (i + 1) + ": ");
                solve(scanner);
                System.out.println();
            }
        }
    }

    static void solve(Scanner scanner) {
        String input = scanner.next();
        StringBuilder result = new StringBuilder();
        int[] digits = input.chars().map(Character::getNumericValue).toArray();
        
        int openParentheses = 0;
        int closeParentheses = 0;

        for (int i = 0; i < digits.length; i++) {
            int currentDigit = digits[i];
            if (i == 0) {
                openParentheses = currentDigit;
                closeParentheses = currentDigit;
                result.append("(".repeat(Math.max(0, currentDigit))).append(currentDigit);
            } else {
                int previousDigit = digits[i - 1];
                if (currentDigit > previousDigit) {
                    int difference = currentDigit - previousDigit;
                    result.append("(".repeat(Math.max(0, difference))).append(currentDigit);
                    openParentheses += difference;
                } else if (currentDigit < previousDigit) {
                    int difference = previousDigit - currentDigit;
                    result.append(")".repeat(Math.max(0, difference))).append(currentDigit);
                    closeParentheses -= difference;
                } else {
                    result.append(currentDigit);
                }
            }
        }

        result.append(")".repeat(Math.max(0, closeParentheses)));
        System.out.print(result);
    }
}