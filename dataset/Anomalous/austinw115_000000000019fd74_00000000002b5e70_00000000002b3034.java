import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 32768);
        PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        
        int testCases = Integer.parseInt(reader.readLine().trim());
        
        for (int i = 1; i <= testCases; i++) {
            int numStrings = Integer.parseInt(reader.readLine().trim());
            String[] patterns = new String[numStrings];
            String longestPattern = "*";
            
            for (int j = 0; j < numStrings; j++) {
                String pattern = reader.readLine().trim();
                if (pattern.length() > longestPattern.length()) {
                    longestPattern = pattern;
                }
                patterns[j] = pattern;
            }
            
            String answer = longestPattern.substring(1);
            for (String pattern : patterns) {
                String trimmedPattern = pattern.length() > 1 ? pattern.substring(1) : pattern;
                if (!longestPattern.contains(trimmedPattern)) {
                    answer = "*";
                    break;
                }
            }
            
            writer.println("Case #" + i + ": " + answer);
        }
        
        writer.close();
    }
}