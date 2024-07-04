import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            String[] patterns = new String[n];
            for (int i = 0; i < n; i++) {
                patterns[i] = scanner.next();
            }

            List<String> prefixes = new ArrayList<>();
            List<String> suffixes = new ArrayList<>();

            for (String pattern : patterns) {
                int asteriskIndex = pattern.indexOf('*');
                if (asteriskIndex > 0) {
                    prefixes.add(pattern.substring(0, asteriskIndex));
                }
                if (asteriskIndex < pattern.length() - 1) {
                    suffixes.add(pattern.substring(asteriskIndex + 1));
                }
            }

            String longestPrefix = findLongest(prefixes);
            String longestSuffix = findLongest(suffixes);

            boolean isValid = validatePrefixes(prefixes, longestPrefix) && validateSuffixes(suffixes, longestSuffix);

            String result = isValid ? longestPrefix + longestSuffix : "*";
            System.out.println("Case #" + (t + 1) + ": " + result);
        }
    }

    private static String findLongest(List<String> list) {
        String longest = "";
        for (String str : list) {
            if (str.length() > longest.length()) {
                longest = str;
            }
        }
        return longest;
    }

    private static boolean validatePrefixes(List<String> prefixes, String longestPrefix) {
        for (String prefix : prefixes) {
            if (!longestPrefix.startsWith(prefix)) {
                return false;
            }
        }
        return true;
    }

    private static boolean validateSuffixes(List<String> suffixes, String longestSuffix) {
        for (String suffix : suffixes) {
            if (!longestSuffix.endsWith(suffix)) {
                return false;
            }
        }
        return true;
    }
}