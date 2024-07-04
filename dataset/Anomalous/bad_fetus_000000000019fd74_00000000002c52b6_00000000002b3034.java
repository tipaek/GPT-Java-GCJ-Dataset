import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCount = Integer.parseInt(scanner.nextLine());
            for (int testCase = 1; testCase <= testCount; testCase++) {
                int patternCount = Integer.parseInt(scanner.nextLine());
                PatternHandler patternHandler = new PatternHandler();
                for (int i = 0; i < patternCount; i++) {
                    patternHandler.addPattern(scanner.nextLine());
                }
                System.out.println("Case #" + testCase + ": " + patternHandler.getSolution());
            }
        }
    }

    static class PatternHandler {
        private final List<String> patterns = new ArrayList<>();
        private int longestPatternIndex = -1;
        private int longestPatternLength = 0;

        void addPattern(String pattern) {
            patterns.add(pattern);
            if (pattern.length() > longestPatternLength) {
                longestPatternLength = pattern.length();
                longestPatternIndex = patterns.size() - 1;
            }
        }

        String getSolution() {
            String longestPattern = patterns.get(longestPatternIndex).substring(1);
            for (String pattern : patterns) {
                if (!longestPattern.contains(pattern.substring(1))) {
                    return "*";
                }
            }
            return longestPattern;
        }
    }
}