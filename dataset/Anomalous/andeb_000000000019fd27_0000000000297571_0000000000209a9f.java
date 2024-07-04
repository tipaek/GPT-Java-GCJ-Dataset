import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfCases = Integer.parseInt(reader.readLine());

        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            String inputLine = reader.readLine();
            StringBuilder result = new StringBuilder(inputLine.length() * 4);
            result.append(inputLine);

            int currentDepth = 0;

            for (int i = 0; i < result.length(); i++) {
                int digit = result.charAt(i) - '0';

                if (digit >= 0 && digit <= 9) {
                    int depthDifference = digit - currentDepth;

                    if (depthDifference != 0) {
                        char bracket = depthDifference > 0 ? '(' : ')';
                        for (int j = 0; j < Math.abs(depthDifference); j++) {
                            result.insert(i, bracket);
                        }
                        currentDepth += depthDifference;
                        i += Math.abs(depthDifference);
                    }
                }
            }

            for (int i = 0; i < currentDepth; i++) {
                result.append(')');
            }

            System.out.printf("Case #%d: %s%n", caseIndex + 1, result);
        }
    }
}