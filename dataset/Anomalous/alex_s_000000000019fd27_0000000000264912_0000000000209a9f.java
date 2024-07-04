import java.util.Scanner;

public class Solution {

    private static final String OPENS = "(((((((((((";
    private static final String CLOSES = ")))))))))))";
    private static final String EMPTY = "";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int numberOfCases = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
                String digits = scanner.nextLine();
                String result = solve(digits);
                System.out.printf("Case #%d:%s%n", caseNumber, result);
            }
        }
    }

    private static String solve(String digits) {
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (char digitChar : digits.toCharArray()) {
            int digit = digitChar - '0';
            if (digit > currentDepth) {
                result.append(OPENS, 0, digit - currentDepth);
            } else if (digit < currentDepth) {
                result.append(CLOSES, 0, currentDepth - digit);
            }
            result.append(digit);
            currentDepth = digit;
        }

        result.append(CLOSES, 0, currentDepth);
        return result.toString();
    }
}