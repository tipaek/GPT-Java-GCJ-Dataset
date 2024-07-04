import java.io.*;

public class Solution {
    private static int parseStringToInt(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            StringBuilder output = new StringBuilder();
            int testCases = parseStringToInt(reader.readLine());

            for (int testCase = 1; testCase <= testCases; testCase++) {
                output.append("Case #").append(testCase).append(": ");
                char[] inputDigits = reader.readLine().toCharArray();
                int openBrackets = 0;

                for (char digit : inputDigits) {
                    int currentDigit = digit - '0';

                    while (openBrackets > currentDigit) {
                        output.append(")");
                        openBrackets--;
                    }
                    while (openBrackets < currentDigit) {
                        output.append("(");
                        openBrackets++;
                    }

                    output.append(currentDigit);
                }

                while (openBrackets > 0) {
                    output.append(")");
                    openBrackets--;
                }
                output.append("\n");
            }

            writer.write(output.toString());
            writer.flush();
        }
    }
}