import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.nextLine();
            StringBuilder result = new StringBuilder();
            int openBrackets = 0;

            for (char ch : input.toCharArray()) {
                int digit = Character.getNumericValue(ch);
                if (digit > openBrackets) {
                    result.append("(".repeat(digit - openBrackets));
                } else if (digit < openBrackets) {
                    result.append(")".repeat(openBrackets - digit));
                }
                result.append(ch);
                openBrackets = digit;
            }
            result.append(")".repeat(openBrackets));

            System.out.printf("Case #%d: %s%n", caseNumber, result.toString());
        }
        scanner.close();
    }
}