import java.io.*;
import java.util.Arrays;
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
        int a, b;
        int[][][] dp, next[];
        static final int MAX = 15, MAX2 = 200;

        public void solve(int testNumber, FastReader scan, PrintWriter out) {
            out.printf("Case #%d: ", testNumber);
            a = scan.nextInt() + 100;
            b = scan.nextInt() + 100;
            dp = new int[MAX + 1][MAX2][MAX2];
            next = new int[MAX + 1][MAX2][MAX2][2];
            for(int i = 0; i <= 15; i++) {
                for(int j = 0; j < MAX2; j++) {
                    Arrays.fill(dp[i][j], -1);
                }
            }
            int ans = go(0, 100, 100);
            if(ans >= 1000) {
                out.println("IMPOSSIBLE");
                return;
            }
            int w = 100, h = 100;
            int at = 0;
            while(!(w == a && h == b)) {
                int ww = next[at][w][h][0], hh = next[at][w][h][1];
                if(ww != w) {
                    if(ww > w) out.print('E');
                    else out.print('W');
                }
                else {
                    out.print(hh > h ? 'N' : 'S');
                }
                w = ww;
                h = hh;
                at++;
            }
            out.println();
        }

        int go(int at, int w, int h) {
            if(w == a && h == b) return at - 1;
            if(at > MAX || h < 0 || w < 0 || h >= MAX2 || w >= MAX2) return 1000;
            if(dp[at][w][h] != -1) return dp[at][w][h];
            int best = 1000;
            int add = 1 << at;
            int east = go(at + 1, w + add, h), west = go(at + 1, w - add, h);
            int north = go(at + 1, w, h + add), south = go(at + 1, w, h - add);
            int ans = east;
            next[at][w][h][0] = w + add;
            next[at][w][h][1] = h;
            if(west < ans) {
                next[at][w][h][0] = w - add;
                next[at][w][h][1] = h;
                ans = west;
            }
            if(north < ans) {
                next[at][w][h][0] = w;
                next[at][w][h][1] = h + add;
                ans = north;
            }
            if(south < ans) {
                next[at][w][h][0] = w;
                next[at][w][h][1] = h - add;
                ans = south;
            }
            return dp[at][w][h] = ans;
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