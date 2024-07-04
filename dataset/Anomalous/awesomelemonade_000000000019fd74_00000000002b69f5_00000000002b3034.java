import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        int t = Integer.parseInt(reader.readLine());
        for (int tt = 0; tt < t; tt++) {
            int n = Integer.parseInt(reader.readLine());
            String[] patterns = new String[n];
            for (int i = 0; i < n; i++) {
                patterns[i] = reader.readLine();
            }

            String[] prefixes = new String[n];
            String[] suffixes = new String[n];
            StringBuilder middle = new StringBuilder();

            for (int i = 0; i < n; i++) {
                int firstStar = patterns[i].indexOf('*');
                int lastStar = patterns[i].lastIndexOf('*');
                prefixes[i] = patterns[i].substring(0, firstStar);
                suffixes[i] = patterns[i].substring(lastStar + 1);

                for (int j = firstStar + 1; j < lastStar; j++) {
                    middle.append(patterns[i].charAt(j));
                }
            }

            String maxPrefix = "";
            String maxSuffix = "";

            for (int i = 0; i < n; i++) {
                if (prefixes[i].length() > maxPrefix.length()) {
                    maxPrefix = prefixes[i];
                }
                if (suffixes[i].length() > maxSuffix.length()) {
                    maxSuffix = suffixes[i];
                }
            }

            boolean isPossible = true;
            for (int i = 0; i < n; i++) {
                if (!maxPrefix.startsWith(prefixes[i]) || !maxSuffix.endsWith(suffixes[i])) {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                writer.printf("Case #%d: %s\n", tt + 1, maxPrefix + middle.toString() + maxSuffix);
            } else {
                writer.printf("Case #%d: *\n", tt + 1);
            }
        }

        reader.close();
        writer.close();
    }
}