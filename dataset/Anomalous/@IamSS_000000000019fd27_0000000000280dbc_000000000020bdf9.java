import java.util.*;
import java.io.*;

public class Solution {
    static PrintWriter out = new PrintWriter(System.out);
    static boolean flag = true;

    static void dfs(List<Integer>[] graph, int node, int[] colors) {
        for (Integer neighbor : graph[node]) {
            if (colors[neighbor] == -1) {
                colors[neighbor] = 1 - colors[node];
                dfs(graph, neighbor, colors);
            } else if (colors[neighbor] == colors[node]) {
                flag = false;
                return;
            }
        }
    }

    static boolean testOverlap(int x1, int x2, int y1, int y2) {
        return (x1 >= y1 && x1 <= y2) ||
               (x2 >= y1 && x2 <= y2) ||
               (y1 >= x1 && y1 <= x2) ||
               (y2 >= x1 && y2 <= x2);
    }

    static void solve() throws Exception {
        int t = ni();
        for (int o = 1; o <= t; o++) {
            int n = ni();
            int[] start = new int[n];
            int[] end = new int[n];
            for (int i = 0; i < n; i++) {
                start[i] = ni() + 1;
                end[i] = ni();
            }
            List<Integer>[] graph = new LinkedList[n];
            int[] colors = new int[n];
            Arrays.fill(colors, -1);

            for (int i = 0; i < n; i++) {
                graph[i] = new LinkedList<>();
            }

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (testOverlap(start[i], end[i], start[j], end[j])) {
                        graph[i].add(j);
                        graph[j].add(i);
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                if (colors[i] == -1) {
                    colors[i] = 1;
                    dfs(graph, i, colors);
                    if (!flag) break;
                }
            }

            if (!flag) {
                pn("Case #" + o + ": IMPOSSIBLE");
            } else {
                StringBuilder res = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    res.append(colors[i] == 1 ? 'J' : 'C');
                }
                pn("Case #" + o + ": " + res);
            }
            flag = true;
        }
        out.flush();
    }

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

    static int[] ai(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = ni();
        }
        return a;
    }

    static long[] al(int n) {
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = nl();
        }
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
        if (b % a == 0) return a;
        return gcd(b % a, a);
    }

    static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            if (n % 2 == 1) count++;
            n /= 2;
        }
        return count;
    }

    static void subtract1(char[] s) {
        if (s[0] == '0') return;
        int n = s.length, i = n - 1;
        while (s[i] == '0') i--;
        s[i] = (char) ((s[i] - '0') + 47);
        for (int j = i + 1; j < n; j++) s[j] = '9';
    }

    static long pow(long a, long b, long mod) {
        long ans = 1;
        while (b > 0) {
            if (b % 2 == 1) ans = (ans * a) % mod;
            a = (a * a) % mod;
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

    static boolean isPalindrome(String s) {
        int n = s.length(), i1 = 0, i2 = n - 1;
        while (i1 < i2) {
            if (s.charAt(i1) != s.charAt(i2)) return false;
            i1++;
            i2--;
        }
        return true;
    }

    static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
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