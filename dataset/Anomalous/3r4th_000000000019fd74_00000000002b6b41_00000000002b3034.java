import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int numPatterns = scanner.nextInt();
            scanner.nextLine();
            String[] patterns = readPatterns(numPatterns, scanner);
            System.out.println("Case #" + i + ": " + findSolution(patterns));
        }
    }

    private static String[] readPatterns(int numPatterns, Scanner scanner) {
        String[] patterns = new String[numPatterns];
        
        for (int i = 0; i < numPatterns; i++) {
            String pattern = scanner.nextLine();
            patterns[i] = pattern.length() > 1 ? pattern.substring(1) : "";
        }
        
        return patterns;
    }

    private static String findSolution(String[] patterns) {
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