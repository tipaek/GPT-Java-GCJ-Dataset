import java.io.*;
import java.util.*;

public class Solution {
    private static final long MOD = 1000000007;
    private static final int OFFSET = -1000000000;
    private StringBuilder sb = new StringBuilder();
    private static PrintWriter out;

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        int t = sc.nextInt();
        for (int tt = 1; tt <= t; tt++) {
            out.print("Case #" + tt + ": ");
            int C = sc.nextInt();
            int D = sc.nextInt();

            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
            int[] order = new int[C + 1];
            int[] time = new int[C + 1];
            int[][] edges = new int[D][2];
            int[] res = new int[D];

            for (int i = 2; i <= C; i++) {
                order[i] = -sc.nextInt();
                map.computeIfAbsent(order[i], k -> new ArrayList<>()).add(i);
            }

            for (int i = 0; i < D; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                res[i] = Math.max(1, Math.abs(order[u] - order[v]));
                out.print(res[i] + " ");
            }
            out.println();
        }
        out.close();
    }

    public int solve(MyScanner sc) {
        return 0;
    }

    //-----------MyScanner class for faster input----------
    public static class MyScanner {
        private BufferedReader br;
        private StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
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