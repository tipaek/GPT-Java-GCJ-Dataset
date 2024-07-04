import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        int testCases = Integer.parseInt(reader.readLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String inputString = reader.readLine();
            StringBuilder result = new StringBuilder();
            int previousDigit = 0;

            for (int i = 0; i < inputString.length(); i++) {
                int currentDigit = inputString.charAt(i) - '0';
                if (previousDigit > currentDigit) {
                    appendClosingBrackets(result, previousDigit - currentDigit);
                } else if (previousDigit < currentDigit) {
                    appendOpeningBrackets(result, currentDigit - previousDigit);
                }
                result.append(currentDigit);
                previousDigit = currentDigit;
            }
            appendClosingBrackets(result, previousDigit);
            writer.println("Case #" + caseNumber + ": " + result.toString());
        }

        writer.close();
        reader.close();
    }

    private static void appendOpeningBrackets(StringBuilder builder, int count) {
        for (int i = 0; i < count; i++) {
            builder.append('(');
        }
    }

    private static void appendClosingBrackets(StringBuilder builder, int count) {
        for (int i = 0; i < count; i++) {
            builder.append(')');
        }
    }
}