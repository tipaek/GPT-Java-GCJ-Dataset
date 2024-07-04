import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        StringBuilder output = new StringBuilder();

        for (int t = 1; t <= testCases; t++) {
            output.append("Case #").append(t).append(": ");
            int N = Integer.parseInt(reader.readLine());
            String longestPrefix = "";
            String longestSuffix = "";
            String[] prefixes = new String[N];
            String[] suffixes = new String[N];

            for (int i = 0; i < N; i++) {
                String input = reader.readLine();
                int asteriskIndex = input.indexOf('*');
                String prefix = input.substring(0, asteriskIndex);
                String suffix = input.substring(asteriskIndex + 1);

                if (prefix.length() > longestPrefix.length()) {
                    longestPrefix = prefix;
                }

                if (suffix.length() > longestSuffix.length()) {
                    longestSuffix = suffix;
                }

                prefixes[i] = prefix;
                suffixes[i] = suffix;
            }

            boolean isValid = true;
            for (String suffix : suffixes) {
                if (!longestSuffix.endsWith(suffix)) {
                    isValid = false;
                    break;
                }
            }

            for (String prefix : prefixes) {
                if (!longestPrefix.startsWith(prefix)) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                output.append(longestPrefix).append(longestSuffix);
            } else {
                output.append("*");
            }
            output.append("\n");
        }

        System.out.print(output.toString());
    }
}