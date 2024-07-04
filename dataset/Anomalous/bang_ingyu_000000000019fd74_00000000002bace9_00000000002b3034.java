import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    
    public static int stringToInt(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder output = new StringBuilder();
        StringTokenizer tokenizer;

        int testCases = stringToInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            int n = stringToInt(reader.readLine());

            output.append(String.format("Case #%d: ", t));

            String startPattern = "";
            String endPattern = "";

            boolean isValid = true;

            for (int j = 0; j < n; j++) {
                String[] parts = reader.readLine().split("\\*");
                if (startPattern.length() >= parts[0].length()) {
                    if (!startPattern.contains(parts[0])) {
                        isValid = false;
                    }
                } else {
                    if (!parts[0].contains(startPattern)) {
                        isValid = false;
                    } else {
                        startPattern = parts[0];
                    }
                }
                if (parts.length > 1) {
                    if (endPattern.length() >= parts[1].length()) {
                        if (!endPattern.contains(parts[1])) {
                            isValid = false;
                        }
                    } else {
                        if (!parts[1].contains(endPattern)) {
                            isValid = false;
                        } else {
                            endPattern = parts[1];
                        }
                    }
                }
            }
            if (isValid) {
                output.append(startPattern);
                output.append(endPattern);
                output.append("\n");
            } else {
                output.append("*\n");
            }
        }

        writer.write(output.toString());
        writer.flush();
        writer.close();
    }
}