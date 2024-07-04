import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; ++caseNumber) {
            int patternCount = scanner.nextInt();
            scanner.nextLine();
            String[][] patterns = readPatterns(patternCount, scanner);
            System.out.println("Case #" + caseNumber + ": " + solvePatterns(patterns));
        }
    }

    private static String[][] readPatterns(int patternCount, Scanner scanner) {
        String[][] patterns = new String[patternCount][2];
        
        for (int i = 0; i < patternCount; i++) {
            String pattern = scanner.nextLine();
            if (pattern.endsWith("*")) {
                pattern += "x";
                patterns[i] = pattern.split("\\*");
                patterns[i][patterns[i].length - 1] = "";
            } else {
                patterns[i] = pattern.split("\\*");
            }
        }
        
        return patterns;
    }

    private static String solvePatterns(String[][] patterns) {
        String[] longestParts = {"", ""};
        
        for (String[] pattern : patterns) {
            if (pattern[0].length() > longestParts[0].length()) {
                longestParts[0] = pattern[0];
            }
            if (pattern[1].length() > longestParts[1].length()) {
                longestParts[1] = pattern[1];
            }
        }
        
        for (String[] pattern : patterns) {
            if (!pattern[0].isEmpty() && !longestParts[0].startsWith(pattern[0])) {
                return "*";
            }
            if (!pattern[1].isEmpty() && !longestParts[1].endsWith(pattern[1])) {
                return "*";
            }
        }
        
        return longestParts[0] + longestParts[1];
    }
}