import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int numPatterns = scanner.nextInt();
            String[] patterns = new String[numPatterns];
            
            for (int i = 0; i < numPatterns; i++) {
                patterns[i] = scanner.next();
            }
            
            if (allMatchPattern(patterns, "\\*[A-Z]*")) {
                String result = findLongestSuffix(patterns);
                if (result == null || !allSuffixMatch(patterns, result)) {
                    result = "*";
                }
                System.out.println("CASE #" + (t + 1) + ": " + result);
            } else if (allMatchPattern(patterns, "[A-Z]*\\*[A-Z]*")) {
                String suffix = findLongestSuffixFromMiddle(patterns);
                String prefix = findLongestPrefix(patterns);
                
                if (suffix == null || prefix == null || !allSuffixMatch(patterns, suffix) || !allPrefixMatch(patterns, prefix)) {
                    System.out.println("CASE #" + (t + 1) + ": *");
                } else {
                    System.out.println("CASE #" + (t + 1) + ": " + prefix + suffix);
                }
            }
        }
        scanner.close();
    }
    
    private static boolean allMatchPattern(String[] patterns, String regex) {
        return Arrays.stream(patterns).allMatch(p -> p.matches(regex));
    }
    
    private static String findLongestSuffix(String[] patterns) {
        String longestSuffix = null;
        int maxLength = 0;
        
        for (String pattern : patterns) {
            int length = pattern.length();
            if (length > maxLength) {
                maxLength = length;
                longestSuffix = pattern.substring(1);
            }
        }
        return longestSuffix;
    }
    
    private static boolean allSuffixMatch(String[] patterns, String suffix) {
        for (String pattern : patterns) {
            if (!suffix.endsWith(pattern.substring(1))) {
                return false;
            }
        }
        return true;
    }
    
    private static String findLongestSuffixFromMiddle(String[] patterns) {
        String longestSuffix = null;
        int maxLength = 0;
        
        for (String pattern : patterns) {
            int index = pattern.indexOf("*");
            int length = pattern.length() - (index + 1);
            if (length > maxLength) {
                maxLength = length;
                longestSuffix = pattern.substring(index + 1);
            }
        }
        return longestSuffix;
    }
    
    private static String findLongestPrefix(String[] patterns) {
        String longestPrefix = null;
        int maxLength = 0;
        
        for (String pattern : patterns) {
            int index = pattern.indexOf("*");
            int length = index;
            if (length > maxLength) {
                maxLength = length;
                longestPrefix = pattern.substring(0, index);
            }
        }
        return longestPrefix;
    }
    
    private static boolean allPrefixMatch(String[] patterns, String prefix) {
        for (String pattern : patterns) {
            int index = pattern.indexOf("*");
            if (!prefix.startsWith(pattern.substring(0, index))) {
                return false;
            }
        }
        return true;
    }
}