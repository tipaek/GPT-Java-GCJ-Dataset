import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        FastReader scan = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        Task solver = new Task();
        int t = scan.nextInt();
        for (int i = 1; i <= t; i++) {
            solver.solve(i, scan, out);
        }
        out.close();
    }

    static class Task {
        static final int INF = Integer.MAX_VALUE;

        public void solve(int testNumber, FastReader sc, PrintWriter pw) {
            int n = sc.nextInt();
            int originalN = n;
            n = Math.max(n - 50, 0);
            int steps = 0;
            int i = 0;
            int direction = 0;
            pw.println("Case #" + testNumber + ":");
            
            for (i = 0; (1 << i) < n; i++) {
                if (((1 << i) & n) > 0) {
                    if (direction > 0) {
                        for (int j = i + 1; j > 0; j--) {
                            pw.println((i + 1) + " " + j);
                        }
                    } else {
                        for (int j = 1; j <= i + 1; j++) {
                            pw.println((i + 1) + " " + j);
                        }
                    }
                    steps += (1 << i);
                    direction ^= 1;
                } else {
                    if (direction > 0) {
                        pw.println((i + 1) + " " + (i + 1));
                    } else {
                        pw.println((i + 1) + " 1");
                    }
                    steps++;
                }
            }

            while (steps++ < originalN) {
                if (direction > 0) {
                    pw.println((i + 1) + " " + (i + 1));
                } else {
                    pw.println((i + 1) + " 1");
                }
                i++;
            }
        }
    }

    static long binpow(long a, long b, long m) {
        a %= m;
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = res * a % m;
            }
            a = a * a % m;
            b >>= 1;
        }
        return res;
    }

    static void sort(int[] x) {
        shuffle(x);
        Arrays.sort(x);
    }

    static void sort(long[] x) {
        shuffle(x);
        Arrays.sort(x);
    }

    static class Tuple implements Comparable<Tuple> {
        int a, b;

        Tuple(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Tuple o) {
            return Integer.compare(o.b, b);
        }
    }

    static void shuffle(int[] a) {
        Random random = new Random();
        for (int i = 0; i < a.length; i++) {
            int r = random.nextInt(a.length);
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    static void shuffle(long[] a) {
        Random random = new Random();
        for (int i = 0; i < a.length; i++) {
            int r = random.nextInt(a.length);
            long temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
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