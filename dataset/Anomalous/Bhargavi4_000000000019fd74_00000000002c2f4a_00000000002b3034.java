import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tests = br.readLine();
        if (tests == null) return;

        int t = Integer.parseInt(tests);
        StringBuilder sb = new StringBuilder();

        for (int k = 0; k < t; k++) {
            sb.append("case #").append(k).append(": ");
            String num = br.readLine();
            if (num == null) return;

            int n = Integer.parseInt(num);
            String[] prefix = new String[n];
            String[] suffix = new String[n];
            String[] in = new String[n];

            for (int i = 0; i < n; i++) {
                String str = br.readLine();
                if (str == null) return;

                String[] s = str.split("\\*");
                prefix[i] = s[0];
                suffix[i] = s[s.length - 1];
                in[i] = str;
            }

            Arrays.sort(prefix, (a, b) -> Integer.compare(a.length(), b.length()));
            Arrays.sort(suffix, (a, b) -> Integer.compare(a.length(), b.length()));

            String outP = findLongestCommonPrefix(prefix);
            String outS = findLongestCommonSuffix(suffix);

            if (outP != null && outS != null) {
                sb.append(outP).append(outS);
            } else {
                sb.append("*");
            }

            sb.append("\n");
        }

        System.out.print(sb.toString().trim());
    }

    private static String findLongestCommonPrefix(String[] prefixes) {
        String commonPrefix = prefixes[0];
        for (String prefix : prefixes) {
            if (prefix.isEmpty()) continue;
            if (commonPrefix.contains(prefix)) {
                commonPrefix = prefix;
            } else if (!prefix.contains(commonPrefix)) {
                return null;
            }
        }
        return commonPrefix;
    }

    private static String findLongestCommonSuffix(String[] suffixes) {
        String commonSuffix = suffixes[0];
        for (String suffix : suffixes) {
            if (suffix.isEmpty()) continue;
            if (commonSuffix.contains(suffix)) {
                commonSuffix = suffix;
            } else if (!suffix.contains(commonSuffix)) {
                return null;
            }
        }
        return commonSuffix;
    }
}