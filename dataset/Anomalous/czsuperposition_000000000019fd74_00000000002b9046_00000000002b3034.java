import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            String[] left = new String[N];
            String[] right = new String[N];

            for (int j = 0; j < N; j++) {
                String str = scanner.next();
                int asteriskIndex = str.indexOf('*');
                left[j] = (asteriskIndex == 0) ? "" : str.substring(0, asteriskIndex);
                right[j] = (asteriskIndex == str.length() - 1) ? "" : str.substring(asteriskIndex + 1);
            }

            String longestLeft = findLongestPrefix(left);
            String longestRight = findLongestSuffix(right);

            if (isValidPrefix(left, longestLeft) && isValidSuffix(right, longestRight)) {
                System.out.println("Case #" + (i + 1) + ": " + longestLeft + longestRight);
            } else {
                System.out.println("Case #" + (i + 1) + ": *");
            }
        }
    }

    private static String findLongestPrefix(String[] prefixes) {
        String longestPrefix = "";
        for (String prefix : prefixes) {
            if (prefix.length() > longestPrefix.length()) {
                longestPrefix = prefix;
            }
        }
        return longestPrefix;
    }

    private static String findLongestSuffix(String[] suffixes) {
        String longestSuffix = "";
        for (String suffix : suffixes) {
            if (suffix.length() > longestSuffix.length()) {
                longestSuffix = suffix;
            }
        }
        return longestSuffix;
    }

    private static boolean isValidPrefix(String[] prefixes, String longestPrefix) {
        for (String prefix : prefixes) {
            if (!longestPrefix.startsWith(prefix)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidSuffix(String[] suffixes, String longestSuffix) {
        for (String suffix : suffixes) {
            if (!longestSuffix.endsWith(suffix)) {
                return false;
            }
        }
        return true;
    }
}