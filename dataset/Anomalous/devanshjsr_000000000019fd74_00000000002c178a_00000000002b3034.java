import java.util.Scanner;

public class Solution {

    static void sort(String[] s, int n) {
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

    public static String concatenate(String first, String second) {
        if (!first.contains(second.substring(0, 1)))
            return first + second;
        int idx = second.length();
        try {
            while (!first.endsWith(second.substring(0, idx--))) ;
        } catch (Exception ignored) {
        }
        return first + second.substring(idx + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = sc.nextInt();
            String[] a = new String[n];
            String[] b = new String[n];
            String[] s1 = new String[n];
            boolean hasPrefix = false;

            for (int i = 0; i < n; i++) {
                s1[i] = sc.next();
                int firstStar = s1[i].indexOf('*');
                int lastStar = s1[i].lastIndexOf('*');

                if (firstStar == 0) {
                    a[i] = "";
                    b[i] = (lastStar == s1[i].length() - 1) ? "" : s1[i].substring(lastStar + 1);
                } else {
                    a[i] = s1[i].substring(0, firstStar);
                    b[i] = (lastStar == s1[i].length() - 1) ? "" : s1[i].substring(lastStar + 1);
                    hasPrefix = true;
                }
            }

            sort(a, n);
            sort(b, n);

            if (!hasPrefix) {
                boolean match = true;
                for (int i = 0; i < n - 1; i++) {
                    for (int j = 0; j < b[i].length(); j++) {
                        if (b[i].charAt(b[i].length() - 1 - j) != b[n - 1].charAt(b[n - 1].length() - 1 - j)) {
                            match = false;
                            break;
                        }
                    }
                    if (!match) break;
                }
                System.out.println("Case #" + caseNumber++ + ": " + (match ? b[n - 1] : "*"));
                continue;
            }

            boolean isValid = true;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < a[i].length(); j++) {
                    if (a[i].charAt(j) != a[n - 1].charAt(j)) {
                        isValid = false;
                        break;
                    }
                }
                if (!isValid) break;
            }

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
                System.out.println("Case #" + caseNumber++ + ": *");
            } else {
                StringBuilder result = new StringBuilder(a[n - 1]);

                for (String str : s1) {
                    if (str.charAt(0) == '*') {
                        String[] parts = str.substring(1, str.length() - (str.charAt(str.length() - 1) == '*' ? 1 : 0)).split("\\*");
                        for (String part : parts) {
                            result.append(part);
                        }
                    } else {
                        String[] parts = str.substring(0, str.length() - (str.charAt(str.length() - 1) == '*' ? 1 : 0)).split("\\*");
                        for (int j = 1; j < parts.length; j++) {
                            result.append(parts[j]);
                        }
                    }
                }

                result.append(b[n - 1]);
                System.out.println("Case #" + caseNumber++ + ": " + result);
            }
        }
    }
}