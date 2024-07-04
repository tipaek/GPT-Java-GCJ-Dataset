import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public class A {
    //Solution by Sathvik Kuthuru
    public static void main(String[] args) {
        FastReader scan = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        Task solver = new Task();
        int t = scan.nextInt();
        for(int tt = 1; tt <= t; tt++) solver.solve(tt, scan, out);
        out.close();
    }

    static class Solution {

        public void solve(int testNumber, FastReader scan, PrintWriter out) {
            out.printf("Case: #%d ", testNumber);
            int n = scan.nextInt(), d = scan.nextInt();
            long[] a = new long[n];
            for(int i = 0; i < n; i++) a[i] = scan.nextLong() * d * 100;
            Arrays.sort(a);
            long best = Long.MAX_VALUE;
            for(int i = 0; i < n; i++) {
                long curr = 0;
                long have = 0;
                boolean[] used = new boolean[n];
                for(int j = 0; j < n; j++) {
                    if(have >= d) break;
                    long add = Math.min(d - have, a[j] / a[i]);
                    have += add;
                    curr += a[i] * add == a[j] ? add - 1 : add;
                }
                if(have >= d) best = Math.min(best, curr);
            }
            if(best != Long.MAX_VALUE) {
                out.println(best);
                return;
            }
            long low = 1, high = a[0], ans = -1;
            while(low <= high) {
                long mid = low + (high - low) / 2;
                long curr = 0, have = 0;
                for(int i = 0; i < n; i++) {
                    if(have >= d) break;
                    long add = Math.min(d - have, a[i] / mid);
                    have += add;
                    curr += mid * add == a[i] ? add - 1 : add;
                }
                if(have >= d) {
                    ans = curr;
                    low = mid + 1;
                }
                else high = mid - 1;
            }
            out.println(ans);
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