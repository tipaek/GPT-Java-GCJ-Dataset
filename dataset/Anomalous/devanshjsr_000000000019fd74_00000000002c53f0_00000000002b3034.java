import java.util.Scanner;

public class Solution {

    static void sortStringsByLength(String[] strings, int length) {
        for (int i = 1; i < length; i++) {
            String temp = strings[i];
            int j = i - 1;
            while (j >= 0 && temp.length() < strings[j].length()) {
                strings[j + 1] = strings[j];
                j--;
            }
            strings[j + 1] = temp;
        }
    }

    public static String concatenateWithOverlap(String first, String second) {
        if (!first.contains(second.substring(0, 1))) {
            return first + second;
        }
        int idx = second.length();
        try {
            while (!first.endsWith(second.substring(0, idx--))) ;
        } catch (Exception ignored) {
        }
        return first + second.substring(idx + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 1;

        while (testCases > 0) {
            int n = scanner.nextInt();
            String[] patterns = new String[n];
            String[] prefixes = new String[n];
            String[] suffixes = new String[n];
            boolean hasPrefix = false;

            for (int i = 0; i < n; i++) {
                patterns[i] = scanner.next();
                int firstAsterisk = patterns[i].indexOf('*');
                int lastAsterisk = patterns[i].lastIndexOf('*');

                if (firstAsterisk == 0) {
                    prefixes[i] = "";
                    suffixes[i] = (lastAsterisk == patterns[i].length() - 1) ? "" : patterns[i].substring(lastAsterisk + 1);
                } else {
                    prefixes[i] = patterns[i].substring(0, firstAsterisk);
                    suffixes[i] = (lastAsterisk == patterns[i].length() - 1) ? "" : patterns[i].substring(lastAsterisk + 1);
                    hasPrefix = true;
                }
            }

            sortStringsByLength(prefixes, n);
            sortStringsByLength(suffixes, n);

            if (!hasPrefix) {
                boolean isValid = true;
                for (int i = 0; i < n - 1; i++) {
                    for (int j = 0; j < suffixes[i].length(); j++) {
                        if (suffixes[i].charAt(suffixes[i].length() - 1 - j) != suffixes[n - 1].charAt(suffixes[n - 1].length() - 1 - j)) {
                            isValid = false;
                            break;
                        }
                    }
                }
                if (isValid) {
                    System.out.println("Case #" + caseNumber + ": " + suffixes[n - 1]);
                } else {
                    System.out.println("Case #" + caseNumber + ": *");
                }
                testCases--;
                caseNumber++;
                continue;
            }

            boolean isValid = true;

            for (int i = 0; i < n - 1; i++) {
                if (!prefixes[n - 1].startsWith(prefixes[i]) && !prefixes[i].isEmpty()) {
                    isValid = false;
                    break;
                }
            }

            for (int i = 0; i < n - 1; i++) {
                if (!suffixes[n - 1].endsWith(suffixes[i]) && !suffixes[i].isEmpty()) {
                    isValid = false;
                    break;
                }
            }

            if (!isValid) {
                System.out.println("Case #" + caseNumber + ": *");
            } else {
                String result = prefixes[n - 1];

                for (String pattern : patterns) {
                    if (pattern.charAt(0) == '*') {
                        String[] segments = pattern.substring(1).split("\\*");
                        for (String segment : segments) {
                            if (!result.endsWith(segment) && !segment.isEmpty()) {
                                result += segment;
                            }
                        }
                    } else {
                        String[] segments = pattern.split("\\*");
                        for (int j = 1; j < segments.length; j++) {
                            if (!result.endsWith(segments[j]) && !segments[j].isEmpty()) {
                                result += segments[j];
                            }
                        }
                    }
                }

                if (!result.endsWith(suffixes[n - 1]) && !suffixes[n - 1].isEmpty()) {
                    result += suffixes[n - 1];
                }

                if (result.length() <= 10000) {
                    System.out.println("Case #" + caseNumber + ": " + result);
                } else {
                    System.out.println("Case #" + caseNumber + ": *");
                }
            }

            caseNumber++;
            testCases--;
        }
    }
}