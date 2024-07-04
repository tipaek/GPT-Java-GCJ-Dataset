import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int testCase = 1; testCase <= testCases; ++testCase) {
            int patternCount = scanner.nextInt();
            String[] patterns = new String[patternCount];
            for (int i = 0; i < patternCount; i++) {
                patterns[i] = scanner.next();
            }
            System.out.println("Case #" + testCase + ": " + findPattern(patterns));
        }
    }

    public static String findPattern(String[] patterns) {
        String prefix = null;
        String suffix = null;

        for (String pattern : patterns) {
            String[] parts = pattern.split("\\*");

            if (pattern.charAt(0) != '*') {
                String currentPrefix = parts[0];
                if (prefix == null) {
                    prefix = currentPrefix;
                } else if (currentPrefix.length() > prefix.length() && currentPrefix.startsWith(prefix)) {
                    prefix = currentPrefix;
                } else if (!prefix.startsWith(currentPrefix)) {
                    return "*";
                }
            }

            if (pattern.charAt(pattern.length() - 1) != '*') {
                String currentSuffix = parts[parts.length - 1];
                if (suffix == null) {
                    suffix = currentSuffix;
                } else if (currentSuffix.length() > suffix.length() && suffix.endsWith(currentSuffix)) {
                    suffix = currentSuffix;
                } else if (!currentSuffix.endsWith(suffix)) {
                    return "*";
                }
            }
        }

        StringBuilder result = new StringBuilder();
        if (prefix != null) {
            result.append(prefix);
        }
        for (String pattern : patterns) {
            String[] parts = pattern.split("\\*");
            for (int i = 1; i < parts.length - 1; i++) {
                result.append(parts[i]);
            }
        }
        if (suffix != null) {
            result.append(suffix);
        }

        return result.toString();
    }
}