import java.util.Scanner;

public class Solution {
    private static final String OUTPUT_FORMAT = "Case #%d: %s";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int testCases = scanner.nextInt();
            for (int caseNum = 1; caseNum <= testCases; caseNum++) {
                new Solution().processCase(caseNum, scanner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void processCase(int caseNum, Scanner scanner) {
        char[] inputChars = scanner.next().toCharArray();
        int[] digits = new int[inputChars.length];
        
        for (int i = 0; i < inputChars.length; i++) {
            digits[i] = inputChars[i] - '0';
        }

        StringBuilder resultBuilder = new StringBuilder();

        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == 0) {
                resultBuilder.append("0");
            } else {
                if (i == 0 || digits[i - 1] == 0) {
                    resultBuilder.append("(");
                }
                resultBuilder.append("1");
                if (i == digits.length - 1 || digits[i + 1] == 0) {
                    resultBuilder.append(")");
                }
            }
        }

        System.out.println(String.format(OUTPUT_FORMAT, caseNum, resultBuilder.toString()));
    }
}