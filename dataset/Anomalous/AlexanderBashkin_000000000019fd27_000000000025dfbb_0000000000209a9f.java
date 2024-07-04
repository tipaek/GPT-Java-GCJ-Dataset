import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        solution.processInput();
    }

    private void processInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTests = Integer.parseInt(reader.readLine());
        for (int testCase = 1; testCase <= numberOfTests; testCase++) {
            String inputString = reader.readLine();
            processTestCase(testCase, inputString);
        }
    }

    private void processTestCase(int testCaseNumber, String inputString) {
        StringBuilder result = new StringBuilder();
        int currentOpenBrackets = 0;

        for (char character : inputString.toCharArray()) {
            int digit = character - '0';
            if (digit > currentOpenBrackets) {
                for (int i = 0; i < digit - currentOpenBrackets; i++) {
                    result.append('(');
                }
            } else if (digit < currentOpenBrackets) {
                for (int i = 0; i < currentOpenBrackets - digit; i++) {
                    result.append(')');
                }
            }
            currentOpenBrackets = digit;
            result.append(character);
        }

        for (int i = 0; i < currentOpenBrackets; i++) {
            result.append(')');
        }

        System.out.printf("Case #%d: %s%n", testCaseNumber, result.toString());
    }
}