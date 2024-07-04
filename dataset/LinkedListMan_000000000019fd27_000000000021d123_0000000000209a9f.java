import java.io.*;
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
            char[] s = scan.next().toCharArray();
            out.printf("Case #%d: ", testNumber);
            for(int i = 0; i < s.length; i++) {
                int now = s[i] - '0';
                if(i == 0) {
                    for(int j = 0; j < now; j++) out.print('(');
                }
                else {
                    int prev = s[i - 1] - '0';
                    if(now >= prev) {
                        for(int j = 0; j < now - prev; j++) out.print('(');
                    }
                    else {
                        for(int j = 0; j < prev - now; j++) out.print(')');
                    }
                }
                out.print(s[i]);
                if(i == s.length - 1) {
                    for(int j = 0; j < now; j++) out.print(')');
                }
            }
            out.println();
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