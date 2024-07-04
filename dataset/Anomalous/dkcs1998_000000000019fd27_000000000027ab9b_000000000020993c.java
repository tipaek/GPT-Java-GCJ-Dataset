import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.StringTokenizer;

public class CJ_2020_Qualifier_1 {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
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
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            int duplicateRows = 0;
            for (int i = 0; i < n; i++) {
                HashSet<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (rowSet.contains(matrix[i][j])) {
                        duplicateRows++;
                        break;
                    }
                    rowSet.add(matrix[i][j]);
                }
            }

            int duplicateCols = 0;
            for (int i = 0; i < n; i++) {
                HashSet<Integer> colSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (colSet.contains(matrix[j][i])) {
                        duplicateCols++;
                        break;
                    }
                    colSet.add(matrix[j][i]);
                }
            }

            System.out.println("Case #" + kt + ": " + trace + " " + duplicateRows + " " + duplicateCols);
        }
    }
}