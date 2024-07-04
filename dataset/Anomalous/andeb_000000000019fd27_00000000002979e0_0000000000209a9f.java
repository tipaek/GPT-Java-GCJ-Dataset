import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfCases = Integer.parseInt(reader.readLine());

        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            String inputLine = reader.readLine();
            StringBuilder resultBuilder = new StringBuilder();

            int currentDepth = 0;
            for (int i = 0; i < inputLine.length(); i++) {
                int digit = inputLine.charAt(i) - '0';
                while (currentDepth < digit) {
                    resultBuilder.append('(');
                    currentDepth++;
                }
                while (currentDepth > digit) {
                    resultBuilder.append(')');
                    currentDepth--;
                }
                resultBuilder.append(digit);
            }

            while (currentDepth > 0) {
                resultBuilder.append(')');
                currentDepth--;
            }

            System.out.printf("Case #%d: %s%n", caseIndex + 1, resultBuilder.toString());
        }
    }
}