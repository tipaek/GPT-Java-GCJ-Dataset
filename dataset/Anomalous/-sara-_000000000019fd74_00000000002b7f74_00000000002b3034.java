import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int patternCount = scanner.nextInt();
            scanner.nextLine();
            
            String[] patterns = new String[patternCount];
            for (int i = 0; i < patternCount; i++) {
                patterns[i] = scanner.nextLine();
            }
            
            String startingPattern = findLongestPrefix(patterns);
            String endingPattern = findLongestSuffix(patterns);
            String solution;
            
            if (startingPattern.equals("*") || endingPattern.equals("*")) {
                solution = "*";
            } else {
                solution = startingPattern + endingPattern;
            }
            
            System.out.println("Case #" + caseNumber + ": " + solution);
        }
        
        scanner.close();
    }
    
    private static String findLongestPrefix(String[] patterns) {
        String longestPrefix = "";
        
        for (String pattern : patterns) {
            String prefix = pattern.substring(0, pattern.indexOf("*"));
            if (prefix.length() > longestPrefix.length()) {
                if (prefix.contains(longestPrefix)) {
                    longestPrefix = prefix;
                } else {
                    return "*";
                }
            } else if (!longestPrefix.contains(prefix)) {
                return "*";
            }
        }
        
        return longestPrefix;
    }
    
    private static String findLongestSuffix(String[] patterns) {
        String longestSuffix = "";
        
        for (String pattern : patterns) {
            String suffix = pattern.substring(pattern.indexOf("*") + 1);
            if (suffix.length() > longestSuffix.length()) {
                if (suffix.contains(longestSuffix)) {
                    longestSuffix = suffix;
                } else {
                    return "*";
                }
            } else if (!longestSuffix.contains(suffix)) {
                return "*";
            }
        }
        
        return longestSuffix;
    }
}