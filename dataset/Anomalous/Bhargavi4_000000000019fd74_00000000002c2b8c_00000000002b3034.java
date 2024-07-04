import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class PatternMatch {

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
            String[] prefixes = new String[n];
            String[] suffixes = new String[n];
            String[] inputs = new String[n];

            for (int i = 0; i < n; i++) {
                String str = br.readLine();
                if (str == null) return;

                String[] parts = str.split("\\*");
                prefixes[i] = parts[0];
                suffixes[i] = parts[parts.length - 1];
                inputs[i] = str;
            }

            Arrays.sort(prefixes, (a, b) -> Integer.compare(a.length(), b.length()));
            Arrays.sort(suffixes, (a, b) -> Integer.compare(a.length(), b.length()));

            String longestPrefix = findLongestMatch(prefixes);
            String longestSuffix = findLongestMatch(suffixes);

            if (longestPrefix == null || longestSuffix == null) {
                sb.append("*");
            } else {
                sb.append(longestPrefix).append(longestSuffix);
            }
            sb.append("\n");
        }

        System.out.print(sb.toString().trim());
    }

    private static String findLongestMatch(String[] strings) {
        String longest = strings[0];

        for (String str : strings) {
            if (str.isEmpty()) continue;
            if (longest.contains(str)) {
                longest = str;
            } else {
                return null;
            }
        }

        return longest;
    }
}