import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    public static int parseStringToInt(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder resultBuilder = new StringBuilder();
        StringTokenizer tokenizer;

        int testCases = parseStringToInt(reader.readLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int patternsCount = parseStringToInt(reader.readLine());

            resultBuilder.append(String.format("Case #%d: ", testCase));

            String prefix = "";
            String suffix = "";
            boolean isPatternValid = true;

            for (int patternIndex = 0; patternIndex < patternsCount; patternIndex++) {
                String[] patternParts = reader.readLine().split("\\*");

                // Validate and update prefix
                if (prefix.length() >= patternParts[0].length()) {
                    if (!prefix.startsWith(patternParts[0])) {
                        isPatternValid = false;
                    }
                } else {
                    if (!patternParts[0].startsWith(prefix)) {
                        isPatternValid = false;
                    } else {
                        prefix = patternParts[0];
                    }
                }

                // Validate and update suffix
                if (patternParts.length > 1) {
                    if (suffix.length() >= patternParts[1].length()) {
                        if (!suffix.endsWith(patternParts[1])) {
                            isPatternValid = false;
                        }
                    } else {
                        if (!patternParts[1].endsWith(suffix)) {
                            isPatternValid = false;
                        } else {
                            suffix = patternParts[1];
                        }
                    }
                }
            }

            if (isPatternValid) {
                resultBuilder.append(prefix).append(suffix).append("\n");
            } else {
                resultBuilder.append("*\n");
            }
        }

        writer.write(resultBuilder.toString());
        writer.flush();
        writer.close();
    }
}