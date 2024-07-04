import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int t = 0; t < testCases; t++) {
            int N = scanner.nextInt();
            boolean isMatch = true;
            String finalPattern = scanner.next();

            outerLoop: for (int line = 2; line <= N; line++) {
                String pattern = scanner.next();
                String[] finalPatternArr = splitPattern(finalPattern);
                String[] patternArr = splitPattern(pattern);

                for (int index = 0; index < finalPatternArr.length; index++) {
                    String partFinalPattern = finalPatternArr[index];
                    String partPattern = patternArr[index];

                    if (!isSubPatternMatching(partFinalPattern, partPattern, index)) {
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
        scanner.close();
    }

    private static String[] splitPattern(String pattern) {
        String[] patternArr = pattern.split("\\*");
        if (pattern.startsWith("*")) {
            patternArr = new String[] { "", pattern.replace("*", "") };
        } else if (pattern.endsWith("*")) {
            patternArr = new String[] { pattern.replace("*", ""), "" };
        }
        return patternArr;
    }

    private static boolean isSubPatternMatching(String part1, String part2, int index) {
        String longer = part1.length() >= part2.length() ? part1 : part2;
        String shorter = part1.length() < part2.length() ? part1 : part2;

        if (shorter.isEmpty()) {
            return true;
        }

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

    private static String mergePatterns(String pattern1, String pattern2) {
        if (pattern1.endsWith("*") && pattern2.startsWith("*")) {
            return pattern1.replace("*", "") + "*" + pattern2.replace("*", "");
        } else if (pattern2.endsWith("*") && pattern1.startsWith("*")) {
            return pattern2.replace("*", "") + "*" + pattern1.replace("*", "");
        } else if (pattern1.length() < pattern2.length()) {
            return pattern2;
        }
        return pattern1;
    }
}