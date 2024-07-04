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
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();

        for (int t = 1; t <= tests; t++) {
            int n = sc.nextInt();
            List<String> prefixes = new ArrayList<>();
            List<String> suffixes = new ArrayList<>();
            int longestPrefixIdx = 0;
            int longestSuffixIdx = 0;
            int maxPrefixLength = 0;
            int maxSuffixLength = 0;

            for (int j = 0; j < n; j++) {
                String str = sc.next();
                String[] parts = str.split("\\*", 2);
                String prefix = parts[0];
                String suffix = parts.length > 1 ? parts[1] : "";

                if (suffix.length() > maxSuffixLength) {
                    maxSuffixLength = suffix.length();
                    longestSuffixIdx = j;
                }
                if (prefix.length() > maxPrefixLength) {
                    maxPrefixLength = prefix.length();
                    longestPrefixIdx = j;
                }

                prefixes.add(prefix);
                suffixes.add(suffix);
            }

            boolean isPossible = true;

            for (int j = 0; j < n && isPossible; j++) {
                for (int i = j + 1; i < n && isPossible; i++) {
                    if (!suffixes.get(i).endsWith(suffixes.get(j)) && !suffixes.get(j).endsWith(suffixes.get(i))) {
                        isPossible = false;
                    }
                    if (!prefixes.get(i).startsWith(prefixes.get(j)) && !prefixes.get(j).startsWith(prefixes.get(i))) {
                        isPossible = false;
                    }
                }
            }

            if (!isPossible) {
                System.out.println("Case #" + t + ": *");
            } else {
                System.out.println("Case #" + t + ": " + prefixes.get(longestPrefixIdx) + suffixes.get(longestSuffixIdx));
            }
        }
    }

    public static int sum(int x, int y) {
        return x + y;
    }
}