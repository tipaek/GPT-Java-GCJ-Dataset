import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    static String first = "", last = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            int n = scanner.nextInt();
            first = "";
            last = "";
            ArrayList<String> patterns = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                patterns.add(scanner.next());
            }
            boolean isPossible = true;
            for (String pattern : patterns) {
                if (pattern.startsWith("*")) {
                    isPossible &= processPattern(pattern, 0);
                } else if (pattern.endsWith("*")) {
                    isPossible &= processPattern(pattern, 1);
                } else {
                    isPossible &= processPattern(pattern, 2);
                }
            }
            if (isPossible) {
                String result = first;
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
                result += last.substring(k);
                System.out.println("Case #" + (i + 1) + ": " + result);
            } else {
                System.out.println("Case #" + (i + 1) + ": *");
            }
        }
    }

    public static boolean processPattern(String pattern, int type) {
        if (type == 0) {
            int i = pattern.length() - 1, j = last.length() - 1;
            while (i >= 0 && j >= 0 && pattern.charAt(i) != '*') {
                if (pattern.charAt(i) == last.charAt(j)) {
                    i--;
                    j--;
                } else {
                    return false;
                }
            }
            if (j < 0 && pattern.length() > 1) {
                last = pattern.substring(1, i + 1) + last;
            }
        } else if (type == 1) {
            int i = 0, j = 0;
            while (i < pattern.length() && j < first.length() && pattern.charAt(i) != '*') {
                if (pattern.charAt(i) == first.charAt(j)) {
                    i++;
                    j++;
                } else {
                    return false;
                }
            }
            if (j == first.length()) {
                first += pattern.substring(i, pattern.length() - 1);
            }
        } else {
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
        }
        return true;
    }
}