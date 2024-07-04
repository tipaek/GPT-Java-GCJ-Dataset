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

            for (int line = 2; line <= N; line++) {
                String pattern = sc.next();
                String[] finalPatternArr = splitPattern(finalPattern);
                String[] patternArr = splitPattern(pattern);

                if (finalPatternArr.length < 3 && patternArr.length < 3) {
                    match = comparePatterns(finalPatternArr, patternArr);
                }

                if ((finalPattern.endsWith("*") && pattern.startsWith("*")) ||
                    (pattern.endsWith("*") && finalPattern.startsWith("*"))) {
                    finalPattern = mergePatterns(finalPattern, pattern);
                } else if (finalPattern.length() < pattern.length()) {
                    String temp = finalPattern;
                    finalPattern = pattern;
                    pattern = temp;
                }
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

    private static boolean comparePatterns(String[] finalPatternArr, String[] patternArr) {
        for (int index = 0; index < 2; index++) {
            String partFinalPatternStr = finalPatternArr[index];
            String partPatternStr = patternArr[index];

            String longer = partFinalPatternStr.length() >= partPatternStr.length() ? partFinalPatternStr : partPatternStr;
            String shorter = partFinalPatternStr.length() < partPatternStr.length() ? partFinalPatternStr : partPatternStr;

            if (partFinalPatternStr.length() == partPatternStr.length() && partFinalPatternStr.length() == 0) {
                continue;
            }

            if (index == 0) {
                for (int i = 0; i < shorter.length(); i++) {
                    if (shorter.charAt(i) != longer.charAt(i)) {
                        return false;
                    }
                }
            } else {
                for (int i = 0; i < shorter.length(); i++) {
                    if (shorter.charAt(shorter.length() - i - 1) != longer.charAt(longer.length() - i - 1)) {
                        return false;
                    }
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
        }
        return finalPattern;
    }
}