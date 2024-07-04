import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int d = scanner.nextInt();
            String[] patterns = new String[d];
            for (int j = 0; j < d; j++) {
                patterns[j] = scanner.next();
            }
            System.out.println("Case #" + i + ": " + solve(patterns));
        }
    }

    public static String solve(String[] patterns) {
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
                } else if (!suffix.endsWith(currentSuffix)) {
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
            int start = pattern.charAt(0) == '*' ? 0 : 1;
            int end = pattern.charAt(pattern.length() - 1) == '*' ? parts.length - 1 : parts.length - 2;
            for (int i = start; i <= end; i++) {
                result.append(parts[i]);
            }
        }
        if (suffix != null) {
            result.append(suffix);
        }
        return result.toString();
    }
}