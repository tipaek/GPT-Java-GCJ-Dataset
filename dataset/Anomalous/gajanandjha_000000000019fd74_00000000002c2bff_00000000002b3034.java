import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine().trim());

        for (int t = 1; t <= testCases; t++) {
            boolean isMismatch = false;
            int N = Integer.parseInt(br.readLine().trim());
            String[] patterns = new String[N];
            String longestPrefix = "", longestSuffix = "";

            for (int i = 0; i < N; i++) {
                patterns[i] = br.readLine().trim();
                String prefix = patterns[i].substring(0, patterns[i].indexOf("*"));
                if (prefix.length() > longestPrefix.length()) {
                    longestPrefix = prefix;
                }
                String reversedPattern = new StringBuilder(patterns[i]).reverse().toString();
                String suffix = reversedPattern.substring(0, reversedPattern.indexOf("*"));
                if (suffix.length() > longestSuffix.length()) {
                    longestSuffix = suffix;
                }
            }

            StringBuilder middle = new StringBuilder();
            for (String pattern : patterns) {
                if (!pattern.startsWith("*")) {
                    String prefix = pattern.substring(0, pattern.indexOf("*"));
                    if (!prefix.equals(longestPrefix.substring(0, prefix.length()))) {
                        isMismatch = true;
                        break;
                    }
                }
                if (!pattern.endsWith("*")) {
                    String reversedPattern = new StringBuilder(pattern).reverse().toString();
                    String suffix = reversedPattern.substring(0, reversedPattern.indexOf("*"));
                    if (!suffix.equals(longestSuffix.substring(0, suffix.length()))) {
                        isMismatch = true;
                        break;
                    }
                }
                String[] parts = pattern.split("\\*");
                for (int j = 1; j < parts.length - 1; j++) {
                    middle.append(parts[j]);
                }
            }

            if (isMismatch) {
                System.out.println("Case #" + t + ": *");
            } else {
                String result = longestPrefix + middle.toString() + new StringBuilder(longestSuffix).reverse().toString();
                System.out.println("Case #" + t + ": " + result);
            }
        }
    }
}