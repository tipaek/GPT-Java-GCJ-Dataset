import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int n = scanner.nextInt();
            String[] patterns = new String[n];
            String[] prefixes = new String[n];
            String[] suffixes = new String[n];
            boolean hasPrefix = false;

            for (int i = 0; i < n; i++) {
                patterns[i] = scanner.next();
                int firstStar = patterns[i].indexOf('*');
                int lastStar = patterns[i].lastIndexOf('*');

                prefixes[i] = firstStar == 0 ? "" : patterns[i].substring(0, firstStar);
                suffixes[i] = lastStar == patterns[i].length() - 1 ? "" : patterns[i].substring(lastStar + 1);

                if (!prefixes[i].isEmpty()) {
                    hasPrefix = true;
                }
            }

            sort(prefixes, n);
            sort(suffixes, n);

            if (!hasPrefix) {
                if (isValidSuffix(suffixes, n)) {
                    System.out.println("Case #" + caseNumber + ": " + suffixes[n - 1]);
                } else {
                    System.out.println("Case #" + caseNumber + ": *");
                }
                caseNumber++;
                continue;
            }

            if (!isValidPrefix(prefixes, n) || !isValidSuffix(suffixes, n)) {
                System.out.println("Case #" + caseNumber + ": *");
            } else {
                String result = buildResult(prefixes, suffixes, patterns, n);
                if (result.length() <= 10000) {
                    System.out.println("Case #" + caseNumber + ": " + result);
                } else {
                    System.out.println("Case #" + caseNumber + ": *");
                }
            }

            caseNumber++;
        }

        scanner.close();
    }

    private static void sort(String[] array, int n) {
        for (int i = 1; i < n; i++) {
            String temp = array[i];
            int j = i - 1;
            while (j >= 0 && temp.length() < array[j].length()) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
    }

    private static boolean isValidPrefix(String[] prefixes, int n) {
        for (int i = 0; i < n - 1; i++) {
            if (!prefixes[n - 1].startsWith(prefixes[i]) && !prefixes[i].isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidSuffix(String[] suffixes, int n) {
        for (int i = 0; i < n - 1; i++) {
            if (!suffixes[n - 1].endsWith(suffixes[i]) && !suffixes[i].isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private static String buildResult(String[] prefixes, String[] suffixes, String[] patterns, int n) {
        String result = prefixes[n - 1];

        for (String pattern : patterns) {
            if (pattern.charAt(0) == '*') {
                String[] parts = pattern.substring(1).split("\\*");
                for (String part : parts) {
                    if (!result.endsWith(part) && !part.isEmpty()) {
                        result += part;
                    }
                }
            } else {
                String[] parts = pattern.split("\\*");
                for (int j = 1; j < parts.length - 1; j++) {
                    if (!result.endsWith(parts[j]) && !parts[j].isEmpty()) {
                        result += parts[j];
                    }
                }
            }
        }

        if (!result.endsWith(suffixes[n - 1]) && !suffixes[n - 1].isEmpty()) {
            result += suffixes[n - 1];
        }

        return result;
    }
}