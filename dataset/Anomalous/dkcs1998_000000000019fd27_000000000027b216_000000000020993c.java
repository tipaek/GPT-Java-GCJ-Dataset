import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {

    static class FastReader {

        private final BufferedReader br;
        private StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        private String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static class Var {

        int a, b;

        Var(int x, int y) {
            this.a = x;
            this.b = y;
        }
    }

    static class Comp implements Comparator<Var> {

        @Override
        public int compare(Var o1, Var o2) {
            return Integer.compare(o2.b, o1.b);
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();

        for (int kt = 1; kt <= t; kt++) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = sc.nextInt();
                }
            }

            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += a[i][i];
            }

            int countR = 0, countC = 0;
            for (int i = 0; i < n; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(a[i][j])) {
                        countR++;
                        break;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!colSet.add(a[j][i])) {
                        countC++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + kt + ": " + sum + " " + countR + " " + countC);
        }
    }
}