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
                pairs.add(new Pair(nextInt(), nextInt()));
            }
            int[] free = new int[2];
            Collections.sort(pairs);
            ArrayList<Integer> ans = new ArrayList<>(n * 2);
            pw.print("Case #" + (i + 1) + ": ");
            for (int j = 0; j < pairs.size(); j++) {
                boolean tr = false;
                Pair p = pairs.get(j);
                for (int k = 0; k < free.length; k++) {
                    if (free[k] <= p.x) {
                        free[k] = p.y;
                        ans.add(k);
                        tr = true;
                        break;
                    }
                }
                if (!tr) {
                    ans.clear();
                    pw.print("IMPOSSIBLE");
                    break;
                }
            }
            for (int j = 0; j < ans.size(); j++) {
                if(ans.get(j) == 0){
                    pw.print("C");
                }else {
                    pw.print("J");
                }
            }
            pw.println();
        }
    }

    static class Pair implements Comparable<Pair> {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair o) {
            if (o.x != x) return Integer.compare(x, o.x);
            return Integer.compare(y, o.y);
        }
    }

}
