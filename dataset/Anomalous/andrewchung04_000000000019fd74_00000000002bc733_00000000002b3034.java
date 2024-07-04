import java.util.Scanner;

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

            boolean isMismatch = false;

            outerLoop: for (int j = 0; j < n; j++) {
                String currentPrefix = "";
                String currentSuffix = "";
                String pattern = patterns[j];

                int starIndex = pattern.indexOf('*');
                if (starIndex != -1) {
                    currentPrefix = pattern.substring(0, starIndex);
                    currentSuffix = pattern.substring(starIndex + 1);
                }

                if (!prefix.startsWith(currentPrefix) && !currentPrefix.startsWith(prefix)) {
                    System.out.println("Case #" + (i + 1) + ": *");
                    isMismatch = true;
                    break outerLoop;
                }

                if (!suffix.endsWith(currentSuffix) && !currentSuffix.endsWith(suffix)) {
                    System.out.println("Case #" + (i + 1) + ": *");
                    isMismatch = true;
                    break outerLoop;
                }

                if (currentPrefix.length() > prefix.length()) {
                    prefix = currentPrefix;
                }
                if (currentSuffix.length() > suffix.length()) {
                    suffix = currentSuffix;
                }
            }

            if (!isMismatch) {
                int overlap = 0;
                for (int j = 0; j < Math.min(prefix.length(), suffix.length()); j++) {
                    if (prefix.charAt(prefix.length() - j - 1) == suffix.charAt(j)) {
                        overlap++;
                    } else {
                        break;
                    }
                }

                if (prefix.isEmpty() && suffix.isEmpty()) {
                    System.out.println("Case #" + (i + 1) + ": A");
                } else {
                    System.out.println("Case #" + (i + 1) + ": " + prefix + suffix.substring(overlap));
                }
            }
        }
    }
}