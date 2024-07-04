import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int patternCount = scanner.nextInt();
            scanner.nextLine();
            List<String> prefixes = new ArrayList<>();
            List<String> suffixes = new ArrayList<>();

            for (int j = 0; j < patternCount; j++) {
                String pattern = scanner.nextLine();
                int starIndex = pattern.indexOf('*');
                prefixes.add(pattern.substring(0, starIndex));
                suffixes.add(pattern.substring(starIndex + 1));
            }

            prefixes.sort(Comparator.comparingInt(String::length));
            suffixes.sort(Comparator.comparingInt(String::length));

            String prefix = findCommonPrefix(prefixes);
            String suffix = findCommonSuffix(suffixes);
            String result = prefix + suffix;

            if (prefix.equals("*") || suffix.equals("*")) {
                result = "*";
            }

            System.out.println("Case #" + caseNumber + ": " + result);
        }
    }

    private static String findCommonPrefix(List<String> prefixes) {
        String largestPrefix = prefixes.get(prefixes.size() - 1);
        for (int i = prefixes.size() - 2; i >= 0; i--) {
            if (!largestPrefix.startsWith(prefixes.get(i))) {
                return "*";
            }
        }
        return largestPrefix;
    }

    private static String findCommonSuffix(List<String> suffixes) {
        String largestSuffix = suffixes.get(suffixes.size() - 1);
        for (int i = suffixes.size() - 2; i >= 0; i--) {
            if (!largestSuffix.endsWith(suffixes.get(i))) {
                return "*";
            }
        }
        return largestSuffix;
    }
}