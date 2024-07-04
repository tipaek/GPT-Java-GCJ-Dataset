import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            String[] patterns = new String[n];

            for (int j = 0; j < n; j++) {
                patterns[j] = scanner.nextLine();
            }

            String result = processPatterns(patterns);
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    private static String processPatterns(String[] patterns) {
        String prefix = findPrefix(patterns);
        if (prefix == null) return "*";
        
        String suffix = findSuffix(patterns);
        if (suffix == null) return "*";
        
        String middlePart = extractMiddlePart(patterns, prefix, suffix);
        return prefix + middlePart + suffix;
    }

    private static String findPrefix(String[] patterns) {
        String longestPrefix = "";

        for (String pattern : patterns) {
            if (pattern.startsWith("*")) continue;
            
            String currentPrefix = pattern.substring(0, pattern.indexOf("*"));
            if (longestPrefix.startsWith(currentPrefix) || currentPrefix.startsWith(longestPrefix)) {
                if (currentPrefix.length() > longestPrefix.length()) {
                    longestPrefix = currentPrefix;
                }
            } else {
                return null;
            }
        }

        return longestPrefix;
    }

    private static String findSuffix(String[] patterns) {
        String longestSuffix = "";

        for (String pattern : patterns) {
            if (pattern.endsWith("*")) continue;
            
            String currentSuffix = pattern.substring(pattern.lastIndexOf("*") + 1);
            if (longestSuffix.endsWith(currentSuffix) || currentSuffix.endsWith(longestSuffix)) {
                if (currentSuffix.length() > longestSuffix.length()) {
                    longestSuffix = currentSuffix;
                }
            } else {
                return null;
            }
        }

        return longestSuffix;
    }

    private static String extractMiddlePart(String[] patterns, String prefix, String suffix) {
        StringBuilder middlePartBuilder = new StringBuilder();

        for (String pattern : patterns) {
            if (!pattern.contains("*")) {
                return prefix.equals(suffix) ? prefix : "*";
            }

            int start = pattern.indexOf("*") + 1;
            int end = pattern.lastIndexOf("*");

            if (start >= end) continue;

            String middle = pattern.substring(start, end);
            String[] parts = middle.split("\\*");
            for (String part : parts) {
                middlePartBuilder.append(part);
            }
        }

        return middlePartBuilder.toString();
    }
}