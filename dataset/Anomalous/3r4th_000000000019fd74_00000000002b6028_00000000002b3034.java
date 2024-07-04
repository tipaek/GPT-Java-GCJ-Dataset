import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int numPatterns = scanner.nextInt();
            scanner.nextLine();
            String[] patterns = readPatterns(numPatterns, scanner);
            
            for (String pattern : patterns) {
                System.out.println(pattern);
            }

            System.out.println("Case #" + i + ": " + solve(patterns));
        }
    }

    private static String[] readPatterns(int numPatterns, Scanner scanner) {
        String[] patterns = new String[numPatterns];
        
        for (int i = 0; i < numPatterns; i++) {
            patterns[i] = scanner.nextLine();
            if (patterns[i].length() > 1) {
                patterns[i] = patterns[i].substring(1);
            } else {
                patterns[i] = "";
            }
        }
        
        return patterns;
    }

    private static String solve(String[] patterns) {
        String longestPattern = "";
        
        for (String pattern : patterns) {
            if (pattern.length() > longestPattern.length()) {
                longestPattern = pattern;
            }
        }
        
        for (String pattern : patterns) {
            if (!pattern.isEmpty() && !longestPattern.endsWith(pattern)) {
                return "*";
            }
        }
        
        return longestPattern;
    }
}