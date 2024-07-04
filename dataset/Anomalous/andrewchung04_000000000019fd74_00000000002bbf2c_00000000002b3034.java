import java.util.Scanner;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            String[] patterns = new String[n];
            String prefix = "";
            String suffix = "";

            for (int j = 0; j < n; j++) {
                patterns[j] = scanner.next();
            }
            Arrays.sort(patterns);
            boolean conflict = false;

            outerLoop: for (String pattern : patterns) {
                String currentPrefix = "";
                String currentSuffix = "";
                for (int k = 0; k < pattern.length(); k++) {
                    if (pattern.charAt(k) == '*') {
                        currentPrefix = pattern.substring(0, k);
                        currentSuffix = pattern.substring(k + 1);
                        break;
                    }
                }

                if (!isPrefixCompatible(prefix, currentPrefix) || !isSuffixCompatible(suffix, currentSuffix)) {
                    System.out.println("Case #" + (i + 1) + ": *");
                    conflict = true;
                    break outerLoop;
                }

                if (currentPrefix.length() > prefix.length()) {
                    prefix = currentPrefix;
                }
                if (currentSuffix.length() > suffix.length()) {
                    suffix = currentSuffix;
                }
            }

            if (!conflict) {
                int overlap = calculateOverlap(prefix, suffix);
                System.out.println("Case #" + (i + 1) + ": " + prefix + suffix.substring(overlap));
            }
        }
    }

    private static boolean isPrefixCompatible(String prefix, String currentPrefix) {
        for (int k = 0; k < Math.min(prefix.length(), currentPrefix.length()); k++) {
            if (prefix.charAt(k) != currentPrefix.charAt(k)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isSuffixCompatible(String suffix, String currentSuffix) {
        for (int k = 0; k < Math.min(suffix.length(), currentSuffix.length()); k++) {
            if (suffix.charAt(suffix.length() - k - 1) != currentSuffix.charAt(currentSuffix.length() - k - 1)) {
                return false;
            }
        }
        return true;
    }

    private static int calculateOverlap(String prefix, String suffix) {
        int overlap = 0;
        for (int j = 0; j < Math.min(prefix.length(), suffix.length()); j++) {
            if (prefix.charAt(prefix.length() - j - 1) == suffix.charAt(j)) {
                overlap++;
            } else {
                break;
            }
        }
        return overlap;
    }
}