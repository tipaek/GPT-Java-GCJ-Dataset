import java.util.*;
import java.io.*;

public class Solution {
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        new Thread(null, null, "Name", 99999999) {
            public void run() {
                try {
                    solve();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }.start();
    }

    static void solve() throws Exception {
        int t = ni();
        for (int o = 1; o <= t; o++) {
            char[] s = n().toCharArray();
            StringBuilder res = new StringBuilder();
            if (s[0] == '1') res.append("(");
            for (int i = 0; i < s.length; i++) {
                if (i == 0) {
                    res.append(s[i] == '1' ? '1' : '0');
                } else {
                    if (s[i] == '1') {
                        if (s[i - 1] == '1') res.append('1');
                        else res.append("(1");
                    } else {
                        if (s[i - 1] == '0') res.append('0');
                        else res.append(")0");
                    }
                }
            }
            if (s[s.length - 1] == '1') res.append(')');
            pn("Case #" + o + ": " + res);
        }
        out.flush();
    }

    static int[] ai(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = ni();
        return a;
    }

    static long[] al(int n) {
        long[] a = new long[n];
        for (int i = 0; i < n; i++) a[i] = nl();
        return a;
    }

    static void p(Object o) {
        out.print(o);
    }

    static void pn(Object o) {
        out.println(o);
    }

    static int abs(int x) {
        return x > 0 ? x : -x;
    }

    static long gcd(long a, long b) {
        return b % a == 0 ? a : gcd(b % a, a);
    }

    static int count_set(int n) {
        int c = 0;
        while (n > 0) {
            if (n % 2 == 1) c++;
            n /= 2;
        }
        return c;
    }

    static void subtract_1(char[] s) {
        if (s[0] == '0') return;
        int n = s.length, i = n - 1;
        while (s[i] == '0') i--;
        s[i] = (char) (s[i] - 1);
        for (int j = i + 1; j < n; j++) s[j] = '9';
    }

    static long pow(long a, long b, long md) {
        long ans = 1;
        while (b > 0) {
            if (b % 2 == 1) ans = (ans * a) % md;
            a = (a * a) % md;
            b /= 2;
        }
        return ans;
    }

    static long min(long a, long b) {
        return Math.min(a, b);
    }

    static long max(long a, long b) {
        return Math.max(a, b);
    }

    static boolean pal(String s) {
        int n = s.length(), i1 = 0, i2 = n - 1;
        while (i1 < i2) {
            if (s.charAt(i1) != s.charAt(i2)) return false;
            i1++;
            i2--;
        }
        return true;
    }

    static String rev(String r) {
        return new StringBuilder(r).reverse().toString();
    }

    static FastReader sc = new FastReader();

    static int ni() {
        return sc.nextInt();
    }

    static long nl() {
        return sc.nextLong();
    }

    static String n() {
        return sc.next();
    }

    static String ns() {
        return sc.nextLine();
    }

    static double nd() {
        return sc.nextDouble();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}