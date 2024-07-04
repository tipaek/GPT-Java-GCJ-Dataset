import java.util.Scanner;

public class Solution {

    public static String findPattern(String[] patterns, int[] starIndices, int maxIndex, String longestPattern) {
        if (maxIndex == 0) {
            String commonSuffix = longestPattern.substring(1);
            for (String pattern : patterns) {
                String suffix = pattern.substring(1);
                if (!suffix.equals(longestPattern.substring(longestPattern.length() - suffix.length()))) {
                    return "*";
                }
            }
            return commonSuffix;
        } else {
            int n = patterns.length;
            String[] prefixes = new String[n];
            String[] suffixes = new String[n];
            String longestPrefix = "", longestSuffix = "";
            int index = 0;

            for (String pattern : patterns) {
                int starIndex = pattern.indexOf("*");
                String prefix = pattern.substring(0, starIndex);
                String suffix = pattern.substring(starIndex + 1);
                prefixes[index] = prefix;
                suffixes[index] = suffix;
                index++;

                if (longestPrefix.length() < prefix.length()) {
                    longestPrefix = prefix;
                }
                if (longestSuffix.length() < suffix.length()) {
                    longestSuffix = suffix;
                }
            }

            for (String prefix : prefixes) {
                if (!prefix.equals(longestPrefix.substring(0, prefix.length()))) {
                    return "*";
                }
            }
            for (String suffix : suffixes) {
                if (!suffix.equals(longestSuffix.substring(longestSuffix.length() - suffix.length()))) {
                    return "*";
                }
            }
            return longestPrefix + longestSuffix;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            String[] patterns = new String[n];
            int[] starIndices = new int[n];
            int maxIndex = 0;
            String longestPattern = "";

            for (int i = 0; i < n; i++) {
                String pattern = scanner.next();
                patterns[i] = pattern;
                starIndices[i] = pattern.indexOf("*");

                if (starIndices[i] > maxIndex) {
                    maxIndex = starIndices[i];
                }
                if (pattern.length() > longestPattern.length()) {
                    longestPattern = pattern;
                }
            }

            String result = findPattern(patterns, starIndices, maxIndex, longestPattern);
            System.out.println("Case #" + (t + 1) + ": " + result);
        }
        
        scanner.close();
    }
}