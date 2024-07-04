import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 32768);
        PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int testCases = Integer.parseInt(reader.readLine().trim());

        for (int t = 1; t <= testCases; t++) {
            int n = Integer.parseInt(reader.readLine().trim());
            String[] patterns = new String[n];
            String longestPattern = "*";

            for (int i = 0; i < n; i++) {
                String pattern = reader.readLine().trim();
                if (pattern.length() > longestPattern.length()) {
                    longestPattern = pattern;
                }
                patterns[i] = pattern;
            }

            String result = longestPattern;

            for (String pattern : patterns) {
                if (!pattern.equals(longestPattern)) {
                    String subPattern = pattern.length() > 1 ? pattern.substring(1) : pattern;

                    if (!longestPattern.contains(subPattern) || 
                        longestPattern.indexOf(subPattern) + subPattern.length() < longestPattern.length() - 1) {
                        result = "*";
                        break;
                    }
                }
            }

            writer.println("Case #" + t + ": " + result);
        }

        writer.close();
    }
}