import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = sc.nextInt();

        for (int t = 0; t < testCases; t++) {
            int N = sc.nextInt();
            boolean match = true;
            String finalPattern = sc.next();

            for (int line = 2; line <= N; line++) {
                String pattern = sc.next();
                String[] finalPatternArr = splitPattern(finalPattern);
                String[] patternArr = splitPattern(pattern);

                for (int index = 0; index < 2; index++) {
                    if (index >= patternArr.length) break;

                    String partFinalPatternStr = finalPatternArr[index];
                    String partPatternStr = patternArr[index];

                    String longer = partFinalPatternStr.length() >= partPatternStr.length() ? partFinalPatternStr : partPatternStr;
                    String shorter = partFinalPatternStr.length() < partPatternStr.length() ? partFinalPatternStr : partPatternStr;

                    if (shorter.isEmpty()) continue;

                    if (!isMatching(index, shorter, longer)) {
                        match = false;
                        break;
                    }
                }

                if (!match) break;

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
        if (pattern.indexOf('*') == 0) {
            return new String[]{"", pattern.replaceAll("\\*", "")};
        } else if (pattern.indexOf('*') == pattern.length() - 1) {
            return new String[]{pattern.replaceAll("\\*", ""), ""};
        } else {
            return pattern.split("\\*");
        }
    }

    private static boolean isMatching(int index, String shorter, String longer) {
        if (index == 0) {
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
        if (finalPattern.indexOf('*') == finalPattern.length() - 1 && pattern.indexOf('*') == 0) {
            return finalPattern.replaceAll("\\*", "") + "*" + pattern.replaceAll("\\*", "");
        } else if (pattern.indexOf('*') == pattern.length() - 1 && finalPattern.indexOf('*') == 0) {
            return pattern.replaceAll("\\*", "") + "*" + finalPattern.replaceAll("\\*", "");
        } else if (finalPattern.length() < pattern.length()) {
            return pattern;
        }
        return finalPattern;
    }
}