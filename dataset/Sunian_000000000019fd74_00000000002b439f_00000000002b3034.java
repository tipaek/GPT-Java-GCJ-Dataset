import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Sun on 4/3/2020.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(scan.nextLine());
            List<Pattern> patterns = new ArrayList<>(N);
            for (int j = 0; j < N; j++) {
                String pattern = scan.nextLine();
                patterns.add(new Pattern(pattern));
            }
            System.out.printf("Case #%d: %s\n", i + 1, handle(patterns));
        }
    }

    private static String handle(List<Pattern> patterns) {
        String longestPrefix = "";
        String longestSuffix = "";
        for (Pattern pattern : patterns) {
            if (pattern.suffix.length() > longestSuffix.length()) {
                longestSuffix = pattern.suffix;
            }
            if (pattern.prefix.length() > longestPrefix.length()) {
                longestPrefix = pattern.prefix;
            }
        }
        for (Pattern pattern : patterns) {
            if (!longestPrefix.startsWith(pattern.prefix)) {
                return "*";
            }
            if (!longestSuffix.endsWith(pattern.suffix)) {
                return "*";
            }
        }
        StringBuilder sb = new StringBuilder(longestPrefix);
        for (Pattern pattern : patterns) {
            for (String s : pattern.inner) {
                sb.append(s);
            }
        }
        sb.append(longestSuffix);
        return sb.toString();
    }

    static class Pattern {
        final String prefix;
        final String suffix;
        final List<String> inner;

        public Pattern(String pattern) {
            while (pattern.contains("**")) {
                pattern = pattern.replace("**", "*");
            }
            List<String> split = new ArrayList<>(Arrays.asList(pattern.split("\\*")));
            if (!pattern.startsWith("*")) {
                prefix = split.remove(0);
            } else {
                prefix = "";
            }
            if (!pattern.endsWith("*")) {
                if (split.isEmpty()) {
                    suffix = prefix;
                } else {
                    suffix = split.remove(split.size() - 1);
                }
            } else {
                suffix = "";
            }
            inner = split;
        }
    }
}
