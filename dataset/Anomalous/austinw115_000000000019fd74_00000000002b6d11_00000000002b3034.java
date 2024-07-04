import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 32768);
        PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        
        int testCases = Integer.parseInt(reader.readLine().trim());
        
        for (int i = 1; i <= testCases; i++) {
            int n = Integer.parseInt(reader.readLine().trim());
            String[] patterns = new String[n];
            String longestPattern = "*";
            
            for (int j = 0; j < n; j++) {
                String pattern = reader.readLine().trim();
                if (pattern.length() > longestPattern.length()) {
                    longestPattern = pattern;
                }
                patterns[j] = pattern;
            }
            
            String result = longestPattern.startsWith("*") ? longestPattern.substring(1) : longestPattern;
            
            for (String pattern : patterns) {
                String trimmedPattern = pattern.startsWith("*") ? pattern.substring(1) : pattern;
                if (!longestPattern.contains(trimmedPattern)) {
                    result = "*";
                    break;
                }
            }
            
            writer.println("Case #" + i + ": " + result);
        }
        
        writer.close();
    }
}