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
            resetStrings();
            ArrayList<String> patterns = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                patterns.add(scn.next());
            }
            int isValid = 1;
            for (String pattern : patterns) {
                if (pattern.startsWith("*")) {
                    isValid &= solve(pattern, 0);
                } else if (pattern.endsWith("*")) {
                    isValid &= solve(pattern, 1);
                } else {
                    isValid &= solve(pattern, 2);
                }
            }
            printResult(i, isValid);
        }
    }

    private static void resetStrings() {
        first = "";
        last = "";
    }

    private static void printResult(int caseNumber, int isValid) {
        if (isValid == 1) {
            String result = mergeFirstAndLast();
            System.out.println("Case #" + (caseNumber + 1) + ": " + result);
        } else {
            System.out.println("Case #" + (caseNumber + 1) + ": *");
        }
    }

    private static String mergeFirstAndLast() {
        StringBuilder merged = new StringBuilder(first);
        int j = 0, k = 0;
        while (j < first.length()) {
            if (first.charAt(j) == last.charAt(k)) {
                j++;
                k++;
            } else {
                j++;
                k = 0;
            }
        }
        merged.append(last.substring(k));
        return merged.toString();
    }

    public static int solve(String str, int type) {
        switch (type) {
            case 0:
                return solveSuffix(str);
            case 1:
                return solvePrefix(str);
            case 2:
                return solveMiddle(str);
            default:
                return 0;
        }
    }

    private static int solveSuffix(String str) {
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

    private static int solvePrefix(String str) {
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
        if (j == first.length() && i < str.length()) {
            first += str.substring(i, str.length() - 1);
        }
        return 1;
    }

    private static int solveMiddle(String str) {
        int i = 0, j = 0;
        while (i < str.length() && str.charAt(i) != '*' && j < first.length()) {
            if (str.charAt(i) == first.charAt(j)) {
                i++;
                j++;
            } else if (str.charAt(i) != '*') {
                return 0;
            } else {
                break;
            }
        }
        if (i < str.length()) {
            int k = i;
            while (k < str.length() && str.charAt(k) != '*') {
                k++;
            }
            first += str.substring(i, k);
        }

        i = str.length() - 1;
        j = last.length() - 1;
        while (i >= 0 && str.charAt(i) != '*' && j >= 0) {
            if (str.charAt(i) == last.charAt(j)) {
                i--;
                j--;
            } else if (str.charAt(i) != '*') {
                return 0;
            } else {
                break;
            }
        }
        if (i >= 0) {
            int k = i;
            while (k >= 0 && str.charAt(k) != '*') {
                k--;
            }
            last = str.substring(k + 1, i + 1) + last;
        }
        return 1;
    }
}