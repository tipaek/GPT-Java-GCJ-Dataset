import java.util.*;

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

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int caseNumber = 1;

        while (t > 0) {
            int n = sc.nextInt();
            String[] prefixes = new String[n];
            String[] suffixes = new String[n];

            boolean hasMiddlePart = false;

            for (int i = 0; i < n; i++) {
                String s = sc.next();

                if (s.charAt(0) == '*') {
                    prefixes[i] = "";
                    suffixes[i] = s.substring(1);
                } else if (s.charAt(s.length() - 1) == '*') {
                    prefixes[i] = s.substring(0, s.length() - 1);
                    suffixes[i] = "";
                } else {
                    String[] parts = s.split("\\*");
                    prefixes[i] = parts[0];
                    suffixes[i] = parts[1];
                    hasMiddlePart = true;
                }
            }

            sortStringsByLength(prefixes, n);
            sortStringsByLength(suffixes, n);

            if (!hasMiddlePart) {
                boolean isValid = true;
                for (int i = 0; i < n - 1; i++) {
                    for (int j = 0; j < suffixes[i].length(); j++) {
                        if (suffixes[i].charAt(suffixes[i].length() - 1 - j) != suffixes[n - 1].charAt(suffixes[n - 1].length() - 1 - j)) {
                            isValid = false;
                            break;
                        }
                    }
                    if (!isValid) break;
                }

                if (isValid) {
                    System.out.println("Case #" + caseNumber + ": " + suffixes[n - 1]);
                } else {
                    System.out.println("Case #" + caseNumber + ": *");
                }

                caseNumber++;
                t--;
                continue;
            }

            boolean isValid = true;

            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < prefixes[i].length(); j++) {
                    if (prefixes[i].charAt(j) != prefixes[n - 1].charAt(j)) {
                        isValid = false;
                        break;
                    }
                }
                if (!isValid) break;
            }

            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < suffixes[i].length(); j++) {
                    if (suffixes[i].charAt(suffixes[i].length() - 1 - j) != suffixes[n - 1].charAt(suffixes[n - 1].length() - 1 - j)) {
                        isValid = false;
                        break;
                    }
                }
                if (!isValid) break;
            }

            if (isValid) {
                String result = prefixes[n - 1] + suffixes[n - 1];
                System.out.println("Case #" + caseNumber + ": " + result);
            } else {
                System.out.println("Case #" + caseNumber + ": *");
            }

            caseNumber++;
            t--;
        }
    }
}