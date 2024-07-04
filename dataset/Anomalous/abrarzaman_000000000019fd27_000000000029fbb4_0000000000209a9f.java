import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine().trim());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            String input = reader.readLine();
            StringBuilder result = new StringBuilder();
            char[] digits = input.toCharArray();
            int previousDigit = 0;

            for (int i = 0; i < digits.length; i++) {
                int currentDigit = digits[i] - '0';

                // Add opening brackets
                for (int j = 0; j < currentDigit - previousDigit; j++) {
                    result.append('(');
                }

                // Add the current digit and count consecutive same digits
                int consecutiveCount = 0;
                while (i + consecutiveCount < digits.length && digits[i + consecutiveCount] == digits[i]) {
                    result.append(digits[i]);
                    consecutiveCount++;
                }

                // Update previous digit and index
                previousDigit = currentDigit;
                i += consecutiveCount - 1;

                // Determine the next digit or assume 0 if at the end
                int nextDigit = (i + 1 < digits.length) ? digits[i + 1] - '0' : 0;

                // Add closing brackets
                for (int j = 0; j < currentDigit - nextDigit; j++) {
                    result.append(')');
                }
            }

            System.out.println("Case #" + testCase + ": " + result.toString());
        }
    }
}