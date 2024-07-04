import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testcases = sc.nextInt();
        for (int t = 0; t < testcases; t++) {
            int N = sc.nextInt();
            boolean match = true;
            String finalPattern = sc.next();

            outerLoop: for (int line = 2; line <= N; line++) {
                String pattern = sc.next();
                String[] finalPatternArr = splitPattern(finalPattern);
                String[] patternArr = splitPattern(pattern);

                if (finalPatternArr.length < 3 && patternArr.length < 3) {
                    for (int index = 0; index < 2; index++) {
                        String partFinalPatternStr = finalPatternArr[index];
                        String partPatternStr = patternArr[index];

                        if (!matches(partFinalPatternStr, partPatternStr, index == 0)) {
                            match = false;
                            break outerLoop;
                        }
                    }
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
        if (pattern.indexOf('*') == 0) {
            patternArr = new String[]{"", pattern.replaceAll("\\*", "")};
        } else if (pattern.indexOf('*') == (pattern.length() - 1)) {
            patternArr = new String[]{pattern.replaceAll("\\*", ""), ""};
        }
        return patternArr;
    }

    private static boolean matches(String part1, String part2, boolean isPrefix) {
        String longer = part1.length() >= part2.length() ? part1 : part2;
        String shorter = part1.length() < part2.length() ? part1 : part2;

        if (shorter.isEmpty()) {
            return true;
        }

        if (isPrefix) {
            for (int i = 0; i < shorter.length(); i++) {
                if (shorter.charAt(i) != longer.charAt(i)) {
                    return false;
                }
            }
        } else {
            for (int i = 0; i < shorter.length(); i++) {
                if (shorter.charAt(shorter.length() - 1 - i) != longer.charAt(longer.length() - 1 - i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static String mergePatterns(String finalPattern, String pattern) {
        if ((finalPattern.indexOf('*') == finalPattern.length() - 1) && (pattern.indexOf('*') == 0)) {
            return finalPattern.replaceAll("\\*", "") + "*" + pattern.replaceAll("\\*", "");
        } else if ((pattern.indexOf('*') == pattern.length() - 1) && (finalPattern.indexOf('*') == 0)) {
            return pattern.replaceAll("\\*", "") + "*" + finalPattern.replaceAll("\\*", "");
        } else if (finalPattern.length() < pattern.length()) {
            return pattern;
        }
        return finalPattern;
    }
}