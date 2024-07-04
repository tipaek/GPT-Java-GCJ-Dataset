
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Throwable {

        Scanner sc = new Scanner();
        PrintWriter pw = new PrintWriter(System.out);

        int t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {

            int n = sc.nextInt();
            pair[] a = new pair[n];
            for (int i = 0; i < n; i++)
                a[i] = new pair(i, sc.nextInt(), sc.nextInt());
            Arrays.sort(a);
            int end1 = 0, end2 = 0;
            boolean ok = true;
            char[] ans = new char[n];
            for (pair p : a) {
                int idx = p.idx;
                int x = p.x;
                int y = p.y;
                if (x >= end1) {
                    ans[idx] = 'C';
                    end1 = y;
                } else if (x >= end2) {
                    ans[idx] = 'J';
                    end2 = y;
                } else
                    ok = false;
            }
            String out = ok ? new String(ans) : "IMPOSSIBLE";

            pw.printf("Case #%d: %s\n", tc, out);
        }

        pw.close();
    }

    static class pair implements Comparable<pair> {
        int x, y, idx;

        pair(int idx, int x, int y) {
            this.idx = idx;
            this.x = x;
            this.y = y;
        }

        public int compareTo(pair p) {
            return x - p.x;
        }
    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        Scanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        Scanner(String s) throws Throwable {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() throws Throwable {
            if (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        int nextInt() throws Throwable {
            return Integer.parseInt(next());
        }

        long nextLong() throws Throwable {
            return Long.parseLong(next());
        }

    }

}