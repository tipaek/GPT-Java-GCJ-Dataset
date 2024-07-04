import java.io.*;
import java.util.*;

public class Solution {
    static class Pair implements Comparable<Pair> {
        int a, b;

        public Pair(int x, int y) {
            a = x;
            b = y;
        }

        public Pair() {}

        @Override
        public int compareTo(Pair p1) {
            if (a == p1.a) {
                return b - p1.b;
            }
            return a - p1.a;
        }
    }

    static class Quad implements Comparable<Quad> {
        int si, ei, li, time;

        public Quad(int a, int b, int c, int d) {
            si = a;
            ei = b;
            li = c;
            time = d;
        }

        @Override
        public int compareTo(Quad q) {
            double v1 = ei - li * time;
            double v2 = q.ei - q.li * q.time;
            if (v1 == v2) {
                return si - q.si;
            }
            return Double.compare(v2, v1);
        }
    }

    static class TrieNode {
        TrieNode[] child;
        int w, len;
        boolean term;

        TrieNode() {
            child = new TrieNode[26];
        }
    }

    public static int gcd(int a, int b) {
        if (a < b) {
            return gcd(b, a);
        }
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    static long mod = (long) (1e9 + 7);

    public static void main(String[] args) throws Exception {
        new Thread(null, new Runnable() {
            @Override
            public void run() {
                try {
                    solve();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }, "Anshum Gupta", 99999999).start();
    }

    static long pow(long x, long y) {
        if (y == 0) return 1;
        if (y == 1) return x;
        long a = pow(x, y / 2);
        a = (a * a) % mod;
        if (y % 2 == 0) {
            return a;
        }
        return (a * x) % mod;
    }

    public static void solve() throws Exception {
        MyScanner s = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int t = s.nextInt();
        int tc = 0;

        while (tc++ < t) {
            out.print("Case #" + tc + ": ");

            int fl = 1;
            int x_pos = 1;
            int y_pos = 1;
            long x = s.nextLong();
            long y = s.nextLong();
            if (y < 0) y_pos = 0;
            if (x < 0) x_pos = 0;
            x = Math.abs(x);
            y = Math.abs(y);
            String ans = "";
            int cur = 0;

            if ((Math.abs(x) ^ Math.abs(y)) == 0) {
                out.println("IMPOSSIBLE");
                continue;
            } else {
                while (true) {
                    if (x == (1 << cur) && y == (1 << (cur + 1))) {
                        ans += "EN";
                        break;
                    }
                    if (y == (1 << cur) && x == (1 << (cur + 1))) {
                        ans += "NE";
                        break;
                    }
                    long xi = x & (1 << 0);
                    long yi = y & (1 << 0);
                    long yi_1 = y & (1 << 1);
                    long xi_1 = x & (1 << 1);
                    if ((xi ^ yi) == 0) {
                        if ((xi_1 ^ yi_1) == 0) {
                            fl = 0;
                            break;
                        }
                    }
                    if (xi > 0 && yi_1 > 0) {
                        ans += 'W';
                        x += (1 << 0);
                    } else if (yi > 0 && xi_1 > 0) {
                        ans += 'S';
                        y += (1 << 0);
                    } else if (xi > 0) {
                        ans += 'E';
                    } else if (yi > 0) {
                        ans += 'N';
                    }
                    x /= 2;
                    y /= 2;
                }
                if (fl == 0) {
                    out.println("IMPOSSIBLE");
                    continue;
                }
                StringBuilder new_ans = new StringBuilder();
                for (int i = 0; i < ans.length(); i++) {
                    char ch = ans.charAt(i);
                    if (ch == 'E' && x_pos == 0) ch = 'W';
                    else if (ch == 'W' && x_pos == 0) ch = 'E';
                    else if (ch == 'N' && y_pos == 0) ch = 'S';
                    else if (ch == 'S' && y_pos == 0) ch = 'N';
                    new_ans.append(ch);
                }
                out.println(new_ans.toString());
            }
        }
        out.flush();
    }

    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
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