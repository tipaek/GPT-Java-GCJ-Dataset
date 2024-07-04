import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            String[] patterns = new String[n];

            for (int i = 0; i < n; i++) {
                patterns[i] = scanner.next().replace("*", "");
            }

            String longestPattern = "";
            for (String pattern : patterns) {
                if (pattern.length() > longestPattern.length()) {
                    longestPattern = pattern;
                }
            }

            boolean isValid = true;
            for (String pattern : patterns) {
                if (!longestPattern.contains(pattern)) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                System.out.println("Case #" + caseNum + ": " + longestPattern);
            } else {
                System.out.println("Case #" + caseNum + ": *");
            }
        }
    }
}