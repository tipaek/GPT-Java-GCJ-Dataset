import java.io.*;
import java.util.*;

public class Solution {
    FastScanner in;
    PrintWriter out;

    void solve() {
        int tc = in.nextInt();
        for (int t = 0; t < tc; t++) {
            int intervals = in.nextInt();
            Interval[] a = new Interval[intervals];
            for (int i = 0; i < a.length; i++) {
                a[i] = new Interval(in.nextInt(), in.nextInt(), i);
            }
            Arrays.sort(a);
            int[] lastTime = new int[2];
            char[] res = new char[intervals];
            boolean ok = true;
            for (Interval in : a) {
                if (lastTime[0] <= in.fr) {
                    res[in.id] = 'C';
                    lastTime[0] = in.to;
                } else if (lastTime[1] <= in.fr) {
                    res[in.id] = 'J';
                    lastTime[1] = in.to;
                } else {
                    ok = false;
                    break;
                }
            }
            out.print("Case #" + (t + 1) + ": ");
            if (ok) {
                out.println(new String(res));
            } else {
                out.println("IMPOSSIBLE");
            }
        }
    }

    class Interval implements Comparable<Interval> {
        int fr, to;
        int id;

        public Interval(int fr, int to, int id) {
            this.fr = fr;
            this.to = to;
            this.id = id;
        }

        @Override
        public int compareTo(Interval interval) {
            return Integer.compare(fr, interval.fr);
        }
    }

    void run() {
        try {
            in = new FastScanner(new File("Main.in"));
            out = new PrintWriter(new File("Main.out"));

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