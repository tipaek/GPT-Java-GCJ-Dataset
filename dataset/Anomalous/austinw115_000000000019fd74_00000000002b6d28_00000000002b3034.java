import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("A.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("A.out"));
        int T = Integer.parseInt(br.readLine().trim());
        
        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine().trim());
            String[] patterns = new String[N];
            String longestPattern = "*";
            
            for (int j = 0; j < N; j++) {
                String pattern = br.readLine().trim();
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
            
            pw.println("Case #" + i + ": " + result);
        }
        
        pw.close();
    }
}