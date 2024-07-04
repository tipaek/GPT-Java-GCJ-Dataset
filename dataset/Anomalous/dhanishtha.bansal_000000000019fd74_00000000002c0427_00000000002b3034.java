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
                    result = matchPatterns(patterns, patterns[i], i - 1);
                    if (result.equals("*")) {
                        isValid = false;
                    }
                }
            }
            System.out.println("Case #" + t + ": " + result);
        }
    }

    static String matchPatterns(String[] patterns, String currentPattern, int num) {
        String matchedString = "";

        for (int i = 0; i <= num; i++) {
            String[] currentParts = currentPattern.split("\\*");
            String[] previousParts = patterns[i].split("\\*");

            if (previousParts.length == 2 && previousParts.length == currentParts.length && previousParts[0].isEmpty() && currentParts[0].isEmpty()) {
                if (previousParts[1].length() < currentParts[1].length()) {
                    int k = currentParts[1].length() - 1;
                    for (int j = previousParts[1].length() - 1; j >= 0; j--) {
                        if (previousParts[1].charAt(j) != currentParts[1].charAt(k)) {
                            return "*";
                        }
                        k--;
                    }
                    if (matchedString.length() < currentParts[1].length()) {
                        matchedString = currentParts[1];
                    }
                } else {
                    int k = previousParts[1].length() - 1;
                    for (int j = currentParts[1].length() - 1; j >= 0; j--) {
                        if (previousParts[1].charAt(k) != currentParts[1].charAt(j)) {
                            return "*";
                        }
                        k--;
                    }
                    if (matchedString.length() < previousParts[1].length()) {
                        matchedString = previousParts[1];
                    }
                }
            } else {
                int j = 0, k = 0;
                StringBuilder res = new StringBuilder();

                while (k < currentPattern.length() && j < patterns[i].length()) {
                    if (currentPattern.charAt(k) == '*') {
                        while (j < patterns[i].length() && patterns[i].charAt(j) != '*') {
                            res.append(patterns[i].charAt(j));
                            j++;
                        }
                        k++;
                    } else if (patterns[i].charAt(j) == '*') {
                        while (k < currentPattern.length() && currentPattern.charAt(k) != '*') {
                            res.append(currentPattern.charAt(k));
                            k++;
                        }
                        j++;
                    } else if (currentPattern.charAt(k) == patterns[i].charAt(j)) {
                        res.append(currentPattern.charAt(k));
                        j++;
                        k++;
                    } else {
                        return "*";
                    }
                }
                if (res.length() > matchedString.length()) {
                    matchedString = res.toString();
                }
            }
        }
        return matchedString;
    }
}