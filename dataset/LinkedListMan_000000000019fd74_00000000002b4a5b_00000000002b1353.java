import java.io.*;
import java.util.Random;
import java.util.StringTokenizer;

public class Solution {
    //Solution by Sathvik Kuthuru
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
            out.printf("Case #%d:\n", testNumber);
            int n = scan.nextInt();
            out.println("1 1");
            if(n > 1) {
                n--;
                int sum = 0;
                int at = 1;
                while(true) {
                    out.println((at + 1) + " " + 2);
                    sum += at;
                    at++;
                    if(sum + at > n) break;
                }
                int left = n - sum;
                for(int i = 0; i < left; i++) {
                    out.println(at + " " + 1);
                    at--;
                }
            }
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