import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= testCases; i++) {
            int patternCount = Integer.parseInt(scanner.nextLine());
            String[] patterns = new String[patternCount];

            for (int j = 0; j < patternCount; j++) {
                patterns[j] = scanner.nextLine();
            }

            String result = processPatterns(patterns);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String processPatterns(String[] patterns) {
        String longestPattern = Arrays.stream(patterns)
                                      .max(Comparator.comparingInt(String::length))
                                      .orElse("")
                                      .substring(1);

        for (String pattern : patterns) {
            String trimmedPattern = pattern.substring(1);

            if (longestPattern.lastIndexOf(trimmedPattern) != longestPattern.length() - trimmedPattern.length()) {
                return "*";
            }
        }

        return longestPattern;
    }
}