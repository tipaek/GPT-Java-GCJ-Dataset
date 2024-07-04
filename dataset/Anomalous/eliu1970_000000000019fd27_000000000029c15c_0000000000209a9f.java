import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        int testCases = Integer.parseInt(reader.readLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = reader.readLine();
            StringBuilder result = new StringBuilder();
            int openParentheses = 0;

            for (int i = 0; i < input.length(); i++) {
                int currentDigit = Character.getNumericValue(input.charAt(i));
                while (openParentheses < currentDigit) {
                    result.append('(');
                    openParentheses++;
                }
                while (openParentheses > currentDigit) {
                    result.append(')');
                    openParentheses--;
                }
                result.append(currentDigit);
            }

            while (openParentheses > 0) {
                result.append(')');
                openParentheses--;
            }

            writer.println("Case #" + caseNumber + ": " + result.toString());
        }

        writer.close();
    }
}