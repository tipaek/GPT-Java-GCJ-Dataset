import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {

    static boolean[] C = new boolean[24 * 61];
    static boolean[] J = new boolean[24 * 61];
    static Interval[] intervals;
    static int n;

    public static void main(String[] args) throws Exception {
        long startTime = System.nanoTime();
        int t = in.nextInt();

        for (int q = 1; q <= t; q++) {
            n = in.nextInt();
            intervals = new Interval[n];
            for (int i = 0; i < n; i++) {
                intervals[i] = new Interval(in.nextInt(), in.nextInt(), i);
            }
            Arrays.sort(intervals, l);
            String res = process();

            out.println(get(q, res));

        }
        long endTime = System.nanoTime();
        err.println("Execution Time : +" + (endTime - startTime) / 1000000 + " ms");
        exit(0);
    }

    static String process() {
        Arrays.fill(C, true);
        Arrays.fill(J, true);
        String[] res = new String[n];
        String out = "";
        for (int i = 0; i < n; i++) {
            if (isC(intervals[i])) {
                UseC(intervals[i]);
                res[intervals[i].index] = "C";
            } else if (isJ(intervals[i])) {
                UseJ(intervals[i]);
                res[intervals[i].index] = "J";
            } else {
                return "IMPOSSIBLE";

            }
        }
        for (int i = 0; i < n; i++) {
            out += res[i];
        }
        return out;
    }

    static String get(Object... args) {
        String res = "Case #" + args[0] + ":";
        for (int i = 1; i < args.length; i++) {
            res += " ";
            res += args[i];
        }
        return res;
    }

    static boolean isC(Interval I) {
        for (int i = I.l; i < I.r; i++) {
            if (!C[i]) {
                return false;
            }
        }
        return true;
    }

    static void UseC(Interval I) {
        for (int i = I.l; i < I.r; i++) {
            C[i] = false;
        }

    }

    static void UseJ(Interval I) {
        for (int i = I.l; i < I.r; i++) {
            J[i] = false;
        }
    }

    static boolean isJ(Interval I) {
        for (int i = I.l; i < I.r; i++) {
            if (!J[i]) {
                return false;
            }
        }
        return true;
    }

    static class Interval {
        int l;
        int r;
        int index;

        public Interval(int a, int b, int ind) {
            l = a;
            r = b;
            index = ind;
        }

        public String toString() {
            return l + " " + r;
        }
    }

    static Comparator<Interval> l = (e1, e2) -> {
        if (e1.l == e2.l) {
            return 0;
        }
        if (e1.l > e2.l) {
            return 1;
        }
        if (e1.l < e2.l) {
            return -1;
        }
        return 0;
    };

    static Comparator<Interval> r = (e1, e2) -> {
        if (e1.r == e2.r) {
            return 0;
        }
        if (e1.r > e2.r) {
            return 1;
        }
        if (e1.r < e2.r) {
            return -1;
        }
        return 0;
    };

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    static void exit(int a) {
        out.close();
        err.close();
        System.exit(a);
    }

    static InputStream inputStream = System.in;
    static OutputStream outputStream = System.out;
    static OutputStream errStream = System.err;
    static InputReader in = new InputReader(inputStream);
    static PrintWriter out = new PrintWriter(outputStream);
    static PrintWriter err = new PrintWriter(errStream);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

}
