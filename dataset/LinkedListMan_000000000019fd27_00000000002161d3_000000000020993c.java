import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        FastReader scan = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        Task solver = new Task();
        int t = scan.nextInt();
        for(int tt = 1; tt <= t; tt++) solver.solve(tt, scan, out);
        out.close();
    }

    static class Task {

        public void solve(int testNumber, FastReader scan, PrintWriter out) {
            int n = scan.nextInt();
            int[][] a = new int[n][n];
            int k = 0, r = 0, c = 0;
            for(int i = 0; i < n; i++) {
                HashSet<Integer> h = new HashSet<>();
                boolean f = false;
                for(int j = 0; j < n; j++) {
                    a[i][j] = scan.nextInt();
                    if(h.contains(a[i][j])) f = true;
                    else h.add(a[i][j]);
                }
                if(f) r++;
                k += a[i][i];
            }
            for(int i = 0; i < n; i++) {
                HashSet<Integer> h = new HashSet<>();
                boolean f = false;
                for(int j = 0; j < n; j++) {
                    if(h.contains(a[j][i])) f = true;
                    else h.add(a[j][i]);
                }
                if(f) c++;
            }
            out.printf("Case #%d: %d %d %d\n", testNumber, k, r, c);
        }

    }

    static void shuffle(int[] a) {
        Random get = new Random();
        for (int i = 0; i < a.length; i++) {
            int r = get.nextInt(a.length);
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    static void shuffle(long[] a) {
        Random get = new Random();
        for (int i = 0; i < a.length; i++) {
            int r = get.nextInt(a.length);
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