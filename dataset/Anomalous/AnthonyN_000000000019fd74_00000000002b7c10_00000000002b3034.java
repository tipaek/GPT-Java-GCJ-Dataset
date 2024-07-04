import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = Integer.parseInt(scanner.nextLine());
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int patternCount = Integer.parseInt(scanner.nextLine());
            String[] patterns = new String[patternCount];

            for (int j = 0; j < patternCount; j++) {
                patterns[j] = scanner.nextLine();
            }

            System.out.println("Case #" + testCase + ": " + findLongestPattern(patterns));
        }
    }

    private static String findLongestPattern(String[] patterns) {
        String longestPattern = "";

        for (int i = 0; i < patterns.length; i++) {
            patterns[i] = patterns[i].substring(1); // Remove the first character
            if (patterns[i].length() > longestPattern.length()) {
                longestPattern = patterns[i];
            }
        }

        for (String pattern : patterns) {
            if (!longestPattern.endsWith(pattern)) {
                return "*";
            }
        }

        return longestPattern;
    }
}