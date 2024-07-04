import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; testCase++) {
            int patternsCount = scanner.nextInt();

            List<String> prefixPatterns = new ArrayList<>(patternsCount);
            List<String> suffixPatterns = new ArrayList<>(patternsCount);

            for (int i = 0; i < patternsCount; i++) {
                String pattern = scanner.next();

                if (pattern.startsWith("*")) {
                    suffixPatterns.add(pattern.substring(1));
                } else if (pattern.endsWith("*")) {
                    prefixPatterns.add(pattern.substring(0, pattern.length() - 1));
                } else {
                    String[] parts = pattern.split("\\*");
                    prefixPatterns.add(parts[0]);
                    suffixPatterns.add(parts[1]);
                }
            }

            prefixPatterns.sort(Comparator.comparingInt(String::length));
            suffixPatterns.sort(Comparator.comparingInt(String::length));

            if (isValidCombination(prefixPatterns, suffixPatterns)) {
                String result = createSolution(prefixPatterns, suffixPatterns);
                System.out.printf("Case #%d: %s\n", testCase, result);
            } else {
                System.out.printf("Case #%d: *\n", testCase);
            }
        }
    }

    private static String createSolution(List<String> prefixPatterns, List<String> suffixPatterns) {
        if (prefixPatterns.isEmpty()) {
            return suffixPatterns.get(suffixPatterns.size() - 1);
        }
        if (suffixPatterns.isEmpty()) {
            return prefixPatterns.get(prefixPatterns.size() - 1);
        }
        return prefixPatterns.get(prefixPatterns.size() - 1) + suffixPatterns.get(suffixPatterns.size() - 1);
    }

    private static boolean isValidCombination(List<String> prefixPatterns, List<String> suffixPatterns) {
        return isValidPrefix(suffixPatterns) && isValidSuffix(prefixPatterns);
    }

    private static boolean isValidPrefix(List<String> patterns) {
        if (patterns.isEmpty()) return true;

        String lastPattern = patterns.get(patterns.size() - 1);
        for (int i = 0; i < patterns.size() - 1; i++) {
            String currentPattern = patterns.get(i);
            String suffixToMatch = lastPattern.substring(lastPattern.length() - currentPattern.length());

            if (!currentPattern.equals(suffixToMatch)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidSuffix(List<String> patterns) {
        if (patterns.isEmpty()) return true;

        String lastPattern = patterns.get(patterns.size() - 1);
        for (int i = 0; i < patterns.size() - 1; i++) {
            String currentPattern = patterns.get(i);
            String prefixToMatch = lastPattern.substring(0, currentPattern.length());

            if (!currentPattern.equals(prefixToMatch)) {
                return false;
            }
        }
        return true;
    }
}