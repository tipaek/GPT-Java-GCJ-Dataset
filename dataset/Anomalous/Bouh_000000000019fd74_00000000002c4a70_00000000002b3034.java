import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String result = solveProblem(scanner);
        System.out.println(result);
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
        String longestPrefix = "";
        String longestSuffix = "";
        boolean prefixLocked = false;
        boolean suffixLocked = false;
        List<String> middleParts = new ArrayList<>();

        for (String pattern : patterns) {
            pattern = pattern.replace("**", "*");
            String[] parts = split(pattern);

            if (!pattern.startsWith("*")) {
                prefixLocked = true;
                String prefix = parts[0];
                if (longestPrefix.length() >= prefix.length()) {
                    if (!longestPrefix.startsWith(prefix)) {
                        return "*";
                    }
                } else {
                    if (!prefix.startsWith(longestPrefix)) {
                        return "*";
                    } else {
                        longestPrefix = prefix;
                    }
                }
            }

            if (!pattern.endsWith("*")) {
                suffixLocked = true;
                String suffix = parts[parts.length - 1];
                if (longestSuffix.length() >= suffix.length()) {
                    if (!longestSuffix.endsWith(suffix)) {
                        return "*";
                    }
                } else {
                    if (!suffix.endsWith(longestSuffix)) {
                        return "*";
                    } else {
                        longestSuffix = suffix;
                    }
                }
            }
        }

        if (!longestPrefix.isEmpty()) {
            middleParts.add(longestPrefix);
        }
        for (String pattern : patterns) {
            String[] parts = split(pattern);
            for (int i = 1; i < parts.length - 1; i++) {
                middleParts.add(parts[i]);
            }
        }
        if (!longestSuffix.isEmpty()) {
            middleParts.add(longestSuffix);
        }

        for (String part : middleParts) {
            result.append(part);
        }
        return result.toString();
    }

    public static String[] split(String str) {
        List<String> parts = new ArrayList<>();
        int start = 0;
        int end;
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