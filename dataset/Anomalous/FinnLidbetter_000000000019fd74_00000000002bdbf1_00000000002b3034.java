import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        int testCases = Integer.parseInt(reader.readLine());
        for (int test = 1; test <= testCases; test++) {
            int n = Integer.parseInt(reader.readLine());
            String[] patterns = new String[n];
            String[] strippedPatterns = new String[n];
            String maxPrefix = "";
            String maxSuffix = "";

            int starFreeIndex = -1;
            for (int i = 0; i < n; i++) {
                patterns[i] = reader.readLine();
                StringBuilder prefixBuilder = new StringBuilder();
                StringBuilder suffixBuilder = new StringBuilder();

                int j = 0;
                while (j < patterns[i].length() && patterns[i].charAt(j) != '*') {
                    prefixBuilder.append(patterns[i].charAt(j));
                    j++;
                }

                if (prefixBuilder.length() > maxPrefix.length()) {
                    maxPrefix = prefixBuilder.toString();
                }

                if (j == patterns[i].length()) {
                    starFreeIndex = i;
                }

                int prefixLength = prefixBuilder.length();
                int k = patterns[i].length() - 1;
                while (k >= 0 && patterns[i].charAt(k) != '*') {
                    suffixBuilder.append(patterns[i].charAt(k));
                    k--;
                }

                suffixBuilder.reverse();
                if (suffixBuilder.length() > maxSuffix.length()) {
                    maxSuffix = suffixBuilder.toString();
                }

                int suffixLength = suffixBuilder.length();
                if (prefixLength == patterns[i].length()) {
                    strippedPatterns[i] = "";
                } else {
                    String middle = patterns[i].substring(prefixLength, patterns[i].length() - suffixLength);
                    strippedPatterns[i] = middle.replace("*", "");
                }
            }

            String result;
            if (starFreeIndex >= 0) {
                result = patterns[starFreeIndex];
                for (int i = 0; i < n; i++) {
                    if (!matchesPrefix(patterns[i], result) || !matchesSuffix(patterns[i], result)) {
                        result = "*";
                        break;
                    }
                }
            } else {
                result = maxPrefix;
                for (int i = 0; i < n; i++) {
                    if (!matchesPrefix(patterns[i], maxPrefix) || !matchesSuffix(patterns[i], maxSuffix)) {
                        result = "*";
                        break;
                    }
                }
                if (!result.equals("*")) {
                    StringBuilder combinedResult = new StringBuilder(maxPrefix);
                    for (String strippedPattern : strippedPatterns) {
                        combinedResult.append(strippedPattern);
                    }
                    combinedResult.append(maxSuffix);
                    result = combinedResult.toString();
                }
            }

            output.append(String.format("Case #%d: %s\n", test, result));
        }
        System.out.print(output);
    }

    private static boolean matchesPrefix(String text, String prefix) {
        int textLength = text.length();
        int prefixLength = prefix.length();
        for (int i = 0; i < prefixLength; i++) {
            if (i >= textLength || text.charAt(i) == '*' || text.charAt(i) != prefix.charAt(i)) {
                return text.charAt(i) == '*';
            }
        }
        return true;
    }

    private static boolean matchesSuffix(String text, String suffix) {
        int textLength = text.length();
        int suffixLength = suffix.length();
        for (int i = 0; i < suffixLength; i++) {
            if (textLength - i - 1 < 0 || text.charAt(textLength - i - 1) == '*' || text.charAt(textLength - i - 1) != suffix.charAt(suffixLength - i - 1)) {
                return text.charAt(textLength - i - 1) == '*';
            }
        }
        return true;
    }
}