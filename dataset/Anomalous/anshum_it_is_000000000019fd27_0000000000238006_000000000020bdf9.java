import java.io.*;
import java.util.*;

class Pair implements Comparable<Pair> {
    int u, v, index;

    public Pair(int u, int v, int index) {
        this.u = u;
        this.v = v;
        this.index = index;
    }

    @Override
    public int compareTo(Pair other) {
        return Integer.compare(this.u, other.u);
    }
}

public class Solution {
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        new Thread(null, null, "Anshum Gupta", 99999999) {
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

    public static void solve() throws Exception {
        MyScanner scanner = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int t = scanner.nextInt();
        int tc = 1;

        while (tc <= t) {
            int n = scanner.nextInt();
            Pair[] activities = new Pair[n];

            for (int i = 0; i < n; i++) {
                activities[i] = new Pair(scanner.nextInt(), scanner.nextInt(), i);
            }

            Arrays.sort(activities);
            char[] schedule = new char[n];
            boolean possible = true;

            int endC = 0, endJ = 0;

            for (Pair activity : activities) {
                if (activity.u >= endC) {
                    schedule[activity.index] = 'C';
                    endC = activity.v;
                } else if (activity.u >= endJ) {
                    schedule[activity.index] = 'J';
                    endJ = activity.v;
                } else {
                    possible = false;
                    break;
                }
            }

            String result = possible ? new String(schedule) : "IMPOSSIBLE";
            out.println("Case #" + tc + ": " + result);
            tc++;
        }
        out.close();
    }

    static class MyScanner {
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