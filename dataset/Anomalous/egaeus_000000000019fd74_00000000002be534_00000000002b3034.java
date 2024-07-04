import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        StringBuilder result = new StringBuilder();

        for (int t = 1; t <= testCases; t++) {
            result.append("Case #").append(t).append(": ");
            int n = Integer.parseInt(reader.readLine());
            String[] prefixes = new String[n];
            String[] suffixes = new String[n];
            StringBuilder middlePart = new StringBuilder();
            String longestPrefix = "";
            String longestSuffix = "";

            for (int i = 0; i < n; i++) {
                String pattern = reader.readLine();
                int firstAsterisk = pattern.indexOf('*');
                int lastAsterisk = pattern.lastIndexOf('*');

                String prefix = pattern.substring(0, firstAsterisk);
                String suffix = pattern.substring(lastAsterisk + 1);

                if (prefix.length() > longestPrefix.length()) {
                    longestPrefix = prefix;
                }

                if (suffix.length() > longestSuffix.length()) {
                    longestSuffix = suffix;
                }

                prefixes[i] = prefix;
                suffixes[i] = suffix;

                if (firstAsterisk + 1 < lastAsterisk) {
                    middlePart.append(pattern.substring(firstAsterisk + 1, lastAsterisk));
                }
            }

            boolean isValid = true;

            for (String prefix : prefixes) {
                if (!longestPrefix.startsWith(prefix)) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                for (String suffix : suffixes) {
                    if (!longestSuffix.endsWith(suffix)) {
                        isValid = false;
                        break;
                    }
                }
            }

            if (isValid) {
                result.append(longestPrefix).append(middlePart).append(longestSuffix);
            } else {
                result.append('*');
            }

            result.append('\n');
        }

        System.out.print(result.toString());
    }
}