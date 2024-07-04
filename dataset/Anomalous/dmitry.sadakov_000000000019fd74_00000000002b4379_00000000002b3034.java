import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            String result = solve(scanner);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String solve(Scanner scanner) {
        int n = scanner.nextInt();
        scanner.nextLine();

        List<String> prefixes = new ArrayList<>();
        List<String> suffixes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = scanner.nextLine().split("\\*");
            prefixes.add(parts[0]);
            suffixes.add(parts[1]);
        }

        String suffix = validateSuffixes(suffixes);
        if (suffix.equals("*")) {
            return "*";
        }

        String prefix = validatePrefixes(prefixes);
        if (prefix.equals("*")) {
            return "*";
        }

        return prefix + suffix;
    }

    private static String validateSuffixes(List<String> suffixes) {
        String suffix = suffixes.get(0);
        for (int i = 1; i < suffixes.size(); i++) {
            String currentSuffix = suffixes.get(i);
            if (currentSuffix.endsWith(suffix) || suffix.endsWith(currentSuffix)) {
                if (suffix.length() < currentSuffix.length()) {
                    suffix = currentSuffix;
                }
            } else {
                return "*";
            }
        }
        return suffix;
    }

    private static String validatePrefixes(List<String> prefixes) {
        String prefix = prefixes.get(0);
        for (int i = 1; i < prefixes.size(); i++) {
            String currentPrefix = prefixes.get(i);
            if (currentPrefix.startsWith(prefix) || prefix.startsWith(currentPrefix)) {
                if (prefix.length() < currentPrefix.length()) {
                    prefix = currentPrefix;
                }
            } else {
                return "*";
            }
        }
        return prefix;
    }
}