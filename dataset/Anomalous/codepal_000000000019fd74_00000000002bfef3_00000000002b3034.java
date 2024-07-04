import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    private static String first = "";
    private static String last = "";

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

            boolean isValid = true;
            for (String pattern : patterns) {
                if (!processPattern(pattern)) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                String result = mergeFirstAndLast();
                System.out.println("Case #" + (i + 1) + ": " + result);
            } else {
                System.out.println("Case #" + (i + 1) + ": *");
            }
        }
    }

    private static void resetStrings() {
        first = "";
        last = "";
    }

    private static boolean processPattern(String pattern) {
        if (pattern.charAt(0) == '*') {
            return solve(pattern, 0) == 1;
        } else if (pattern.charAt(pattern.length() - 1) == '*') {
            return solve(pattern, 1) == 1;
        } else {
            return solve(pattern, 2) == 1;
        }
    }

    private static String mergeFirstAndLast() {
        StringBuilder merged = new StringBuilder(first);
        int overlapIndex = findOverlapIndex();
        merged.append(last.substring(overlapIndex));
        return merged.toString();
    }

    private static int findOverlapIndex() {
        int j = 0, k = 0;
        for (j = 0, k = 0; j < first.length();) {
            if (first.charAt(j) == last.charAt(k)) {
                j++;
                k++;
            } else {
                j++;
                k = 0;
            }
        }
        return k;
    }

    public static int solve(String str, int type) {
        switch (type) {
            case 0:
                return processSuffix(str);
            case 1:
                return processPrefix(str);
            case 2:
                return processMiddle(str);
            default:
                return 0;
        }
    }

    private static int processSuffix(String str) {
        int i = str.length() - 1, j = last.length() - 1;
        while (i >= 0 && j >= 0) {
            if (str.charAt(i) == last.charAt(j)) {
                i--;
                j--;
            } else if (str.charAt(i) != '*') {
                return 0;
            } else {
                break;
            }
        }
        if (j < 0) {
            last = str.substring(1, i + 1) + last;
        }
        return 1;
    }

    private static int processPrefix(String str) {
        int i = 0, j = 0;
        while (i < str.length() && j < first.length()) {
            if (str.charAt(i) == first.charAt(j)) {
                i++;
                j++;
            } else if (str.charAt(i) != '*') {
                return 0;
            } else {
                break;
            }
        }
        if (j == first.length()) {
            first += str.substring(i, str.length() - 1);
        }
        return 1;
    }

    private static int processMiddle(String str) {
        int i = 0, j = 0;
        while (str.charAt(i) != '*' && j < first.length()) {
            if (str.charAt(i) == first.charAt(j)) {
                i++;
                j++;
            } else if (str.charAt(i) != '*') {
                return 0;
            } else {
                break;
            }
        }

        int k = i;
        while (str.charAt(k) != '*') {
            k++;
        }
        first += str.substring(i, k);

        i = str.length() - 1;
        j = last.length() - 1;
        while (str.charAt(i) != '*' && j >= 0) {
            if (str.charAt(i) == last.charAt(j)) {
                i--;
                j--;
            } else if (str.charAt(i) != '*') {
                return 0;
            } else {
                break;
            }
        }

        k = i;
        while (str.charAt(k) != '*') {
            k--;
        }
        last = str.substring(k + 1, i + 1) + last;

        return 1;
    }
}