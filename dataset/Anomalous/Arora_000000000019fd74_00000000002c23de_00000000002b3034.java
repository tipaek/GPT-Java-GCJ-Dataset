import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner(System.in);
        int t = sc.nextInt();
        for (int p1 = 0; p1 < t; p1++) {
            int n = sc.nextInt();
            String[] a = new String[n];
            int[] len = new int[n];
            boolean hasNonAsterisk = false;
            int maxLength = 0;
            String maxString = "";

            for (int i = 0; i < n; i++) {
                a[i] = sc.next();
                len[i] = a[i].length();
                if (a[i].charAt(0) != '*') {
                    hasNonAsterisk = true;
                }
                if (maxLength < len[i]) {
                    maxLength = len[i];
                    maxString = a[i];
                }
            }

            if (!hasNonAsterisk) {
                String result = handleCase1(a, maxString, n);
                System.out.println("Case #" + (p1 + 1) + ": " + result);
            } else {
                boolean isInvalid = false;
                String combined = a[0];
                for (int i = 1; i < n; i++) {
                    combined = handleCase2(combined, a[i]);
                    if (combined.equals("-1")) {
                        isInvalid = true;
                        break;
                    }
                }

                String result = "";
                for (char c : combined.toCharArray()) {
                    if (c != '*') {
                        result += c;
                    }
                }

                if (isInvalid) {
                    System.out.println("Case #" + (p1 + 1) + ": *");
                } else {
                    System.out.println("Case #" + (p1 + 1) + ": " + result);
                }
            }
        }
    }

    static String handleCase1(String[] a, String maxString, int n) {
        for (String s : a) {
            int index = maxString.indexOf(s.substring(1));
            if (index == -1) {
                return "*";
            }
        }
        return maxString.substring(1);
    }

    static String handleCase2(String p, String s) {
        int x = p.indexOf("*");
        int y = s.indexOf("*");
        int k1 = 0, k2 = 0;

        while (k1 < x && k2 < y) {
            if (p.charAt(k1) != s.charAt(k2)) {
                return "-1";
            }
            k1++;
            k2++;
        }

        k1 = p.length() - 1;
        k2 = s.length() - 1;
        while (k1 > x && k2 > y) {
            if (p.charAt(k1) != s.charAt(k2)) {
                return "-1";
            }
            k1--;
            k2--;
        }

        String p1 = p.substring(0, x);
        String p2 = p.substring(x + 1);
        String s1 = s.substring(0, y);
        String s2 = s.substring(y + 1);
        StringBuilder result = new StringBuilder();

        result.append(p1.length() >= s1.length() ? p1 : s1).append("*");
        result.append(p2.length() >= s2.length() ? p2 : s2);

        return result.toString();
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                return "";
            }
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}