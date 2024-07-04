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
        int n = scanner.nextInt();
        scanner.nextLine();

        List<String> prefixes = new ArrayList<>();
        List<String> suffixes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String pattern = scanner.nextLine();
            String[] parts = pattern.split("\\*");

            prefixes.add(parts[0]);
            if (parts.length > 1) {
                suffixes.add(parts[1]);
            }
        }

        String longestSuffix = findLongestSuffix(suffixes);
        if (longestSuffix.equals("*")) {
            return "*";
        }

        String longestPrefix = findLongestPrefix(prefixes);
        if (longestPrefix.equals("*")) {
            return "*";
        }

        return longestPrefix + longestSuffix;
    }

    private static String findLongestSuffix(List<String> suffixes) {
        String longestSuffix = suffixes.get(0);
        for (int i = 1; i < suffixes.size(); i++) {
            String currentSuffix = suffixes.get(i);
            if (currentSuffix.endsWith(longestSuffix) || longestSuffix.endsWith(currentSuffix)) {
                if (currentSuffix.length() > longestSuffix.length()) {
                    longestSuffix = currentSuffix;
                }
            } else {
                return "*";
            }
        }
        return longestSuffix;
    }

    private static String findLongestPrefix(List<String> prefixes) {
        String longestPrefix = prefixes.get(0);
        for (int i = 1; i < prefixes.size(); i++) {
            String currentPrefix = prefixes.get(i);
            if (currentPrefix.startsWith(longestPrefix) || longestPrefix.startsWith(currentPrefix)) {
                if (currentPrefix.length() > longestPrefix.length()) {
                    longestPrefix = currentPrefix;
                }
            } else {
                return "*";
            }
        }
        return longestPrefix;
    }
}