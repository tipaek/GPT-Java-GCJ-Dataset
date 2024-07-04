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
                patterns[i] = pattern;
                
                if (pattern.length() > longestPattern.length()) {
                    longestPattern = pattern;
                }
            }
            
            String answer = longestPattern.substring(1);
            for (String pattern : patterns) {
                String trimmedPattern = pattern.length() > 1 ? pattern.substring(1) : pattern;
                
                if (!longestPattern.contains(trimmedPattern)) {
                    answer = "*";
                    break;
                }
            }
            
            writer.println("Case #" + t + ": " + answer);
        }
        
        writer.close();
    }
}