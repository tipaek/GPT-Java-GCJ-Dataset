import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume newline left-over
        for (int caseNumber = 1; caseNumber <= t; caseNumber++) {
            int n = sc.nextInt();
            sc.nextLine(); // Consume newline left-over
            String[] patterns = new String[n];
            for (int i = 0; i < n; i++) {
                patterns[i] = sc.nextLine();
            }

            String prefix = getPrefix(patterns);
            String suffix = getSuffix(patterns);

            if (prefix == null || suffix == null) {
                System.out.println("Case #" + caseNumber + ": *");
            } else {
                String middle = getMiddle(patterns);
                System.out.println("Case #" + caseNumber + ": " + prefix + middle + suffix);
            }
        }
        sc.close();
    }

    private static String getPrefix(String[] patterns) {
        String prefix = patterns[0].split("\\*")[0];
        for (String pattern : patterns) {
            String currentPrefix = pattern.split("\\*")[0];
            if (!prefix.startsWith(currentPrefix) && !currentPrefix.startsWith(prefix)) {
                return null;
            }
            if (currentPrefix.length() > prefix.length()) {
                prefix = currentPrefix;
            }
        }
        return prefix;
    }

    private static String getSuffix(String[] patterns) {
        String suffix = patterns[0].substring(patterns[0].lastIndexOf('*') + 1);
        for (String pattern : patterns) {
            String currentSuffix = pattern.substring(pattern.lastIndexOf('*') + 1);
            if (!suffix.endsWith(currentSuffix) && !currentSuffix.endsWith(suffix)) {
                return null;
            }
            if (currentSuffix.length() > suffix.length()) {
                suffix = currentSuffix;
            }
        }
        return suffix;
    }

    private static String getMiddle(String[] patterns) {
        StringBuilder middle = new StringBuilder();
        for (String pattern : patterns) {
            int firstStar = pattern.indexOf('*');
            int lastStar = pattern.lastIndexOf('*');
            for (int j = firstStar + 1; j < lastStar; j++) {
                if (pattern.charAt(j) != '*') {
                    middle.append(pattern.charAt(j));
                }
            }
        }
        return middle.toString();
    }
}