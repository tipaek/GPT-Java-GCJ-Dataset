import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int m = 1; m <= t; ++m) {
            int n = in.nextInt();
            String[] arr = new String[n];
            for (int k = 0; k < n; k++) {
                arr[k] = in.next();
            }

            String s = arr[0];
            boolean fail = false;
            for (int i = 1; i < arr.length; i++) {
                String curr = arr[i];
                StringBuilder str = new StringBuilder();
                if (!merge(s, curr, 0, 0, str)) {
                    System.out.println(String.format("Case #%d: %s", m, "*"));
                    fail = true;
                    break;
                }
                s = str.toString();
            }

            if (!fail) {
                StringBuilder b = new StringBuilder();
                for (char c : s.toCharArray()) {
                    b.append(c == '*' ? 'A' : c);
                }

                System.out.println(String.format("Case #%d: %s", m, b.toString()));
            }
        }
    }

    private static boolean merge(String s1, String s2, int i, int j, StringBuilder str) {
        if (i >= s1.length() || j >= s2.length()) {
            return false;
        }

        char c = s1.charAt(i);
        char c2 = s2.charAt(j);

        if (c != '*' && c2 != '*') {
            if (c != c2) {
                return false;
            }

            if (merge(s1, s2, i + 1, j + 1, str)) {
                str.insert(0, c);
                return true;
            } else {
                return false;
            }
        }

        if (c == '*' && c2 != '*') {
            if (merge(s1, s2, i, j + 1, str)) {
                str.insert(0, c2);
                return true;
            } else {
                return false;
            }
        }

        if (c != '*') {
            if (merge(s1, s2, i + 1, j, str)) {
                str.insert(0, c);
                return true;
            } else {
                return false;
            }
        }

        if (merge(s1, s2, i + 1, j, str)) {
            str.insert(0, c);
            return true;
        }

        if (merge(s1, s2, i, j + 1, str)) {
            str.insert(0, c2);
            return true;
        }

        if (merge(s1, s2, i + 1, j + 1, str)) {
            str.insert(0, c);
            return true;
        }

        return false;
    }

}