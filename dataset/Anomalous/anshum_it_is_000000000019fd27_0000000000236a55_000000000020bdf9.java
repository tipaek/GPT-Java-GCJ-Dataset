import java.io.*;
import java.util.*;

class Pair implements Comparable<Pair> {
    int u, v;

    public Pair(int x, int y) {
        u = x;
        v = y;
    }

    public Pair() {}

    @Override
    public int compareTo(Pair p) {
        return Integer.compare(this.u, p.u);
    }
}

public class Solution {
    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        new Thread(null, new Runnable() {
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

    public static void solve() throws Exception {
        MyScanner scanner = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int t = scanner.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            int n = scanner.nextInt();
            Pair[] activities = new Pair[n];
            for (int i = 0; i < n; i++) {
                activities[i] = new Pair(scanner.nextInt(), scanner.nextInt());
            }
            Arrays.sort(activities);

            StringBuilder ans = new StringBuilder("C");
            int prevC = activities[0].v;
            int prevJ = 0;
            boolean impossible = false;

            for (int i = 1; i < n; i++) {
                if (prevC <= prevJ && activities[i].u >= prevC) {
                    ans.append("C");
                    prevC = activities[i].v;
                } else if (prevJ <= prevC && activities[i].u >= prevJ) {
                    ans.append("J");
                    prevJ = activities[i].v;
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                ans = new StringBuilder("IMPOSSIBLE");
            }

            out.println("Case #" + tc + ": " + ans);
        }
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