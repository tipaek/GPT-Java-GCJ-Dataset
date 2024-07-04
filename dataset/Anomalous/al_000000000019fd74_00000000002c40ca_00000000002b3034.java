import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCount = scanner.nextInt();

        for (int i = 0; i < testCount; i++) {
            int count = scanner.nextInt();
            List<String> patterns = new ArrayList<>();
            for (int j = 0; j < count; j++) {
                patterns.add(scanner.next());
            }
            String result = solve(patterns);
            System.out.println("Case #" + (i + 1) + ": " + result);
        }

        scanner.close();
    }

    private static String solve(List<String> patterns) {
        List<List<String>> split = splitPatterns(patterns);
        List<String> prefix = split.get(0);
        List<String> suffix = split.get(1);

        // Resolve suffix
        String resolvedSuffix = resolveSuffix(suffix);
        if (resolvedSuffix.equals("*")) {
            return "*";
        }

        // Resolve prefix
        String resolvedPrefix = resolvePrefix(prefix);
        if (resolvedPrefix.equals("*")) {
            return "*";
        }

        return resolvedPrefix + resolvedSuffix;
    }

    private static String resolveSuffix(List<String> suffix) {
        int suffixOffset = 0;
        while (suffix.size() > 1) {
            char c = '-';
            for (int i = suffix.size() - 1; i >= 0; i--) {
                String pattern = suffix.get(i);
                int index = pattern.length() - suffixOffset - 1;
                if (index < 0) {
                    if (suffix.size() == 1) {
                        break;
                    }
                    suffix.remove(i);
                    continue;
                }
                char read = pattern.charAt(index);
                if (c == '-') {
                    c = read;
                } else if (c != read) {
                    return "*";
                }
            }
            suffixOffset++;
        }
        return suffix.get(0);
    }

    private static String resolvePrefix(List<String> prefix) {
        int prefixOffset = 0;
        while (prefix.size() > 1) {
            char c = '-';
            for (int i = prefix.size() - 1; i >= 0; i--) {
                String pattern = prefix.get(i);
                if (prefixOffset >= pattern.length()) {
                    if (prefix.size() == 1) {
                        break;
                    }
                    prefix.remove(i);
                    continue;
                }
                char read = pattern.charAt(prefixOffset);
                if (c == '-') {
                    c = read;
                } else if (c != read) {
                    return "*";
                }
            }
            prefixOffset++;
        }
        return prefix.get(0);
    }

    private static List<List<String>> splitPatterns(List<String> patterns) {
        List<String> prefix = new ArrayList<>();
        List<String> suffix = new ArrayList<>();
        for (String pattern : patterns) {
            String[] split = pattern.split("\\*", 2);
            prefix.add(split[0]);
            if (split.length == 1) {
                suffix.add("");
            } else {
                suffix.add(split[1]);
            }
        }
        List<List<String>> result = new ArrayList<>();
        result.add(prefix);
        result.add(suffix);
        return result;
    }
}