import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(scanner.nextLine());
            List<String> patterns = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                patterns.add(scanner.nextLine());
            }
            String solution = solve(patterns);
            System.out.println("Case #" + (i + 1) + ": " + solution);
        }
    }

    private static String solve(List<String> patterns) {
        if (patterns.size() == 0) {
            return "*";
        }

        String currentPattern = patterns.get(0);
        int i = 1;
        while (currentPattern != null && i < patterns.size()) {
            currentPattern = merge(currentPattern, 0, patterns.get(i), 0);
            i++;
        }

        if (currentPattern == null) {
            return "*";
        }

        return currentPattern.replace("*", "");
    }

    private static String merge(String pattern1, int i, String pattern2, int j) {
        if (i == pattern1.length() && j == pattern2.length()) {
            return "";
        }

        if (j == pattern2.length()) {
            return merge(pattern2, j, pattern1, i);
        }

        if (i == pattern1.length()) {
            if (pattern2.charAt(j) == '*') {
                return merge(pattern1, i, pattern2, j + 1);
            }

            return null;
        }

        if (pattern1.charAt(i) == '*' && pattern2.charAt(j) == '*') {
            String result = merge(pattern1, i, pattern2, j + 1);

            if (result == null) {
                result = merge(pattern1, i + 1, pattern2, j);
            }

            return result != null ? "*" + result : null;
        }

        if (pattern1.charAt(i) != '*' && pattern2.charAt(j) == '*') {
            return merge(pattern2, j, pattern1, i);
        }

        String result = null;
        if (pattern1.charAt(i) == '*') {
            int k = i;
            while (k < pattern1.length() && pattern1.charAt(k) == '*') {
                k++;
            }
            String tail = merge(pattern1, k, pattern2, j);
            if (tail != null) {
                result = tail;
            } else {
                tail = merge(pattern1, i, pattern2, j + 1);
                if (tail != null) {
                    result = pattern2.charAt(j) + tail;
                }
            }
        } else if (pattern1.charAt(i) == pattern2.charAt(j)) {
            String tail = merge(pattern1, i + 1, pattern2, j + 1);
            if (tail != null) {
                result = pattern1.charAt(i) + tail;
            }
        }

        return result;
    }

}
