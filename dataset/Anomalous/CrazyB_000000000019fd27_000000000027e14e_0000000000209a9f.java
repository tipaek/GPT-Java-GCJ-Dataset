import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = scanner.next();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;

            for (char digitChar : input.toCharArray()) {
                int digit = Character.getNumericValue(digitChar);

                if (digit > currentDepth) {
                    result.append("(".repeat(digit - currentDepth));
                    currentDepth = digit;
                } else if (digit < currentDepth) {
                    result.append(")".repeat(currentDepth - digit));
                    currentDepth = digit;
                }

                result.append(digitChar);
            }

            result.append(")".repeat(currentDepth));
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }
}