import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCaseCount; t++) {
            String input = reader.readLine();
            StringBuilder result = new StringBuilder();
            int currentDepth = 0;

            for (char ch : input.toCharArray()) {
                int digit = ch - '0';

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

            System.out.println("Case #" + t + ": " + result);
        }
    }
}