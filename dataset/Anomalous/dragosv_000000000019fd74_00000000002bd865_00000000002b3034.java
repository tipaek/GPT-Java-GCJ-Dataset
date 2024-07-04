import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            List<String> prefixes = new ArrayList<>();
            List<String> suffixes = new ArrayList<>();
            int longestSuffixIdx = 0;
            int longestSuffixLength = 0;
            int longestPrefixIdx = 0;
            int longestPrefixLength = 0;

            for (int i = 0; i < n; i++) {
                String str = scanner.next();
                String[] parts = str.split("\\*");
                String prefix = parts[0];
                String suffix = (parts.length > 1) ? parts[1] : "";

                if (suffix.length() > longestSuffixLength) {
                    longestSuffixLength = suffix.length();
                    longestSuffixIdx = i;
                }
                if (prefix.length() > longestPrefixLength) {
                    longestPrefixLength = prefix.length();
                    longestPrefixIdx = i;
                }

                prefixes.add(prefix);
                suffixes.add(suffix);
            }

            boolean isPossible = true;
            for (int i = 0; i < n && isPossible; i++) {
                for (int j = i + 1; j < n && isPossible; j++) {
                    if (!suffixesMatch(suffixes.get(i), suffixes.get(j)) ||
                        !prefixesMatch(prefixes.get(i), prefixes.get(j))) {
                        isPossible = false;
                    }
                }
            }

            if (isPossible) {
                System.out.println("Case #" + t + ": " + suffixes.get(longestSuffixIdx) + prefixes.get(longestPrefixIdx));
            } else {
                System.out.println("Case #" + t + ": *");
            }
        }
    }

    private static boolean suffixesMatch(String suffix1, String suffix2) {
        int len1 = suffix1.length();
        int len2 = suffix2.length();
        int minLength = Math.min(len1, len2);

        for (int i = 1; i <= minLength; i++) {
            if (suffix1.charAt(len1 - i) != suffix2.charAt(len2 - i)) {
                return false;
            }
        }
        return true;
    }

    private static boolean prefixesMatch(String prefix1, String prefix2) {
        int len1 = prefix1.length();
        int len2 = prefix2.length();
        int minLength = Math.min(len1, len2);

        for (int i = 0; i < minLength; i++) {
            if (prefix1.charAt(i) != prefix2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static int sum(int x, int y) {
        return x + y;
    }
}