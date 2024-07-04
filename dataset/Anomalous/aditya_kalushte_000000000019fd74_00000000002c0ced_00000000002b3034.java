import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = sc.nextInt();
        for (int t = 0; t < testCases; t++) {
            int N = sc.nextInt();
            boolean isMatch = true;
            String finalPattern = sc.next();
            
            outerLoop: for (int i = 1; i < N; i++) {
                String pattern = sc.next();
                String[] finalPatternParts = splitPattern(finalPattern);
                String[] patternParts = splitPattern(pattern);
                
                for (int j = 0; j < finalPatternParts.length; j++) {
                    if (j >= patternParts.length) break;
                    String partFinalPattern = finalPatternParts[j];
                    String partPattern = patternParts[j];
                    
                    if (!isMatching(partFinalPattern, partPattern, j == 0)) {
                        isMatch = false;
                        break outerLoop;
                    }
                }
                
                finalPattern = mergePatterns(finalPattern, pattern);
            }
            
            if (!isMatch) {
                System.out.println("Case #" + (t + 1) + ": *");
            } else {
                System.out.println("Case #" + (t + 1) + ": " + finalPattern.replace("*", ""));
            }
        }
        sc.close();
    }

    private static String[] splitPattern(String pattern) {
        if (pattern.startsWith("*")) {
            return new String[]{"", pattern.replace("*", "")};
        } else if (pattern.endsWith("*")) {
            return new String[]{pattern.replace("*", ""), ""};
        } else {
            return pattern.split("\\*");
        }
    }

    private static boolean isMatching(String part1, String part2, boolean isPrefix) {
        String longer = part1.length() >= part2.length() ? part1 : part2;
        String shorter = part1.length() < part2.length() ? part1 : part2;

        if (shorter.isEmpty()) return true;
        
        if (isPrefix) {
            return longer.startsWith(shorter);
        } else {
            return longer.endsWith(shorter);
        }
    }

    private static String mergePatterns(String pattern1, String pattern2) {
        if (pattern1.endsWith("*") && pattern2.startsWith("*")) {
            return pattern1.replace("*", "") + "*" + pattern2.replace("*", "");
        } else if (pattern2.endsWith("*") && pattern1.startsWith("*")) {
            return pattern2.replace("*", "") + "*" + pattern1.replace("*", "");
        } else if (pattern1.length() < pattern2.length()) {
            return pattern2;
        } else {
            return pattern1;
        }
    }
}