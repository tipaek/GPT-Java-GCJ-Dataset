import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    
    private static int parseStringToInt(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
             
            StringBuilder resultBuilder = new StringBuilder();
            int testCases = parseStringToInt(br.readLine());

            for (int i = 1; i <= testCases; i++) {
                int numPatterns = parseStringToInt(br.readLine());
                resultBuilder.append(String.format("Case #%d: ", i));

                String prefix = "";
                List<String> middleParts = new ArrayList<>();
                String suffix = "";

                boolean isValid = true;

                for (int j = 0; j < numPatterns; j++) {
                    String pattern = br.readLine();
                    String[] parts = pattern.split("\\*");

                    if (!parts[0].isEmpty()) {
                        if (prefix.length() >= parts[0].length()) {
                            if (!prefix.startsWith(parts[0])) {
                                isValid = false;
                            }
                        } else {
                            if (!parts[0].startsWith(prefix)) {
                                isValid = false;
                            } else {
                                prefix = parts[0];
                            }
                        }
                    }

                    if (parts.length > 1) {
                        for (int k = 1; k < parts.length - 1; k++) {
                            if (!parts[k].isEmpty()) {
                                middleParts.add(parts[k]);
                            }
                        }
                        
                        if (!pattern.endsWith("*")) {
                            if (suffix.length() >= parts[parts.length - 1].length()) {
                                if (!suffix.endsWith(parts[parts.length - 1])) {
                                    isValid = false;
                                }
                            } else {
                                if (!parts[parts.length - 1].endsWith(suffix)) {
                                    isValid = false;
                                } else {
                                    suffix = parts[parts.length - 1];
                                }
                            }
                        } else {
                            middleParts.add(parts[parts.length - 1]);
                        }
                    }
                }

                if (isValid) {
                    resultBuilder.append(prefix);
                    for (String middle : middleParts) {
                        resultBuilder.append(middle);
                    }
                    resultBuilder.append(suffix).append("\n");
                } else {
                    resultBuilder.append("*\n");
                }
            }

            bw.write(resultBuilder.toString());
        }
    }
}