import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            scanner.nextLine();
            String[] patterns = new String[n];
            
            for (int j = 0; j < n; j++) {
                patterns[j] = scanner.nextLine();
            }
            
            System.out.println("Case #" + i + ": " + constructWord(patterns));
        }
    }

    private static String constructWord(String[] patterns) {
        String prefix = findPrefix(patterns);
        if (prefix == null) return "*";
        
        String suffix = findSuffix(patterns);
        if (suffix == null) return "*";
        
        return mergePatterns(patterns, prefix, suffix);
    }

    private static String findPrefix(String[] patterns) {
        String prefix = "";
        
        for (String pattern : patterns) {
            if (pattern.startsWith("*")) continue;
            
            String currentPrefix = pattern.substring(0, pattern.indexOf("*"));
            if (prefix.startsWith(currentPrefix) || currentPrefix.startsWith(prefix)) {
                prefix = prefix.length() > currentPrefix.length() ? prefix : currentPrefix;
            } else {
                return null;
            }
        }
        
        return prefix;
    }

    private static String findSuffix(String[] patterns) {
        String suffix = "";
        
        for (String pattern : patterns) {
            if (pattern.endsWith("*")) continue;
            
            String currentSuffix = pattern.substring(pattern.lastIndexOf("*") + 1);
            if (suffix.endsWith(currentSuffix) || currentSuffix.endsWith(suffix)) {
                suffix = suffix.length() > currentSuffix.length() ? suffix : currentSuffix;
            } else {
                return null;
            }
        }
        
        return suffix;
    }

    private static String mergePatterns(String[] patterns, String prefix, String suffix) {
        StringBuilder middle = new StringBuilder();
        
        for (String pattern : patterns) {
            if (!pattern.contains("*")) {
                return prefix.equals(suffix) ? prefix : "*";
            }
            
            int start = pattern.indexOf("*") + 1;
            int end = pattern.lastIndexOf("*");
            if (start >= end) continue;
            
            String middlePart = pattern.substring(start, end);
            String[] middleSegments = middlePart.split("\\*");
            
            for (String segment : middleSegments) {
                middle.append(segment);
            }
        }
        
        return prefix + middle.toString() + suffix;
    }
}