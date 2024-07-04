import java.io.*;
import java.util.*;

public class Solution {
    FastScanner in;
    PrintWriter out;

    int[] convert(int[] was, int prevLen, int curLen) {
        int nfrom = Math.min(prevLen - was[1], curLen);
        int nto = Math.min(prevLen - was[0], curLen);
        if (nfrom >= nto) {
            return null;
        }
        return new int[]{nfrom, nto};
    }

    int[] go(int[] d, int[] start) {
        for (int it = 1; it < d.length; it++) {
            int[] next = convert(start, d[it - 1], d[it]);
            if (next == null) {
                return null;
            }
            start = next;
        }
        return convert(start, d[d.length - 1], d[0]);
    }

    int goIter(int[] d, int[] start, int ok) {
        if (ok == d.length - 1) {
            return d.length;
        }
        for (int it = ok + 1; it < d.length; it++) {
            int[] next = convert(start, d[it - 1], d[it]);
            if (next == null) {
                return it - 1;
            }
            start = next;
        }
        int[] foo = convert(start, d[d.length - 1], d[0]);
        if (foo == null) {
            return d.length - 1;
        } else {
            return d.length;
        }
    }

    int solveSplit2(int[] d) {
        int best = goIter(d, new int[]{0, d[0]}, 0);
        int left = 0, right = d[0];
        while (right - left > 1) {
            int mid = (left + right) >> 1;
            if (goIter(d, new int[]{mid, d[0]}, 0) == best) {
                left = mid;
            } else {
                right = mid;
            }
        }
        d[0] = left; // TODO: think?
        if (best == d.length) {
            return d.length + 1;
        }
        int over = 1;
        int from = best + 1;
        while (from != d.length) {
            over++;
            from = goIter(d, new int[]{0, d[from]}, from);
        }
        return d.length + over;
    }

    int solve(int len, int[] pos) {
        int n = pos.length;
        int[] d = new int[n];
        for (int i = 0; i + 1 < n; i++) {
            d[i] = pos[i + 1] - pos[i];
            len -= d[i];
        }
        d[d.length - 1] = len;
        int[] start = new int[]{0, d[0]};
        int[] go = go(d, start);
        if (go != null) {
            int[] go2 = go(d, go);
            if (go2 != null) {
                return pos.length;
            }
        }
        int answer = Integer.MAX_VALUE;
        for (int startSeg = 0; startSeg < pos.length; startSeg++) {
            int[] check = new int[pos.length];
            for (int i = 0; i < check.length; i++) {
                check[i] = d[(i + startSeg) % d.length];
            }
            int curAns = solveSplit2(check);
            answer = Math.min(answer, curAns);
        }
        return answer;
    }

    void solve() {
        int tc = in.nextInt();
        for (int t = 0; t < tc; t++) {
            int len = in.nextInt();
            int n = in.nextInt();
            int[] pos = new int[n];
            for (int i = 0; i < n; i++) {
                pos[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                in.nextInt();
            }
            out.println("Case #" + (t + 1) + ": " + solve(len, pos));
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