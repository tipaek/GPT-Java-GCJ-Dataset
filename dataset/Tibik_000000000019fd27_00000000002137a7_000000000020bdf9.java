import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
    static StringTokenizer st;
    static BufferedReader br;
    static PrintWriter pw;

    static String nextToken() {
        try {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return st.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(nextToken());
    }

    public static void main(String[] args) {
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
        run();
        pw.close();
    }

    private static void run() {
        int t = nextInt();
        for (int i = 0; i < t; i++) {
            int n = nextInt();
            ArrayList<Pair> pairs = new ArrayList<>(n * 2);
            for (int j = 0; j < n; j++) {
                pairs.add(new Pair(nextInt(), nextInt(), j));
            }
            int[] free = new int[2];
            Collections.sort(pairs);
            int[] ans = new int[n];
            pw.print("Case #" + (i + 1) + ": ");
            boolean tr = false;
            for (int j = 0; j < pairs.size(); j++) {
                tr = false;
                Pair p = pairs.get(j);
                for (int k = 0; k < free.length; k++) {
                    if (free[k] <= p.x) {
                        free[k] = p.y;
                        ans[p.c] = k;
                        tr = true;
                        break;
                    }
                }
                if (!tr) {
                    pw.print("IMPOSSIBLE");
                    break;
                }
            }
            for (int j = 0; j < ans.length && tr; j++) {
                if (ans[j] == 0) {
                    pw.print("C");
                } else {
                    pw.print("J");
                }
            }
            pw.println();
        }
    }

    static class Pair implements Comparable<Pair> {
        int x;
        int y;
        int c;

        public Pair(int x, int y, int c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }

        @Override
        public int compareTo(Pair o) {
            if (o.x != x) return Integer.compare(x, o.x);
            return Integer.compare(y, o.y);
        }
    }

}
