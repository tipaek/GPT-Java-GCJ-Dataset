import java.io.*;
import java.util.*;

class Pair {
    int u, v;

    public Pair(int x, int y) {
        u = x;
        v = y;
    }

    public Pair() {
    }
}

public class Solution {
    public static int gcd(int a, int b) {
        if (a < b)
            return gcd(b, a);
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) throws Exception {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    solve();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }, "Anshum Gupta", 1 << 26).start();
    }

    public static void solve() throws Exception {
        MyScanner s = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int t = s.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            String str = s.next();
            StringBuilder ans = new StringBuilder();
            int cnt = 0;
            for (int i = 0; i < str.length(); i++) {
                int cur = str.charAt(i) - '0';
                if (cur > cnt) {
                    ans.append("(".repeat(cur - cnt));
                    ans.append(str.charAt(i));
                    cnt = cur;
                } else if (cur == cnt) {
                    ans.append(str.charAt(i));
                } else {
                    ans.append(")".repeat(cnt - cur));
                    ans.append(str.charAt(i));
                    cnt = cur;
                }
            }
            ans.append(")".repeat(cnt));
            out.println("Case #" + tc + ": " + ans);
        }
        out.flush();
        out.close();
    }

    //-----------MyScanner class for faster input----------
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