import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        for (int i = 1; i <= testCases; i++) {
            processTestCase(br, i);
        }
    }

    private static void processTestCase(BufferedReader br, int caseNumber) throws IOException {
        String[] digits = br.readLine().split("");
        StringBuilder result = new StringBuilder();
        int openParentheses = 0;

        for (String digitStr : digits) {
            int digit = Integer.parseInt(digitStr);
            int requiredParentheses = digit - openParentheses;

            if (requiredParentheses > 0) {
                result.append("(".repeat(requiredParentheses));
            } else if (requiredParentheses < 0) {
                result.append(")".repeat(-requiredParentheses));
            }

            result.append(digit);
            openParentheses = digit;
        }

        result.append(")".repeat(openParentheses));
        System.out.println("Case #" + caseNumber + ": " + result);
    }
}