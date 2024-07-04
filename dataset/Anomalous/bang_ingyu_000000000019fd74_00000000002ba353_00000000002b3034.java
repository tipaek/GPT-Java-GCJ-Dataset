import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    public static int parseInteger(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder resultBuilder = new StringBuilder();
        StringTokenizer tokenizer;

        int testCases = parseInteger(reader.readLine());

        for (int i = 1; i <= testCases; i++) {
            int patternsCount = parseInteger(reader.readLine());

            resultBuilder.append(String.format("Case #%d: ", i));

            String startPattern = "";
            String endPattern = "";

            boolean isValid = true;

            for (int j = 0; j < patternsCount; j++) {
                String[] patterns = reader.readLine().split("\\*");
                String prefix = patterns[0];
                String suffix = patterns[1];

                if (startPattern.length() >= prefix.length()) {
                    if (!startPattern.startsWith(prefix)) {
                        isValid = false;
                    }
                } else {
                    if (!prefix.startsWith(startPattern)) {
                        isValid = false;
                    } else {
                        startPattern = prefix;
                    }
                }

                if (endPattern.length() >= suffix.length()) {
                    if (!endPattern.endsWith(suffix)) {
                        isValid = false;
                    }
                } else {
                    if (!suffix.endsWith(endPattern)) {
                        isValid = false;
                    } else {
                        endPattern = suffix;
                    }
                }
            }

            if (isValid) {
                resultBuilder.append(startPattern).append(endPattern).append("\n");
            } else {
                resultBuilder.append("*\n");
            }
        }

        writer.write(resultBuilder.toString());
        writer.flush();
        writer.close();
    }
}