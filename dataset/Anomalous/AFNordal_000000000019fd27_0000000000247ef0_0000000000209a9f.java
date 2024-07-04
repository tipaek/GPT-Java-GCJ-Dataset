import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;
            char[] digits = scanner.next().trim().toCharArray();

            for (char digit : digits) {
                int value = digit - '0';
                if (value > currentDepth) {
                    result.append("(".repeat(value - currentDepth));
                } else if (value < currentDepth) {
                    result.append(")".repeat(currentDepth - value));
                }
                currentDepth = value;
                result.append(digit);
            }

            result.append(")".repeat(currentDepth));
            System.out.println("Case #" + caseNumber + ": " + result);
        }

        scanner.close();
    }
}