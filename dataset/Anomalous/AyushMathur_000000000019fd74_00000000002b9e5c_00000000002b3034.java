import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder output = new StringBuilder();
            int T = Integer.parseInt(reader.readLine().trim());

            for (int t = 1; t <= T; t++) {
                output.append("Case #").append(t).append(": ");
                int N = Integer.parseInt(reader.readLine().trim());
                String[] patterns = new String[N];

                for (int i = 0; i < N; i++) {
                    patterns[i] = reader.readLine().trim();
                }

                output.append(getPossibleCombination(N, patterns)).append("\n");
            }

            System.out.print(output);
        }
    }

    private static String getPossibleCombination(int n, String[] patterns) {
        StringBuilder answer = new StringBuilder();
        List<String> prefixes = new ArrayList<>(n);
        List<String> suffixes = new ArrayList<>(n);

        for (String pattern : patterns) {
            int firstAsterisk = pattern.indexOf('*');
            int lastAsterisk = pattern.lastIndexOf('*');

            if (firstAsterisk > 0) {
                prefixes.add(pattern.substring(0, firstAsterisk));
            }

            if (lastAsterisk >= 0 && lastAsterisk != pattern.length() - 1) {
                suffixes.add(pattern.substring(lastAsterisk + 1));
            }

            if (firstAsterisk != lastAsterisk) {
                answer.append(getReducedString(pattern.substring(firstAsterisk + 1, lastAsterisk)));
            }
        }

        String prefix = getPossiblePrefix(prefixes);
        String suffix = getPossibleSuffix(suffixes);

        if ("IMPOSSIBLE".equals(prefix) || "IMPOSSIBLE".equals(suffix)) {
            return "*";
        }

        return prefix + answer.toString() + suffix;
    }

    private static String getPossibleSuffix(List<String> suffixes) {
        if (suffixes.isEmpty()) {
            return "";
        }

        suffixes.sort(Comparator.comparingInt(String::length));
        String suffix = suffixes.remove(suffixes.size() - 1);
        int length = suffix.length();

        for (String s : suffixes) {
            int sLength = s.length();
            for (int i = 0; i < sLength; i++) {
                if (s.charAt(i) != suffix.charAt(length - sLength + i)) {
                    return "IMPOSSIBLE";
                }
            }
        }

        return suffix;
    }

    private static String getPossiblePrefix(List<String> prefixes) {
        if (prefixes.isEmpty()) {
            return "";
        }

        prefixes.sort(Comparator.comparingInt(String::length));
        String prefix = prefixes.remove(prefixes.size() - 1);

        for (String s : prefixes) {
            int sLength = s.length();
            for (int i = 0; i < sLength; i++) {
                if (s.charAt(i) != prefix.charAt(i)) {
                    return "IMPOSSIBLE";
                }
            }
        }

        return prefix;
    }

    private static String getReducedString(String str) {
        StringBuilder reducedString = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c != '*') {
                reducedString.append(c);
            }
        }
        return reducedString.toString();
    }
}