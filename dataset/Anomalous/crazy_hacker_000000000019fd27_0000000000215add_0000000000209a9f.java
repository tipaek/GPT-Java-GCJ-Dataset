import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        PrintWriter writer = new PrintWriter(System.out);
        StringBuilder result = new StringBuilder();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            result.append("Case #").append(caseNumber).append(": ");
            String input = reader.readLine();
            StringBuilder output = new StringBuilder();
            int currentDepth = 0;

            for (int i = 0; i < input.length(); i++) {
                int digit = input.charAt(i) - '0';

                while (currentDepth < digit) {
                    output.append("(");
                    currentDepth++;
                }
                while (currentDepth > digit) {
                    output.append(")");
                    currentDepth--;
                }

                output.append(input.charAt(i));
            }

            while (currentDepth > 0) {
                output.append(")");
                currentDepth--;
            }

            result.append(output).append("\n");
        }

        writer.print(result);
        writer.flush();
        reader.close();
    }
}