import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            String result = solveProblem(scanner);
            System.out.println(result);
        }
    }

    public static String solveProblem(Scanner scanner) {
        StringBuilder result = new StringBuilder();
        int t = scanner.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = scanner.nextInt();
            String[] patterns = new String[n];
            for (int j = 0; j < n; j++) {
                patterns[j] = scanner.next();
            }
            result.append("Case #").append(i).append(": ").append(solveCase(patterns)).append("\n");
        }
        return result.toString();
    }

    public static String solveCase(String[] patterns) {
        StringBuilder result = new StringBuilder();
        String maxPrefix = "";
        String maxSuffix = "";
        boolean prefixLocked = false;
        boolean suffixLocked = false;
        List<String> middleParts = new ArrayList<>();

        for (String pattern : patterns) {
            pattern = pattern.replace("**", "*");
            String[] parts = splitPattern(pattern);

            if (!pattern.startsWith("*")) {
                prefixLocked = true;
                String prefix = parts[0];
                if (maxPrefix.length() >= prefix.length()) {
                    if (!maxPrefix.startsWith(prefix)) {
                        return "*";
                    }
                } else {
                    if (!prefix.startsWith(maxPrefix)) {
                        return "*";
                    } else {
                        maxPrefix = prefix;
                    }
                }
            }

            if (!pattern.endsWith("*")) {
                suffixLocked = true;
                String suffix = parts[parts.length - 1];
                if (maxSuffix.length() >= suffix.length()) {
                    if (!maxSuffix.endsWith(suffix)) {
                        return "*";
                    }
                } else {
                    if (!suffix.endsWith(maxSuffix)) {
                        return "*";
                    } else {
                        maxSuffix = suffix;
                    }
                }
            }
        }

        if (!maxPrefix.isEmpty()) {
            middleParts.add(maxPrefix);
        }
        if (!maxSuffix.isEmpty()) {
            middleParts.add(maxSuffix);
        }

        for (String pattern : patterns) {
            String[] parts = splitPattern(pattern);
            for (String part : parts) {
                if (!part.isEmpty()) {
                    middleParts.add(middleParts.size() - 1, part);
                }
            }
        }

        for (String part : middleParts) {
            result.append(part);
        }

        return result.toString();
    }

    public static String[] splitPattern(String str) {
        List<String> parts = new ArrayList<>();
        int start = 0, end;
        while ((end = str.indexOf('*', start)) != -1) {
            if (end > start) {
                parts.add(str.substring(start, end));
            }
            start = end + 1;
        }
        if (start < str.length()) {
            parts.add(str.substring(start));
        }
        return parts.toArray(new String[0]);
    }
}