import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        int caseNumber = 1;

        while (caseNumber <= testCases) {
            int n = sc.nextInt();
            sc.nextLine();
            List<String> patterns = new ArrayList<>();
            String longestPattern = "";
            int maxLength = 0;

            for (int i = 0; i < n; i++) {
                String pattern = sc.nextLine();
                patterns.add(pattern);
                if (pattern.length() > maxLength) {
                    maxLength = pattern.length();
                    longestPattern = pattern;
                }
            }

            boolean isMatch = true;
            for (String pattern : patterns) {
                if (!matchesPattern(longestPattern, pattern)) {
                    isMatch = false;
                    break;
                }
            }

            if (isMatch) {
                System.out.println("Case #" + caseNumber + ": " + longestPattern.substring(1));
            } else {
                System.out.println("Case #" + caseNumber + ": *");
            }

            caseNumber++;
        }
    }

    private static boolean matchesPattern(String s1, String s2) {
        if ((s1.endsWith("*") && s2.startsWith("*")) || (s1.startsWith("*") && s2.endsWith("*"))) {
            return true;
        } else if (s1.startsWith("*") && s2.startsWith("*")) {
            return s1.substring(1).endsWith(s2.substring(1));
        } else if (s1.endsWith("*") && s2.endsWith("*")) {
            return s1.substring(0, s1.length() - 1).contains(s2.substring(0, s2.length() - 1));
        }
        return false;
    }
}