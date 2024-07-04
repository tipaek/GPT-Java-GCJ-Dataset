package CodeJamIO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    private static String first = "", last = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            first = "";
            last = "";
            ArrayList<String> patterns = new ArrayList<>();
            
            for (int j = 0; j < n; j++) {
                patterns.add(scanner.next());
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
                String result = mergeFirstAndLast();
                System.out.println("Case #" + testCase + ": " + result);
            } else {
                System.out.println("Case #" + testCase + ": *");
            }
        }
    }

    private static boolean processPattern(String pattern, int type) {
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
        if (j < 0) {
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
        if (j == first.length() && i < pattern.length()) {
            first += pattern.substring(i, pattern.length() - 1);
        }
        return true;
    }

    private static boolean processMiddlePattern(String pattern) {
        int i = 0, j = 0;

        while (i < pattern.length() && pattern.charAt(i) != '*' && j < first.length()) {
            if (pattern.charAt(i) == first.charAt(j)) {
                i++;
                j++;
            } else if (pattern.charAt(i) != '*') {
                return false;
            } else {
                break;
            }
        }

        if (i < pattern.length() && pattern.charAt(i) == '*') {
            first += pattern.substring(i, pattern.indexOf('*', i));
        }

        i = pattern.length() - 1;
        j = last.length() - 1;
        while (i >= 0 && pattern.charAt(i) != '*' && j >= 0) {
            if (pattern.charAt(i) == last.charAt(j)) {
                i--;
                j--;
            } else if (pattern.charAt(i) != '*') {
                return false;
            } else {
                break;
            }
        }

        if (i >= 0 && pattern.charAt(i) == '*') {
            last = pattern.substring(pattern.lastIndexOf('*', i) + 1, i + 1) + last;
        }

        return true;
    }

    private static String mergeFirstAndLast() {
        StringBuilder merged = new StringBuilder(first);
        int i = 0, j = 0;
        while (i < first.length()) {
            if (first.charAt(i) == last.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
                j = 0;
            }
        }
        merged.append(last.substring(j));
        return merged.toString();
    }
}