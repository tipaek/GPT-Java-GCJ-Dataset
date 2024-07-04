import java.util.Scanner;

public class Solution {
    private static final String OUTPUT_FORMAT = "Case #%d: %s";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            for (int caseNum = 1; caseNum <= t; ++caseNum) {
                new Solution().processCase(caseNum, scanner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void processCase(int caseNum, Scanner scanner) {
        String input = scanner.next();
        int[] digits = new int[input.length()];
        for (int i = 0; i < input.length(); i++) {
            digits[i] = input.charAt(i) - '0';
        }

        int currentDepth = 0;
        StringBuilder result = new StringBuilder();

        for (int digit : digits) {
            while (currentDepth < digit) {
                result.append('(');
                currentDepth++;
            }
            while (currentDepth > digit) {
                result.append(')');
                currentDepth--;
            }
            result.append(digit);
        }

        while (currentDepth > 0) {
            result.append(')');
            currentDepth--;
        }

        System.out.println(String.format(OUTPUT_FORMAT, caseNum, result.toString()));
    }
}