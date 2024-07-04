import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        processInput();
    }

    private static void processInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTestCases = Integer.parseInt(reader.readLine().trim());
        for (int testCase = 1; testCase <= numberOfTestCases; testCase++) {
            handleTestCase(testCase, reader);
        }
    }

    private static void handleTestCase(int caseNumber, BufferedReader reader) throws IOException {
        char[] inputChars = reader.readLine().trim().toCharArray();
        StringBuilder result = new StringBuilder();
        int currentDepth = 0;

        for (char ch : inputChars) {
            int digitValue = ch - '0';

            while (currentDepth > digitValue) {
                result.append(")");
                currentDepth--;
            }

            while (currentDepth < digitValue) {
                result.append("(");
                currentDepth++;
            }

            result.append(ch);
        }

        while (currentDepth > 0) {
            result.append(")");
            currentDepth--;
        }

        System.out.println("Case #" + caseNumber + ": " + result.toString());
    }
}