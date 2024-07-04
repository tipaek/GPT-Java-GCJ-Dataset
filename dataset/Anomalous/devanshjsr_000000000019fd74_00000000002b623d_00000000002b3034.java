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
            // Exception handling can be improved if needed
        }
        return f + s.substring(idx + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int st = 1;

        while (t > 0) {
            int n = sc.nextInt();
            String[] a = new String[n];
            String[] b = new String[n];
            int k = 0;

            for (int i = 0; i < n; i++) {
                String s = sc.next();

                if (s.charAt(0) == '*') {
                    a[i] = "";
                    b[i] = s.substring(1);
                } else {
                    String[] sa = s.split("\\*");
                    a[i] = sa[0];
                    b[i] = sa.length > 1 ? sa[1] : "";
                    k = 1;
                }
            }

            sort(a, n);
            sort(b, n);

            if (k == 0) {
                boolean valid = true;
                for (int i = 0; i < n - 1; i++) {
                    if (!b[n - 1].contains(b[i])) {
                        valid = false;
                        break;
                    }
                }

                if (valid) {
                    System.out.println("Case #" + st + ": " + b[n - 1]);
                } else {
                    System.out.println("Case #" + st + ": *");
                }
            } else {
                boolean valid = true;

                for (int i = 0; i < n - 1; i++) {
                    if (!a[n - 1].contains(a[i]) || !b[n - 1].contains(b[i])) {
                        valid = false;
                        break;
                    }
                }

                if (valid) {
                    System.out.println("Case #" + st + ": " + docat(a[n - 1], b[n - 1]));
                } else {
                    System.out.println("Case #" + st + ": *");
                }
            }

            st++;
            t--;
        }
        sc.close();
    }
}