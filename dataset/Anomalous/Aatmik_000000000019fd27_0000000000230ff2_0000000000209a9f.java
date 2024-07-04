import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCases = Integer.parseInt(reader.readLine().trim());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String input = reader.readLine().trim();
            StringBuilder result = new StringBuilder();
            int openBrackets = 0;

            for (char digitChar : input.toCharArray()) {
                int digit = digitChar - '0';

                while (openBrackets < digit) {
                    result.append('(');
                    openBrackets++;
                }
                while (openBrackets > digit) {
                    result.append(')');
                    openBrackets--;
                }

                result.append(digitChar);
            }

            while (openBrackets > 0) {
                result.append(')');
                openBrackets--;
            }

            writer.write("Case #" + caseNumber + ": " + result.toString() + "\n");
        }

        reader.close();
        writer.close();
    }
}