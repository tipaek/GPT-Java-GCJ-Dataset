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

    public static String docat(String f, String s) {
        if (!f.contains(s.substring(0, 1))) {
            return f + s;
        }
        int idx = s.length();
        try {
            while (!f.endsWith(s.substring(0, idx--))) ;
        } catch (Exception e) {
            // Ignored
        }
        return f + s.substring(idx + 1);
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = sc.nextInt();
            String[] a = new String[n];
            String[] b = new String[n];
            String[] s1 = new String[n];
            boolean hasNonEmptyPrefix = false;

            for (int i = 0; i < n; i++) {
                s1[i] = sc.next();
                int firstStarIndex = s1[i].indexOf('*');
                int lastStarIndex = s1[i].lastIndexOf('*');

                if (firstStarIndex == 0) {
                    a[i] = "";
                    b[i] = (lastStarIndex == s1[i].length() - 1) ? "" : s1[i].substring(lastStarIndex + 1);
                } else {
                    a[i] = s1[i].substring(0, firstStarIndex);
                    b[i] = (lastStarIndex == s1[i].length() - 1) ? "" : s1[i].substring(lastStarIndex + 1);
                    hasNonEmptyPrefix = true;
                }
            }

            sort(a, n);
            sort(b, n);

            if (!hasNonEmptyPrefix) {
                boolean isValid = true;
                for (int i = 0; i < n - 1 && isValid; i++) {
                    for (int j = 0; j < b[i].length(); j++) {
                        if (b[i].charAt(b[i].length() - 1 - j) != b[n - 1].charAt(b[n - 1].length() - 1 - j)) {
                            isValid = false;
                            break;
                        }
                    }
                }
                System.out.println("Case #" + caseNumber + ": " + (isValid ? b[n - 1] : "*"));
                caseNumber++;
                continue;
            }

            boolean isValid = true;
            for (int i = 0; i < n - 1 && isValid; i++) {
                for (int j = 0; j < a[i].length(); j++) {
                    if (a[i].charAt(j) != a[n - 1].charAt(j)) {
                        isValid = false;
                        break;
                    }
                }
            }

            for (int i = 0; i < n - 1 && isValid; i++) {
                for (int j = 0; j < b[i].length(); j++) {
                    if (b[i].charAt(b[i].length() - 1 - j) != b[n - 1].charAt(b[n - 1].length() - 1 - j)) {
                        isValid = false;
                        break;
                    }
                }
            }

            if (!isValid) {
                System.out.println("Case #" + caseNumber + ": *");
            } else {
                StringBuilder ans = new StringBuilder(a[n - 1]);
                for (String s : s1) {
                    if (s.charAt(0) == '*') {
                        String[] parts = s.substring(1).split("\\*");
                        for (int j = 0; j < parts.length - 1; j++) {
                            ans.append(parts[j]);
                        }
                    } else {
                        String[] parts = s.split("\\*");
                        for (int j = 1; j < parts.length - 1; j++) {
                            ans.append(parts[j]);
                        }
                    }
                }
                ans.append(b[n - 1]);
                System.out.println("Case #" + caseNumber + ": " + (ans.length() <= 10000 ? ans.toString() : "*"));
            }
            caseNumber++;
        }
    }
}