import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    private static final Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        int T = Integer.parseInt(input.nextLine());
        StringBuilder output = new StringBuilder();

        for (int i = 1; i <= T; ++i) {
            String S = input.nextLine();
            output.append(solve(S, i)).append("\n");
        }

        System.out.print(output);
    }

    private static String solve(String S, int caseNumber) {
        StringBuilder result = new StringBuilder();
        int previousDigit = S.charAt(0) - '0';

        // Append opening brackets for the first digit
        result.append("(".repeat(previousDigit)).append(S.charAt(0));

        for (int j = 1; j < S.length(); j++) {
            int currentDigit = S.charAt(j) - '0';

            if (previousDigit > currentDigit) {
                result.append(")".repeat(previousDigit - currentDigit));
            } else if (previousDigit < currentDigit) {
                result.append("(".repeat(currentDigit - previousDigit));
            }

            result.append(S.charAt(j));
            previousDigit = currentDigit;
        }

        // Append closing brackets for the last digit
        result.append(")".repeat(previousDigit));

        return "Case #" + caseNumber + ": " + result;
    }
}