import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int i = 0; i < testCases; i++) {
            char[] input = reader.readLine().toCharArray();
            StringBuilder result = new StringBuilder();
            int prevDigit = input[0] - '0';

            // Append opening brackets for the first digit
            result.append("(".repeat(prevDigit));
            result.append(prevDigit);

            for (int j = 1; j < input.length; j++) {
                int currentDigit = input[j] - '0';

                if (currentDigit > prevDigit) {
                    result.append("(".repeat(currentDigit - prevDigit));
                } else if (currentDigit < prevDigit) {
                    result.append(")".repeat(prevDigit - currentDigit));
                }

                result.append(currentDigit);
                prevDigit = currentDigit;
            }

            // Append closing brackets for the last digit
            result.append(")".repeat(prevDigit));

            System.out.printf("Case #%d: %s%n", i + 1, result.toString());
        }
    }
}