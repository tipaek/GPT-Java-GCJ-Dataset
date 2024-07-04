import java.io.*;
import java.util.*;

public class Solution {
    FastScanner in;
    PrintWriter out;

    class Edge {
        int to;
        int id;

        public Edge(int to, int id) {
            this.to = to;
            this.id = id;
        }
    }


    void solve() {
        int tc = in.nextInt();
        for (int t = 0; t < tc; t++) {
            int n = in.nextInt();
            int m = in.nextInt();
            List<Edge>[] g = new List[n];
            for (int i = 0; i < n; i++) {
                g[i] = new ArrayList<>();
            }
            int[] xs = new int[n];
            int maxTime = 0;
            for (int i = 1; i < n; i++) {
                xs[i] = in.nextInt();
                maxTime = Math.max(maxTime, xs[i]);
            }
            for (int i = 0; i < m; i++) {
                int fr = in.nextInt() - 1;
                int to = in.nextInt() - 1;
                g[fr].add(new Edge(to, i));
                g[to].add(new Edge(fr, i));
            }
            int[] whenReceive = new int[n];
            int[] res = new int[m];
            Arrays.fill(res, (int) 1e5);
            Arrays.fill(whenReceive, Integer.MAX_VALUE);
            whenReceive[0] = 0;
            int cntAlready = 1;
            for (int time = 1; time < maxTime + n + 5; time++) {
                int cntThisLayer = 0;
                for (int id = 0; id < n; id++) {
                    if (xs[id] == -cntAlready || xs[id] == time) {
                        setTime(res, whenReceive, time, g, id);
                        cntThisLayer++;
                    }
                }
                cntAlready += cntThisLayer;
            }
            if (cntAlready != n) {
                throw new AssertionError();
            }
            out.print("Case #" + (t + 1) + ":");
            for (int x : res) {
                out.print(" " + x);
            }
            out.println();
        }
    }

    void setTime(int[] res, int[] whenReceive, int curTime, List<Edge>[] g, int id) {
        whenReceive[id] = curTime;
        boolean ok = false;
        for (Edge e : g[id]) {
            if (whenReceive[e.to] < curTime) {
                res[e.id] = curTime - whenReceive[e.to];
                ok = true;
            }
        }
        if (!ok) {
            throw new AssertionError();
        }
    }


    void run() {
        try {
            in = new FastScanner(new File("Solution.in"));
            out = new PrintWriter(new File("Solution.out"));

            solve();

            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    void runIO() {

        in = new FastScanner(System.in);
        out = new PrintWriter(System.out);

        solve();

        out.close();
    }

    class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(File f) {
            try {
                br = new BufferedReader(new FileReader(f));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public FastScanner(InputStream f) {
            br = new BufferedReader(new InputStreamReader(f));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                String s = null;
                try {
                    s = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (s == null)
                    return null;
                st = new StringTokenizer(s);
            }
            return st.nextToken();
        }

        boolean hasMoreTokens() {
            while (st == null || !st.hasMoreTokens()) {
                String s = null;
                try {
                    s = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (s == null)
                    return false;
                st = new StringTokenizer(s);
            }
            return true;
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
    }

    public static void main(String[] args) {
        new Solution().runIO();
    }
}