import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    private static int maxCol = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; ++i) {
            int patternCount = scanner.nextInt();
            scanner.nextLine();
            String[][] patterns = readPatterns(patternCount, scanner);
            System.out.println("Case #" + i + ": " + solve(patterns));
        }
    }

    private static String[][] readPatterns(int patternCount, Scanner scanner) {
        String[][] patterns = new String[patternCount][];
        for (int i = 0; i < patternCount; i++) {
            String pattern = scanner.nextLine();
            if (pattern.endsWith("*")) {
                pattern += "x";
                patterns[i] = pattern.split("\\*");
                patterns[i][patterns[i].length - 1] = "";
            } else {
                patterns[i] = pattern.split("\\*");
            }
            maxCol = Math.max(maxCol, patterns[i].length);
        }
        return patterns;
    }

    private static String solve(String[][] patterns) {
        String[] longestPrefixSuffix = new String[2];
        longestPrefixSuffix[0] = "";
        longestPrefixSuffix[1] = "";
        StringBuilder innerParts = new StringBuilder();

        for (String[] pattern : patterns) {
            if (pattern[0].length() > longestPrefixSuffix[0].length()) {
                longestPrefixSuffix[0] = pattern[0];
            }
            int lastIndex = pattern.length - 1;
            if (pattern[lastIndex].length() > longestPrefixSuffix[1].length()) {
                longestPrefixSuffix[1] = pattern[lastIndex];
            }
            for (int j = 1; j < lastIndex; j++) {
                innerParts.append(pattern[j]);
            }
        }

        for (String[] pattern : patterns) {
            if (!pattern[0].isEmpty() && !longestPrefixSuffix[0].startsWith(pattern[0])) {
                return "*";
            }
            int lastIndex = pattern.length - 1;
            if (!pattern[lastIndex].isEmpty() && !longestPrefixSuffix[1].endsWith(pattern[lastIndex])) {
                return "*";
            }
        }

        return longestPrefixSuffix[0] + innerParts + longestPrefixSuffix[1];
    }
}