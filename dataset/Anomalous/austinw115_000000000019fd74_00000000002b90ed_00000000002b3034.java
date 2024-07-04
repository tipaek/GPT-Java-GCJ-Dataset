import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 32768);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        
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
            
            String result = longestPattern;
            if (longestPattern.charAt(0) == '*') {
                result = longestPattern.substring(1);
            }
            
            for (String pattern : patterns) {
                if (!pattern.equals(longestPattern)) {
                    String adjustedPattern = (pattern.length() > 1) ? pattern.substring(1) : pattern;
                    if (!longestPattern.contains(adjustedPattern)) {
                        result = "*";
                        break;
                    }
                }
            }
            
            pw.println("Case #" + i + ": " + result);
        }
        
        pw.close();
    }
}