import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
            int attempt = 1;

            for (int i = 0; i < testCases; i++) {
                if (bitLength == 10) {
                    while (attempt <= 140) {
                        writer.write("1");
                        writer.flush();
                        reader.readLine();
                        attempt++;
                    }
                    for (int j = 1; j <= 10; j++) {
                        writer.write(String.valueOf(j));
                        writer.flush();
                        resultBuilder.append(parseStringToInt(reader.readLine()));
                    }
                } else {
                    while (attempt <= 150) {
                        writer.write("1");
                        writer.flush();
                        reader.readLine();
                        attempt++;
                    }
                    for (int j = 0; j < bitLength; j++) {
                        resultBuilder.append(0);
                    }
                }

                writer.write(resultBuilder.toString());
                writer.flush();
                attempt = 1;
                resultBuilder.setLength(0);

                if ("N".equals(reader.readLine())) {
                    break;
                }
            }
        }
    }
}