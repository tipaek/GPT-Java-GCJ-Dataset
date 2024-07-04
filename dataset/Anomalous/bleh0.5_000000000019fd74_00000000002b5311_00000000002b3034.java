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
            StringBuilder start = new StringBuilder();
            StringBuilder mid = new StringBuilder();
            StringBuilder end = new StringBuilder();
            String ans = "";
            
            outerLoop:
            for (int i = 0; i < n; i++) {
                String str = sc.next();
                int k = str.length();
                int l = 0;
                int r = k - 1;
                StringBuilder prefix = new StringBuilder();
                for (; l < k; l++) {
                    if (str.charAt(l) == '*') break;
                    prefix.append(str.charAt(l));
                }
                for (int j = 0; j < Math.min(prefix.length(), start.length()); j++) {
                    if (start.charAt(j) != prefix.charAt(j)) {
                        ans = "*";
                        break outerLoop;
                    }
                }
                StringBuilder suffix = new StringBuilder();
                for (; r >= 0; r--) {
                    if (str.charAt(r) == '*') break;
                    suffix.append(str.charAt(r));
                }
                for (int j = 0; j < Math.min(suffix.length(), end.length()); j++) {
                    if (end.charAt(j) != suffix.charAt(j)) {
                        ans = "*";
                        break outerLoop;
                    }
                }
                if (prefix.length() > start.length()) start = prefix;
                if (suffix.length() > end.length()) end = suffix;
                for (; l < r; l++) {
                    if (str.charAt(l) != '*') mid.append(str.charAt(l));
                }
            }

            if (ans.isEmpty()) {
                ans = start.toString() + mid.toString() + end.reverse().toString();
            }
            pw.printf("Case #%d: %s%n", testNumber, ans);
        }
    }

    static long binpow(long a, long b, long m) {
        a %= m;
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res = res * a % m;
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
        Random rand = new Random();
        for (int i = 0; i < a.length; i++) {
            int r = rand.nextInt(a.length);
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    static void shuffle(long[] a) {
        Random rand = new Random();
        for (int i = 0; i < a.length; i++) {
            int r = rand.nextInt(a.length);
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