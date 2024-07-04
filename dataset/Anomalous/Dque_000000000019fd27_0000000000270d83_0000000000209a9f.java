import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringJoiner;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        int testCases = Integer.parseInt(reader.readLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = reader.readLine();
            int length = input.length();
            int[] digits = new int[length];
            
            for (int i = 0; i < length; i++) {
                digits[i] = Character.getNumericValue(input.charAt(i));
            }

            int[] openBrackets = new int[length + 1];
            int[] closeBrackets = new int[length + 1];

            openBrackets[0] = digits[0];
            int currentDepth = digits[0];

            for (int i = 1; i < length; i++) {
                if (digits[i] == currentDepth) {
                    continue;
                } else if (digits[i] > currentDepth) {
                    openBrackets[i] = digits[i] - currentDepth;
                    currentDepth = digits[i];
                } else {
                    closeBrackets[i] = currentDepth - digits[i];
                    currentDepth = digits[i];
                }
            }

            closeBrackets[length] = currentDepth;

            StringJoiner result = new StringJoiner("");
            result.add("Case #" + caseNumber + ": ");
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < openBrackets[i]; j++) {
                    result.add("(");
                }
                for (int j = 0; j < closeBrackets[i]; j++) {
                    result.add(")");
                }
                result.add(String.valueOf(digits[i]));
            }

            for (int j = 0; j < closeBrackets[length]; j++) {
                result.add(")");
            }

            writer.println(result.toString());
        }

        writer.close();
    }
}