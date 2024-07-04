import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int patternsCount = scanner.nextInt();
            scanner.nextLine();
            List<String> prefixes = new ArrayList<>();
            List<String> suffixes = new ArrayList<>();

            for (int j = 0; j < patternsCount; j++) {
                String pattern = scanner.nextLine();
                int asteriskIndex = pattern.indexOf("*");
                prefixes.add(pattern.substring(0, asteriskIndex));
                suffixes.add(pattern.substring(asteriskIndex + 1));
            }

            prefixes.sort(Comparator.comparingInt(String::length));
            suffixes.sort(Comparator.comparingInt(String::length));

            String prefix = findCommonPrefix(prefixes);
            String suffix = findCommonSuffix(suffixes);
            String result = prefix + suffix;

            if (prefix.equals("*") && suffix.equals("*")) {
                result = "*";
            } else if (prefix.equals("*")) {
                result = suffix;
            } else if (suffix.equals("*")) {
                result = prefix;
            }

            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    private static String findCommonPrefix(List<String> prefixes) {
        String longestPrefix = prefixes.get(prefixes.size() - 1);
        for (int i = prefixes.size() - 2; i >= 0; i--) {
            if (!longestPrefix.startsWith(prefixes.get(i))) {
                return "*";
            }
        }
        return longestPrefix.isEmpty() ? "*" : longestPrefix;
    }

    private static String findCommonSuffix(List<String> suffixes) {
        String longestSuffix = suffixes.get(suffixes.size() - 1);
        for (int i = suffixes.size() - 2; i >= 0; i--) {
            if (!longestSuffix.endsWith(suffixes.get(i))) {
                return "*";
            }
        }
        return longestSuffix.isEmpty() ? "*" : longestSuffix;
    }
}