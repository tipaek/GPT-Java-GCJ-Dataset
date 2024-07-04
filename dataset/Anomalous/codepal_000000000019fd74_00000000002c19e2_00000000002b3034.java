import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    private static String first = "", last = "";

    public static void main(String[] args) {
        Scanner scn = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scn.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scn.nextInt();
            resetStrings();
            ArrayList<String> patterns = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                patterns.add(scn.next());
            }
            int isValid = 1;
            for (String pattern : patterns) {
                if (pattern.charAt(0) == '*') {
                    isValid &= processPattern(pattern, 0);
                } else if (pattern.charAt(pattern.length() - 1) == '*') {
                    isValid &= processPattern(pattern, 1);
                } else {
                    isValid &= processPattern(pattern, 2);
                }
            }
            printResult(i, isValid);
        }
    }

    private static void resetStrings() {
        first = "";
        last = "";
    }

    private static int processPattern(String pattern, int type) {
        if (type == 0) {
            return processSuffixPattern(pattern);
        } else if (type == 1) {
            return processPrefixPattern(pattern);
        } else {
            return processMiddlePattern(pattern);
        }
    }

    private static int processSuffixPattern(String pattern) {
        int i = pattern.length() - 1, j = last.length() - 1;
        while (i >= 0 && j >= 0) {
            if (pattern.charAt(i) == last.charAt(j)) {
                i--;
                j--;
            } else if (pattern.charAt(i) != '*') {
                return 0;
            } else {
                break;
            }
        }
        if (j < 0 && pattern.length() > 1) {
            String suffix = pattern.substring(1, i + 1);
            last = suffix + last;
        }
        return 1;
    }

    private static int processPrefixPattern(String pattern) {
        int i = 0, j = 0;
        while (i < pattern.length() && j < first.length()) {
            if (pattern.charAt(i) == first.charAt(j)) {
                i++;
                j++;
            } else if (pattern.charAt(i) != '*') {
                return 0;
            } else {
                break;
            }
        }
        if (j == first.length() && i < pattern.length()) {
            String prefix = pattern.substring(i, pattern.length() - 1);
            first += prefix;
        }
        return 1;
    }

    private static int processMiddlePattern(String pattern) {
        int i = 0, j = 0;
        while (pattern.charAt(i) != '*' && j < first.length()) {
            if (pattern.charAt(i) == first.charAt(j)) {
                i++;
                j++;
            } else if (pattern.charAt(i) != '*') {
                return 0;
            } else {
                break;
            }
        }
        int k = i;
        if (k < pattern.length()) {
            while (pattern.charAt(k) != '*') {
                k++;
            }
            String middle = pattern.substring(i, k);
            first += middle;
        }

        i = pattern.length() - 1;
        j = last.length() - 1;
        while (pattern.charAt(i) != '*' && j >= 0) {
            if (pattern.charAt(i) == last.charAt(j)) {
                i--;
                j--;
            } else if (pattern.charAt(i) != '*') {
                return 0;
            } else {
                break;
            }
        }

        k = i;
        if (k >= 0) {
            while (pattern.charAt(k) != '*') {
                k--;
            }
            String suffix = pattern.substring(k + 1, i + 1);
            last = suffix + last;
        }
        return 1;
    }

    private static void printResult(int caseNumber, int isValid) {
        if (isValid == 1) {
            String result = first;
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
            result += last.substring(k);
            System.out.println("Case #" + (caseNumber + 1) + ": " + result);
        } else {
            System.out.println("Case #" + (caseNumber + 1) + ": *");
        }
    }
}