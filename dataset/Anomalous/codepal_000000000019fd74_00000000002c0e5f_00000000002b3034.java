package CodeJamIO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    static String first = "", last = "";

    public static void main(String[] args) {
        Scanner scn = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scn.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scn.nextInt();
            first = "";
            last = "";
            ArrayList<String> patterns = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                patterns.add(scn.next());
            }
            boolean isValid = true;
            for (String pattern : patterns) {
                if (pattern.charAt(0) == '*') {
                    isValid &= processPattern(pattern, 0);
                } else if (pattern.charAt(pattern.length() - 1) == '*') {
                    isValid &= processPattern(pattern, 1);
                } else {
                    isValid &= processPattern(pattern, 2);
                }
            }
            if (isValid) {
                String result = mergePatterns();
                System.out.println("Case #" + (i + 1) + ": " + result);
            } else {
                System.out.println("Case #" + (i + 1) + ": *");
            }
        }
    }

    public static boolean processPattern(String pattern, int type) {
        switch (type) {
            case 0:
                return processSuffixPattern(pattern);
            case 1:
                return processPrefixPattern(pattern);
            case 2:
                return processMiddlePattern(pattern);
            default:
                return false;
        }
    }

    private static boolean processSuffixPattern(String pattern) {
        int i = pattern.length() - 1, j = last.length() - 1;
        while (i >= 0 && j >= 0) {
            if (pattern.charAt(i) == last.charAt(j)) {
                i--;
                j--;
            } else if (pattern.charAt(i) != '*') {
                return false;
            } else {
                break;
            }
        }
        if (j < 0 && pattern.length() > 1) {
            last = pattern.substring(1, i + 1) + last;
        }
        return true;
    }

    private static boolean processPrefixPattern(String pattern) {
        int i = 0, j = 0;
        while (i < pattern.length() && j < first.length()) {
            if (pattern.charAt(i) == first.charAt(j)) {
                i++;
                j++;
            } else if (pattern.charAt(i) != '*') {
                return false;
            } else {
                break;
            }
        }
        if (j == first.length()) {
            first += pattern.substring(i, pattern.length() - 1);
        }
        return true;
    }

    private static boolean processMiddlePattern(String pattern) {
        int i = 0, j = 0;
        while (pattern.charAt(i) != '*' && j < first.length()) {
            if (pattern.charAt(i) == first.charAt(j)) {
                i++;
                j++;
            } else {
                return false;
            }
        }
        int k = i;
        while (pattern.charAt(k) != '*') {
            k++;
        }
        first += pattern.substring(i, k);

        i = pattern.length() - 1;
        j = last.length() - 1;
        while (pattern.charAt(i) != '*' && j >= 0) {
            if (pattern.charAt(i) == last.charAt(j)) {
                i--;
                j--;
            } else {
                return false;
            }
        }
        k = i;
        while (pattern.charAt(k) != '*') {
            k--;
        }
        last = pattern.substring(k + 1, i + 1) + last;
        return true;
    }

    private static String mergePatterns() {
        StringBuilder result = new StringBuilder(first);
        int j = 0, k = 0;
        while (j < first.length() && k < last.length()) {
            if (first.charAt(j) == last.charAt(k)) {
                j++;
                k++;
            } else {
                j++;
                k = 0;
            }
        }
        result.append(last.substring(k));
        return result.toString();
    }
}