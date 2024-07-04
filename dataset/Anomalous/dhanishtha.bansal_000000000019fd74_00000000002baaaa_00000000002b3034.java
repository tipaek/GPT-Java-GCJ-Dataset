import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int t = 1; t <= testCases; t++) {
            int n = Integer.parseInt(br.readLine());
            String[] patterns = new String[n];
            String result = "*";
            boolean isValid = true;

            for (int i = 0; i < n; i++) {
                patterns[i] = br.readLine().trim();
                if (isValid && i > 0) {
                    result = findLongestMatch(patterns, patterns[i], i - 1);
                    if (result.equals("*")) {
                        isValid = false;
                    }
                }
            }
            System.out.println("Case #" + t + ": " + result);
        }
    }

    static String findLongestMatch(String[] patterns, String currentPattern, int lastIndex) {
        String longestMatch = "";

        for (int i = 0; i <= lastIndex; i++) {
            String[] currentParts = currentPattern.split("\\*");
            String[] previousParts = patterns[i].split("\\*");

            if (previousParts.length == 2 && previousParts.length == currentParts.length) {
                if (previousParts[0].isEmpty() && currentParts[0].isEmpty()) {
                    if (previousParts[1].length() < currentParts[1].length()) {
                        int k = currentParts[1].length() - 1;
                        for (int j = previousParts[1].length() - 1; j >= 0; j--) {
                            if (previousParts[1].charAt(j) != currentParts[1].charAt(k)) {
                                return "*";
                            }
                            k--;
                        }
                        if (longestMatch.length() < currentParts[1].length()) {
                            longestMatch = currentParts[1];
                        }
                    } else {
                        int k = previousParts[1].length() - 1;
                        for (int j = currentParts[1].length() - 1; j >= 0; j--) {
                            if (previousParts[1].charAt(k) != currentParts[1].charAt(j)) {
                                return "*";
                            }
                            k--;
                        }
                        if (longestMatch.length() < previousParts[1].length()) {
                            longestMatch = previousParts[1];
                        }
                    }
                }
            }
        }
        return longestMatch;
    }
}