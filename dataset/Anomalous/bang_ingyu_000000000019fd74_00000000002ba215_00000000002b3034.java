import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static int parseStringToInt(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder resultBuilder = new StringBuilder();
        StringTokenizer tokenizer;

        int testCases = parseStringToInt(reader.readLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int patternsCount = parseStringToInt(reader.readLine());

            resultBuilder.append(String.format("Case #%d: ", caseNumber));

            String startPattern = "";
            String endPattern = "";

            boolean isValid = true;

            for (int patternIndex = 0; patternIndex < patternsCount; patternIndex++) {
                String[] patternParts = reader.readLine().split("\\*");

                // Check and update start pattern
                if (startPattern.length() >= patternParts[0].length()) {
                    if (!startPattern.contains(patternParts[0])) {
                        isValid = false;
                    }
                } else {
                    if (!patternParts[0].contains(startPattern)) {
                        isValid = false;
                    } else {
                        startPattern = patternParts[0];
                    }
                }

                // Check and update end pattern
                if (endPattern.length() >= patternParts[1].length()) {
                    if (!endPattern.contains(patternParts[1])) {
                        isValid = false;
                    }
                } else {
                    if (!patternParts[1].contains(endPattern)) {
                        isValid = false;
                    } else {
                        endPattern = patternParts[1];
                    }
                }
            }

            if (isValid) {
                resultBuilder.append(startPattern);
                resultBuilder.append(endPattern);
                resultBuilder.append("\n");
            } else {
                resultBuilder.append("*\n");
            }
        }

        writer.write(resultBuilder.toString());
        writer.flush();
        writer.close();
    }
}