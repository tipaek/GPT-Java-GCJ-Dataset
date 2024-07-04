import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    private static int parseStringToInt(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            StringBuilder resultBuilder = new StringBuilder();

            int testCases = parseStringToInt(tokenizer.nextToken());
            int bitLength = parseStringToInt(tokenizer.nextToken());
            int attemptCount = 1;

            if (bitLength == 10) {
                processTestCases(writer, reader, resultBuilder, testCases, bitLength, attemptCount, 140);
            } else {
                processTestCases(writer, reader, resultBuilder, testCases, bitLength, attemptCount, 150);
            }
        }
    }

    private static void processTestCases(BufferedWriter writer, BufferedReader reader, StringBuilder resultBuilder, int testCases, int bitLength, int attemptCount, int maxAttempts) throws IOException {
        for (int i = 1; i <= testCases; i++) {
            while (attemptCount <= maxAttempts) {
                writer.write("1");
                writer.flush();
                reader.readLine();  // Read and discard the response
                attemptCount++;
            }

            for (int j = 1; j <= bitLength; j++) {
                writer.write(String.valueOf(j));
                writer.flush();
                resultBuilder.append(parseStringToInt(reader.readLine()));
            }

            writer.write(resultBuilder.toString());
            writer.flush();
            resultBuilder.setLength(0);  // Clear the StringBuilder for the next test case
            attemptCount = 1;

            if ("N".equals(reader.readLine())) {
                break;
            }
        }
    }
}