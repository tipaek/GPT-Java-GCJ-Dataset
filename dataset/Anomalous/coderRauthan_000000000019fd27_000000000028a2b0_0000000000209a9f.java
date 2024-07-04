import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int openBrackets = 0;

            for (int j = 0; j < input.length(); j++) {
                int digit = Character.getNumericValue(input.charAt(j));

                if (digit > openBrackets) {
                    result.append("(".repeat(digit - openBrackets));
                } else if (digit < openBrackets) {
                    result.append(")".repeat(openBrackets - digit));
                }

                result.append(digit);
                openBrackets = digit;
            }

            result.append(")".repeat(openBrackets));
            System.out.println("Case #" + (i + 1) + ": " + result);
        }
    }
}