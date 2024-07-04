import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            int numPatterns = scanner.nextInt();
            String[] patterns = new String[numPatterns];

            for (int i = 0; i < numPatterns; i++) {
                patterns[i] = scanner.next();
            }

            String longestPattern = findLongestPattern(patterns);

            if (isValidPattern(longestPattern, patterns)) {
                System.out.println("Case #" + caseNum + ": " + longestPattern.substring(1));
            } else {
                System.out.println("Case #" + caseNum + ": *");
            }
        }
    }

    private static String findLongestPattern(String[] patterns) {
        String longest = "";
        for (String pattern : patterns) {
            if (pattern.length() > longest.length()) {
                longest = pattern;
            }
        }
        return longest;
    }

    private static boolean isValidPattern(String longestPattern, String[] patterns) {
        String base = longestPattern.substring(1);
        for (String pattern : patterns) {
            String word = pattern.substring(1);
            if (!base.endsWith(word)) {
                return false;
            }
        }
        return true;
    }
}