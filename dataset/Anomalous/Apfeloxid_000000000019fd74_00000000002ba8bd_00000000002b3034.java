import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testAmount = scanner.nextInt();

        for (int testId = 1; testId <= testAmount; testId++) {
            int n = scanner.nextInt();
            scanner.nextLine();

            List<String> prefixes = new ArrayList<>();
            List<String> suffixes = new ArrayList<>();
            List<String> middles = new ArrayList<>();
            List<String> patterns = new ArrayList<>();

            StringBuilder result = new StringBuilder();

            for (int i = 0; i < n; i++) {
                String pattern = scanner.nextLine();
                patterns.add(pattern);
                String[] parts = pattern.split("\\*");

                if (result.length() == 0 && !pattern.contains("*")) {
                    result.append(pattern);
                }

                if (pattern.charAt(0) != '*') {
                    prefixes.add(parts[0]);
                }
                if (pattern.charAt(pattern.length() - 1) != '*') {
                    suffixes.add(parts[parts.length - 1]);
                }
                for (String part : parts) {
                    if (!part.isEmpty()) {
                        middles.add(part);
                    }
                }
            }

            String prefix = findCommonPrefix(prefixes);
            String suffix = findCommonSuffix(suffixes);

            if ("ERROR".equals(prefix) || "ERROR".equals(suffix)) {
                System.out.println("Case #" + testId + ": *");
                continue;
            }

            if (result.length() > 0 && !isPatternPossible(result.toString(), patterns)) {
                System.out.println("Case #" + testId + ": *");
            } else {
                if (result.length() == 0) {
                    result.append(prefix);
                    for (String middle : middles) {
                        result.append(middle);
                    }
                    result.append(suffix);
                }
                System.out.println("Case #" + testId + ": " + result);
            }
        }
    }

    private static String findCommonPrefix(List<String> prefixes) {
        String commonPrefix = "";

        for (String prefix : prefixes) {
            for (int i = 0; i < Math.min(commonPrefix.length(), prefix.length()); i++) {
                if (commonPrefix.charAt(i) != prefix.charAt(i)) {
                    return "ERROR";
                }
            }
            if (prefix.length() > commonPrefix.length()) {
                commonPrefix = prefix;
            }
        }

        return commonPrefix;
    }

    private static String findCommonSuffix(List<String> suffixes) {
        String commonSuffix = "";

        for (String suffix : suffixes) {
            for (int i = 0; i < Math.min(commonSuffix.length(), suffix.length()); i++) {
                if (commonSuffix.charAt(commonSuffix.length() - i - 1) != suffix.charAt(suffix.length() - i - 1)) {
                    return "ERROR";
                }
            }
            if (suffix.length() > commonSuffix.length()) {
                commonSuffix = suffix;
            }
        }

        return commonSuffix;
    }

    private static boolean isPatternPossible(String result, List<String> patterns) {
        for (String pattern : patterns) {
            int resultPointer = 0;
            for (int i = 0; i < pattern.length(); i++) {
                if (pattern.charAt(i) == '*') {
                    continue;
                }

                if (resultPointer >= result.length() || pattern.charAt(i) != result.charAt(resultPointer)) {
                    return false;
                }
                resultPointer++;
            }
        }
        return true;
    }
}