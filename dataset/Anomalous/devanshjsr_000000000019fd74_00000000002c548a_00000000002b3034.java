import java.util.Scanner;

public class Solution {

    static void sortStringsByLength(String[] s, int n) {
        for (int i = 1; i < n; i++) {
            String temp = s[i];
            int j = i - 1;
            while (j >= 0 && temp.length() < s[j].length()) {
                s[j + 1] = s[j];
                j--;
            }
            s[j + 1] = temp;
        }
    }

    public static String concatenateWithOverlap(String first, String second) {
        if (!first.contains(second.substring(0, 1))) {
            return first + second;
        }
        int idx = second.length();
        try {
            while (!first.endsWith(second.substring(0, idx--)));
        } catch (Exception e) {
            // Ignore exception
        }
        return first + second.substring(idx + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int caseNumber = 1;

        while (t > 0) {
            int n = sc.nextInt();
            String[] a = new String[n];
            String[] b = new String[n];
            String[] patterns = new String[n];

            boolean hasNonEmptyPrefix = false;

            for (int i = 0; i < n; i++) {
                patterns[i] = sc.next();
                int firstStarIndex = patterns[i].indexOf('*');
                int lastStarIndex = patterns[i].lastIndexOf('*');

                if (firstStarIndex == 0) {
                    a[i] = "";
                    b[i] = (lastStarIndex == patterns[i].length() - 1) ? "" : patterns[i].substring(lastStarIndex + 1);
                } else {
                    a[i] = patterns[i].substring(0, firstStarIndex);
                    b[i] = (lastStarIndex == patterns[i].length() - 1) ? "" : patterns[i].substring(lastStarIndex + 1);
                    hasNonEmptyPrefix = true;
                }
            }

            sortStringsByLength(a, n);
            sortStringsByLength(b, n);

            if (!hasNonEmptyPrefix) {
                boolean isValid = true;
                for (int i = 0; i < n - 1; i++) {
                    for (int j = 0; j < b[i].length(); j++) {
                        if (b[i].charAt(b[i].length() - 1 - j) != b[n - 1].charAt(b[n - 1].length() - 1 - j)) {
                            isValid = false;
                            break;
                        }
                    }
                    if (!isValid) break;
                }

                if (!isValid) {
                    System.out.println("Case #" + caseNumber + ": *");
                } else {
                    System.out.println("Case #" + caseNumber + ": " + b[n - 1]);
                }

                t--;
                caseNumber++;
                continue;
            }

            boolean isValid = true;

            for (int i = 0; i < n - 1; i++) {
                if (!a[n - 1].startsWith(a[i]) && !a[i].isEmpty()) {
                    isValid = false;
                    break;
                }
            }

            for (int i = 0; i < n - 1; i++) {
                if (!b[n - 1].endsWith(b[i]) && !b[i].isEmpty()) {
                    isValid = false;
                    break;
                }
            }

            if (!isValid) {
                System.out.println("Case #" + caseNumber + ": *");
            } else {
                String result = a[n - 1];

                for (int i = 0; i < n; i++) {
                    if (patterns[i].charAt(0) == '*') {
                        String[] segments = patterns[i].substring(1).split("\\*");
                        for (String segment : segments) {
                            if (!result.endsWith(segment) && !segment.isEmpty()) {
                                result += segment;
                            }
                        }
                    } else {
                        String[] segments = patterns[i].split("\\*");
                        for (int j = 1; j < segments.length; j++) {
                            if (!result.endsWith(segments[j]) && !segments[j].isEmpty()) {
                                result += segments[j];
                            }
                        }
                    }
                }

                if (!result.endsWith(b[n - 1]) && !b[n - 1].isEmpty()) {
                    result += b[n - 1];
                }

                if (result.length() <= 10000) {
                    System.out.println("Case #" + caseNumber + ": " + result);
                } else {
                    System.out.println("Case #" + caseNumber + ": *");
                }
            }

            caseNumber++;
            t--;
        }

        sc.close();
    }
}