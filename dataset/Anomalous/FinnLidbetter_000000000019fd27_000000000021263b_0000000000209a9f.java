import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        int numberOfTests = Integer.parseInt(reader.readLine());
        for (int testIndex = 0; testIndex < numberOfTests; testIndex++) {
            String input = reader.readLine();
            int length = input.length();
            int[] digits = new int[length];

            for (int i = 0; i < length; i++) {
                digits[i] = input.charAt(i) - '0';
            }

            StringBuilder testResult = new StringBuilder();
            int currentDepth = 0;

            for (int i = 0; i < length; i++) {
                if (digits[i] > currentDepth) {
                    for (int j = 0; j < digits[i] - currentDepth; j++) {
                        testResult.append('(');
                    }
                } else if (digits[i] < currentDepth) {
                    for (int j = 0; j < currentDepth - digits[i]; j++) {
                        testResult.append(')');
                    }
                }
                testResult.append(digits[i]);
                currentDepth = digits[i];
            }

            for (int i = 0; i < currentDepth; i++) {
                testResult.append(')');
            }

            output.append(String.format("Case #%d: %s%n", testIndex + 1, testResult.toString()));
        }

        System.out.print(output);
    }
}