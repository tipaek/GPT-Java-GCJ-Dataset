import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testcases = sc.nextInt();
        
        for (int t = 0; t < testcases; t++) {
            int N = sc.nextInt();
            String finalPattern = sc.next();
            boolean match = true;

            for (int line = 1; line < N; line++) {
                String pattern = sc.next();
                String[] finalPatternArr = splitPattern(finalPattern);
                String[] patternArr = splitPattern(pattern);

                if (!isValidMatch(finalPatternArr, patternArr)) {
                    match = false;
                    break;
                }

                finalPattern = mergePatterns(finalPattern, pattern);
            }

            if (!match) {
                System.out.println("Case #" + (t + 1) + ": *");
            } else {
                String answer = finalPattern.replaceAll("\\*", "");
                System.out.println("Case #" + (t + 1) + ": " + answer);
            }
        }
        sc.close();
    }

    private static String[] splitPattern(String pattern) {
        String[] patternArr = pattern.split("\\*");

        if (pattern.startsWith("*")) {
            patternArr = new String[]{"", pattern.replaceAll("\\*", "")};
        } else if (pattern.endsWith("*")) {
            patternArr = new String[]{pattern.replaceAll("\\*", ""), ""};
        }

        return patternArr;
    }

    private static boolean isValidMatch(String[] finalPatternArr, String[] patternArr) {
        for (int index = 0; index < 2; index++) {
            String partFinalPattern = finalPatternArr[index];
            String partPattern = patternArr[index];

            String longer = partFinalPattern.length() >= partPattern.length() ? partFinalPattern : partPattern;
            String shorter = partFinalPattern.length() < partPattern.length() ? partFinalPattern : partPattern;

            if (index == 0) {
                if (!longer.startsWith(shorter)) {
                    return false;
                }
            } else {
                if (!longer.endsWith(shorter)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static String mergePatterns(String finalPattern, String pattern) {
        if (finalPattern.endsWith("*") && pattern.startsWith("*")) {
            return finalPattern.replaceAll("\\*", "") + "*" + pattern.replaceAll("\\*", "");
        } else if (pattern.endsWith("*") && finalPattern.startsWith("*")) {
            return pattern.replaceAll("\\*", "") + "*" + finalPattern.replaceAll("\\*", "");
        } else if (finalPattern.length() < pattern.length()) {
            return pattern;
        } else {
            return finalPattern;
        }
    }
}