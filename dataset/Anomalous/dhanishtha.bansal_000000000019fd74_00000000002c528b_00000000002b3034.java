import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = Integer.parseInt(br.readLine());
            String[] patterns = new String[n];
            String result = "*";
            boolean isValid = true;

            for (int i = 0; i < n; i++) {
                patterns[i] = br.readLine().trim();

                if (isValid && i > 0) {
                    result = matchPatterns(patterns, patterns[i], i);
                    if (result.equals("*")) {
                        isValid = false;
                    }
                }
            }
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    static String matchPatterns(String[] patterns, String currentPattern, int numPatterns) {
        String matchedPattern = "";

        for (int i = 0; i < numPatterns; i++) {
            String tempResult = "";
            String[] splitCurrent = currentPattern.split("\\*");
            String[] splitPattern = patterns[i].split("\\*");

            if (splitPattern.length == 2 && splitPattern.length == splitCurrent.length && splitPattern[0].isEmpty() && splitCurrent[0].isEmpty()) {
                if (splitPattern[1].length() < splitCurrent[1].length()) {
                    int k = splitCurrent[1].length() - 1;
                    for (int j = splitPattern[1].length() - 1; j >= 0; j--) {
                        if (splitPattern[1].charAt(j) != splitCurrent[1].charAt(k)) {
                            return "*";
                        }
                        k--;
                    }
                    if (matchedPattern.length() < splitCurrent[1].length()) {
                        matchedPattern = splitCurrent[1];
                    }
                } else {
                    int k = splitPattern[1].length() - 1;
                    for (int j = splitCurrent[1].length() - 1; j >= 0; j--) {
                        if (splitPattern[1].charAt(k) != splitCurrent[1].charAt(j)) {
                            return "*";
                        }
                        k--;
                    }
                    if (matchedPattern.length() < splitPattern[1].length()) {
                        matchedPattern = splitPattern[1];
                    }
                }
            } else {
                int j = 0, k = 0;
                while (k < currentPattern.length() && j < patterns[i].length()) {
                    if (currentPattern.charAt(k) == '*') {
                        while (j < patterns[i].length() && patterns[i].charAt(j) != '*') {
                            tempResult += patterns[i].charAt(j);
                            j++;
                        }
                        k++;
                    } else if (patterns[i].charAt(j) == '*') {
                        while (k < currentPattern.length() && currentPattern.charAt(k) != '*') {
                            tempResult += currentPattern.charAt(k);
                            k++;
                        }
                        j++;
                    } else if (currentPattern.charAt(k) == patterns[i].charAt(j)) {
                        tempResult += currentPattern.charAt(k);
                        j++;
                        k++;
                    } else {
                        return "*";
                    }
                }
                if (j != patterns[i].length()) {
                    int t = patterns[i].length() - 1;
                    k--;
                    while (t >= j) {
                        if (k >= 0 && patterns[i].charAt(t) != currentPattern.charAt(k)) {
                            return "*";
                        }
                        t--;
                        k--;
                    }
                } else if (k != currentPattern.length()) {
                    int t = currentPattern.length() - 1;
                    j--;
                    while (t >= k) {
                        if (j >= 0 && patterns[i].charAt(j) != currentPattern.charAt(t)) {
                            return "*";
                        }
                        t--;
                        j--;
                    }
                }
                if (tempResult.length() > matchedPattern.length()) {
                    matchedPattern = tempResult;
                }
            }
        }
        return matchedPattern;
    }
}