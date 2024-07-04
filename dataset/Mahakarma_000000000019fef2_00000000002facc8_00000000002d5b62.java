import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import javafx.util.Pair;

public class Solution {

    static Map<Pair<Long, Long>, String> dest = new HashMap<>();

    public static void main(String[] args) throws Exception {
        long startTime = System.nanoTime();
        solve();
        long endTime = System.nanoTime();
        err.println("Execution Time : +" + (endTime - startTime) / 1000000 + " ms");
        exit(0);
    }

    static void solve() {
        int t = in.nextInt();
        process(0, 0, 0, "");
        for(int q=1;q<=t;q++) {
            long X = in.nextLong();
            long Y = in.nextLong();
            String res = dest.getOrDefault(make_pair(X, Y), "IMPOSSIBLE");
            out.println(get(q,res));
        }
    }

    static String get(Object... args) {
        String res = "Case #" + args[0] + ":";
        for (int i = 1; i < args.length; i++) {
            res += " ";
            res += args[i];
        }
        return res;
    }

    static void process(long x, long y, int i, String path) {
        if (x > 150 || y > 150 || x < -150 || y < -150) {
            return;
        }
        long dep = (long) Math.pow(2L, i);
        update(x, y + dep, i, path + "N");
        process(x, y + dep, i + 1, path + "N");
        update(x + dep, y, i, path + "E");
        process(x + dep, y, i + 1, path + "E");
        update(x - dep, y, i, path + "W");
        process(x - dep, y, i + 1, path + "W");
        update(x, y - dep, i, path + "S");
        process(x, y - dep, i + 1, path + "S");
    }

    static void update(long x, long y, int i, String path) {
        Pair<Long, Long> temp = make_pair(x, y);
        if (dest.containsKey(temp)) {
            String a = dest.get(temp);
            if (a.length() > path.length()) {
                dest.put(temp, path);
            }
            return;
        }
        dest.put(temp, path);
    }

    static void print(Object... args) {
        for (Object a : args) {
            out.print(a + " ");
        }
        out.println("");
    }

    static <T, R> Pair<T, R> make_pair(T a, R b) {
        return new Pair<>(a, b);
    }

    static class StringUtils {
        static char[] constructReverseWithHash(String s) {
            char[] a = s.toCharArray();
            char[] b = ArrayUtils.reverse(s.toCharArray());
            char[] c = new char[a.length + b.length + 1];
            System.arraycopy(a, 0, c, 0, a.length);
            c[a.length] = '#';
            System.arraycopy(b, 0, c, a.length + 1, b.length);
            return c;
        }

        static String reverse(String s) {
            return constructStringFromChars(ArrayUtils.reverse(s.toCharArray()), 0, s.length());
        }

        static String constructStringFromChars(char[] d, int from, int to) {
            StringBuilder res = new StringBuilder();
            for (int i = from; i < to; i++) {
                res.append(d[i]);
            }
            return res.toString();
        }

        static String constructStringFromInts(int[] d, int from, int to) {
            StringBuilder res = new StringBuilder();
            for (int i = from; i < to; i++) {
                res.append(d[i]);
            }
            return res.toString();
        }

        static int[] prefix_function(char[] s) {
            int n = s.length;
            int[] pi = new int[n];
            for (int i = 1; i < n; i++) {
                int j = pi[i - 1];
                while (j > 0 && s[i] != s[j])
                    j = pi[j - 1];
                if (s[i] == s[j]) {
                    j++;
                }
                pi[i] = j;
            }
            return pi;
        }
    }

    static class NumberTheory {

        static ArrayList<Integer>[] getDivisors(int n) {
            ArrayList<Integer>[] d = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                d[i] = new ArrayList<>();
            }
            for (int i = 1; i <= n; i++) {
                for (int j = i; j <= n; j += i) {
                    d[j].add(i);
                }
            }
            return d;
        }

        static long mod_pow(long x, long y, long MOD) {
            if (y == 0) {
                return 1;
            }
            if (y == 1) {
                return x;
            }
            long v = mod_pow(x, y / 2, MOD);
            if ((y & 1) > 0) {
                return v * v % MOD * x % MOD;
            }
            return v * v % MOD;
        }

        static int gcd(int a, int b) {
            while (b != 0) {
                int t = b;
                b = a % b;
                a = t;
            }
            return a;
        }

        //GCD Long
        static long gcd(long a, long b) {
            while (b != 0) {
                long t = b;
                b = a % b;
                a = t;
            }
            return a;
        }

    }

    static class ArrayUtils {

        static int[] reverse(int[] data) {
            int[] p = new int[data.length];
            for (int i = 0, j = data.length - 1; i < data.length; i++, j--) {
                p[i] = data[j];
            }
            return p;
        }

        static char[] reverse(char[] data) {
            char[] p = new char[data.length];
            for (int i = 0, j = data.length - 1; i < data.length; i++, j--) {
                p[i] = data[j];
            }
            return p;
        }

        static int[] MegreSort(int[] A) {
            if (A.length > 1) {
                int q = A.length / 2;
                int[] left = new int[q];
                int[] right = new int[A.length - q];
                System.arraycopy(A, 0, left, 0, q);
                System.arraycopy(A, q, right, 0, A.length - q);
                int[] left_sorted = MegreSort(left);
                int[] right_sorted = MegreSort(right);
                return Megre(left_sorted, right_sorted);
            } else {
                return A;
            }
        }

        static int[] Megre(int[] left, int[] right) {
            int[] A = new int[left.length + right.length];
            int i = 0;
            int j = 0;
            for (int k = 0; k < A.length; k++) {
                // To handle left becoming empty
                if (i == left.length && j < right.length) {
                    A[k] = right[j];
                    j++;
                    continue;
                }
                // To handle right becoming empty
                if (j == right.length && i < left.length) {
                    A[k] = left[i];
                    i++;
                    continue;
                }
                if (left[i] <= right[j]) {
                    A[k] = left[i];
                    i++;
                } else {
                    A[k] = right[j];
                    j++;
                }
            }
            return A;
        }

        static long[] MegreSort(long[] A) {
            if (A.length > 1) {
                int q = A.length / 2;
                long[] left = new long[q];
                long[] right = new long[A.length - q];
                System.arraycopy(A, 0, left, 0, q);
                System.arraycopy(A, q, right, 0, A.length - q);
                long[] left_sorted = MegreSort(left);
                long[] right_sorted = MegreSort(right);
                return Megre(left_sorted, right_sorted);
            } else {
                return A;
            }
        }

        static long[] Megre(long[] left, long[] right) {
            long[] A = new long[left.length + right.length];
            int i = 0;
            int j = 0;
            for (int k = 0; k < A.length; k++) {
                // To handle left becoming empty
                if (i == left.length && j < right.length) {
                    A[k] = right[j];
                    j++;
                    continue;
                }
                // To handle right becoming empty
                if (j == right.length && i < left.length) {
                    A[k] = left[i];
                    i++;
                    continue;
                }
                if (left[i] <= right[j]) {
                    A[k] = left[i];
                    i++;
                } else {
                    A[k] = right[j];
                    j++;
                }
            }
            return A;
        }
    }

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

        public int[] readAllInts(int n) {
            int[] p = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = in.nextInt();
            }
            return p;
        }

        public int[] readAllInts(int n, int s) {
            int[] p = new int[n + s];
            for (int i = s; i < n + s; i++) {
                p[i] = in.nextInt();
            }
            return p;
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
