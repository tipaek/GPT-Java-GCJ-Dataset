import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            String result = solve(scanner);
            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    private static String solve(Scanner scanner) {
        int patternsCount = scanner.nextInt();
        scanner.nextLine();

        List<String> prefixes = new ArrayList<>();
        List<String> suffixes = new ArrayList<>();

        for (int i = 0; i < patternsCount; i++) {
            String pattern = scanner.nextLine();
            String[] parts = pattern.split("\\*");

            prefixes.add(parts[0]);
            if (parts.length > 1) {
                suffixes.add(parts[1]);
            }
        }

        String longestSuffix = findLongestMatchingSuffix(suffixes);
        if (longestSuffix.equals("*")) {
            return "*";
        }

        String longestPrefix = findLongestMatchingPrefix(prefixes);
        if (longestPrefix.equals("*")) {
            return "*";
        }

        return longestPrefix + longestSuffix;
    }

    private static String findLongestMatchingSuffix(List<String> suffixes) {
        String longestSuffix = "";

        for (String suffix : suffixes) {
            if (longestSuffix.isEmpty()) {
                longestSuffix = suffix;
            } else if (suffix.endsWith(longestSuffix) || longestSuffix.endsWith(suffix)) {
                if (suffix.length() > longestSuffix.length()) {
                    longestSuffix = suffix;
                }
            } else {
                return "*";
            }
        }

        return longestSuffix;
    }

    private static String findLongestMatchingPrefix(List<String> prefixes) {
        String longestPrefix = "";

        for (String prefix : prefixes) {
            if (longestPrefix.isEmpty()) {
                longestPrefix = prefix;
            } else if (prefix.startsWith(longestPrefix) || longestPrefix.startsWith(prefix)) {
                if (prefix.length() > longestPrefix.length()) {
                    longestPrefix = prefix;
                }
            } else {
                return "*";
            }
        }

        return longestPrefix;
    }
}