import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        int testCases = Integer.parseInt(reader.readLine());
        StringBuilder result = new StringBuilder();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            char[] digits = reader.readLine().toCharArray();
            result.append("Case #").append(testCase).append(": ");

            int openBrackets = 0;
            for (char digit : digits) {
                int currentDigit = digit - '0';

                while (openBrackets < currentDigit) {
                    result.append('(');
                    openBrackets++;
                }
                while (openBrackets > currentDigit) {
                    result.append(')');
                    openBrackets--;
                }

                result.append(currentDigit);
            }

            while (openBrackets > 0) {
                result.append(')');
                openBrackets--;
            }

            result.append('\n');
        }

        writer.print(result.toString());
        writer.close();
        reader.close();
    }
}